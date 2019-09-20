package rocks.ninjachen.leet_code_contest._153;

/**
 * https://leetcode.com/contest/weekly-contest-153/problems/maximum-subarray-sum-with-one-deletion/
 */
public class MaxSubArrayWithOneDeletion {
    public int maximumSum(int[] arr) {
        boolean almostNegative = false;
        int neagetiveNum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                neagetiveNum++;
            }
            if (neagetiveNum >= arr.length - 1) {
                almostNegative = true;
            }
        }
        // almost negative choose biggest one
        if (almostNegative) {
            int biggest = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] > biggest) {
                    biggest = arr[i];
                }
            }
            return biggest;
        }
        return  -1;
    }
}
