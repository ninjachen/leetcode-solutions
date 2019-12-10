package rocks.ninjachen.leet_code_contest._165;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/contest/weekly-contest-165/problems/number-of-burgers-with-no-waste-of-ingredients/
 */
public class NumOfBurgers {
        public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
            List<Integer> result = new ArrayList<>();
            if (tomatoSlices % 2 == 1)
                return new ArrayList<>();
            int total = cheeseSlices;
            int jumboNum = 0;
            // smallNum == total - jumboNum;
            for (; jumboNum < total; jumboNum++) {
                if (tomatoSlices == jumboNum * 4 + (total - jumboNum) * 2) {
                    return Arrays.asList(jumboNum, total - jumboNum);
                }
            }
            if (tomatoSlices == jumboNum * 4 + (total - jumboNum) * 2) {
                return Arrays.asList(jumboNum, total - jumboNum);
            } else {
                return new ArrayList<>();
            }
        }
}
