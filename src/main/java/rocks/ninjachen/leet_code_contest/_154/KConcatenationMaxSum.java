package rocks.ninjachen.leet_code_contest._154;


/**
 * https://leetcode.com/problems/k-concatenation-maximum-sum/
 */
public class KConcatenationMaxSum {
    private final static int mod = (int) (Math.pow(10, 9) + 7);

    public int kConcatenationMaxSum(int[] arr, int k) {
        boolean allPositive = true;
        boolean allNegative = true;
        long oneLoopSum = 0;
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
            long maxSumPossible1 = maxSumInOneLoop % mod;
            long maxSumPossible2 = 0;
            if (k > 1) {
                long prefixSum = maxPrefixSum(arr);
                long suffixSum = maxSuffixSum(arr);
                if (oneLoopSum < 0) {
                    oneLoopSum = 0;
                }
                maxSumPossible2 = (suffixSum % mod + (oneLoopSum * (k - 2)) % mod + (prefixSum) % mod) % mod;
            }
            return (int) Math.max(maxSumPossible1, maxSumPossible2);
        }
    }

    /**
     * Find out max sum from first item
     *
     * @param arr
     * @return
     */
    private long maxPrefixSum(int[] arr) {
        long maxSum = 0;
        long curSum = 0;
        for (int val : arr) {
            curSum += val;
            if (curSum > maxSum) {
                maxSum = curSum;
            }
        }
        return Math.max(maxSum, 0);
    }

    private long maxSuffixSum(int[] arr) {
        long maxSum = 0;
        long curSum = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            int val = arr[i];
            curSum += val;
            if (curSum > maxSum) {
                maxSum = curSum;
            }
        }
        return Math.max(maxSum, 0);
    }
}
