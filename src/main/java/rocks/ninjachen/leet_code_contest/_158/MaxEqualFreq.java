package rocks.ninjachen.leet_code_contest._158;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/contest/weekly-contest-158/problems/maximum-equal-frequency/
 */
public class MaxEqualFreq {
    public int maxEqualFreq(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        // Scan all
        for (int n : nums) {
            int occurrences = map.getOrDefault(n, 0);
            map.put(n, occurrences + 1);
        }
        // Scan from right to left, to find out the max
        for (int i = nums.length - 1; i > 0; i--) {
            if (almostEqualFreq(map, nums.length)) {
                return i + 1;
            } else {
                int n = nums[i];
                int occr = map.get(n);
                map.put(n, occr - 1);
            }
        }
        return 1;
    }

    private boolean almostEqualFreq(Map<Integer, Integer> map, int dicLength) {
        int mostOccr = -1;
        int mostOccrNums = -1;
        int mostOccr2nd = -1;
        int mostOccr2ndNums = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer occr = entry.getValue();
            if (occr == 0) {
                continue;
            } else if (mostOccr == -1) {
                mostOccr = occr;
                mostOccrNums = 1;
            } else if (mostOccr == occr) {
                mostOccrNums++;
            } else if (mostOccr2nd == -1) {
                mostOccr2nd = occr;
                mostOccr2ndNums = 1;
            } else if (mostOccr2nd == occr) {
                mostOccr2ndNums++;
            } else {
                return false;
            }
        }
        if ((mostOccr == 1 && mostOccrNums == 1) || (mostOccr2nd == 1 && mostOccr2ndNums == 1)) {
            // Leave one item alone [2, 2, 3, 3, 4]
            return true;
        } else if (mostOccr == 1 && mostOccrNums == dicLength && mostOccr2nd == -1 && mostOccr2ndNums == -1) {
            // [1, 2, 3, 4, 5], every item has the same value
            return true;
        } else if (mostOccr == dicLength && mostOccr2nd == -1 && mostOccr2ndNums == -1) {
            // [1,1], every item has the same value
            return true;
        } else if (mostOccr2nd == mostOccr + 1 && mostOccr2ndNums == 1) {
            return true;
        } else if (mostOccr2nd == mostOccr - 1 && mostOccrNums == 1) {
            return true;
        } else {
            return false;
        }
    }
}
