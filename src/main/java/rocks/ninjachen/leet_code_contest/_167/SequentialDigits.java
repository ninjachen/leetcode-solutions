package rocks.ninjachen.leet_code_contest._167;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/contest/weekly-contest-167/problems/sequential-digits/
 */
public class SequentialDigits {
        public List<Integer> sequentialDigits(int low, int high) {
            int lowLen = 0, highLen = 0;
            int lowFirstDigit = 0, highFirstDigit = 0;
            int tmp = low;
            while(tmp > 0) {
                if(tmp < 10)
                    lowFirstDigit = tmp;
                tmp = tmp /10;
                lowLen++;
            }
            tmp = high;
            while(tmp > 0) {
                // if(tmp < 10)
                // highFirstDigit = tmp;
                tmp = tmp /10;
                highLen++;
            }
            List<Integer> result = new ArrayList<>();
            for(int len = lowLen; len <= highLen; len++, lowFirstDigit = 1) {
                for (int firstDigit = lowFirstDigit; firstDigit <= 9; firstDigit++) {
                    int num = generator(firstDigit, len);
                    if(num == -1 || num < low) {
                        continue;
                    } else if (num > high) {
                        return result;
                    } else {
                        result.add(num);
                    }
                }
            }
            return result;
        }

        private int generator(int firstDigit, int len) {
            int[] arr = new int[len];
            for (int i = 0; i< len; i++) {
                if (firstDigit >= 10)
                    return -1;
                arr[i] = firstDigit++;
            }
            int num = 0;
            for (int i = 0; i < len; i++) {
                num  = num * 10 + arr[i];
            }
            return num;
        }

}
