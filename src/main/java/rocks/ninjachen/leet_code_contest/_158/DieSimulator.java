package rocks.ninjachen.leet_code_contest._158;

/**
 * https://leetcode.com/contest/weekly-contest-158/problems/dice-roll-simulation
 */
public class DieSimulator {
    static final int MOD = 1000000000 + 7;

    public int dieSimulator(int n, int[] rollMax) {
        int[][][] cache = new int[5001][6][16];
        return dieSimulator(n, rollMax, 1, 0, cache);
    }

    public int dieSimulator(int n, int[] rollMax, int lastVal, int lastValTimes, int[][][] cache) {
        if (n == 0) {
            return 1;
        }
        int cacheCount = cache[n][lastVal][lastValTimes];
        if (cacheCount > 0) {
            return cacheCount;
        }
        int count = 0;
        for (int i = 0; i < rollMax.length; i++) {
            if (lastVal == i && lastValTimes + 1 > rollMax[i]) {
                continue;
            }
            int subcount;
            if (lastVal == i) {
                subcount = dieSimulator(n - 1, rollMax, i, lastValTimes + 1, cache);
            } else {
                subcount = dieSimulator(n - 1, rollMax, i, 1, cache);
            }
            count = (count + subcount) % MOD;
        }
        cache[n][lastVal][lastValTimes] = count;
        return count;
    }
}
