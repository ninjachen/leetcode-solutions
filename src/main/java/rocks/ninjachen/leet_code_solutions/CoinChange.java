package rocks.ninjachen.leet_code_solutions;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        return coinChange(coins, amount, new int[amount+1]);
    }

    public int coinChange(int[] coins, int amount, int[] cache) {
        if (amount == 0) {
            return 0;
        } else if (amount < 0) {
            return -1;
        } else {
            int cachedVal = cache[amount];
            if (cachedVal != 0) {
                return cachedVal;
            }
            int minNums = -1;
            for (int coinVal : coins) {
                int subNums = coinChange(coins, amount - coinVal, cache);

                if (subNums == -1) {
                    // skip
                    continue;
                } else {
                    int nums = 1 + subNums;
                    if (minNums == -1) {
                        minNums = nums;
                    } else {
                        minNums = Math.min(minNums, nums);
                    }
                }
            }
            cache[amount] = minNums;
            return minNums;
        }
    }
}
