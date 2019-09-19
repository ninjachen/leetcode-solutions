package rocks.ninjachen.leet_code_contest._154;

import java.util.ArrayList;
import java.util.List;

public class KConcatenationMaxSum {
    private final static int mod = (int) (Math.pow(10, 9) + 7);

    public int kConcatenationMaxSum(int[] arr, int k) {
        boolean allPositive = true;
        boolean allNegative = true;
        int oneLoopSum = 0;
        for (int i : arr) {
            if (i > 0) {
                allNegative = false;
            } else if (i < 0) {
                allPositive = false;
            }
            oneLoopSum += i;
        }
//        oneLoopSum = oneLoopSum % mod;
        if (allPositive) {
            // If all items are positive, return the total sum
            int sum = 0;
            for (int i : arr) {
                sum += i;
            }
            return (sum * k) % mod;
        } else if (allNegative) {
            // If all items are positive, return the total sum
            return 0;
        } else {
            // Find out 2 possible max sum, one is max sum in one loop, one is maxSumTo the bottom + (k-1)*sumOfSingleLoop
            List<Integer> positiveIndexs = new ArrayList<>();
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > 0) {
                    positiveIndexs.add(i);
                }
            }
            int maxSumInOneLoop = 0;
            int curSum = 0;

            // Find out max sum in one loop
            for (int i = 0; i < arr.length; i++) {
                int cur = arr[i];
                if (curSum + cur >= 0) {
                    curSum = (curSum + cur);
                    if (curSum > maxSumInOneLoop) {
                        maxSumInOneLoop = curSum;
                    }
                } else {
                    // If sum is negative, drop current sum.
                    curSum = 0;
                }
            }

            //Find out max sum
            int maxSumPossible1 = maxSumInOneLoop % mod;
            int maxSumPossible2 = 0;
            if (k > 1) {
                int prefixSum = maxPrefixSum(arr);
                int suffixSum = maxSuffixSum(arr);
                if(oneLoopSum < 0){
                    oneLoopSum = 0;
                }
                maxSumPossible2 = (suffixSum + oneLoopSum * (k - 2) + prefixSum) % mod;
            }
            int maxSum = Math.max(maxSumPossible1, maxSumPossible2);
            return maxSum;
        }
    }

    /**
     * Find out max sum from first item
     *
     * @param arr
     * @return
     */
    private int maxPrefixSum(int[] arr) {
        int maxSum = 0;
        int curSum = 0;
        for (int val : arr) {
            curSum += val;
            if(curSum > maxSum){
                maxSum = curSum;
            }
        }
        return Math.max(maxSum, 0);
    }

    private int maxSuffixSum(int[] arr) {
        int maxSum = 0;
        int curSum = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            int val = arr[i];
            curSum += val;
            if(curSum > maxSum){
                maxSum = curSum;
            }
        }
        return Math.max(maxSum, 0);
    }
}
