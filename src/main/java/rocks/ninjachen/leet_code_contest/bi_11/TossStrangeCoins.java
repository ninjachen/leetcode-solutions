package rocks.ninjachen.leet_code_contest.bi_11;

/**
 * https://leetcode.com/contest/biweekly-contest-11/problems/toss-strange-coins/
 */
public class TossStrangeCoins {
    public double probabilityOfHeads(double[] prob, int target) {
        // <target, cur>
        double[] cache = new double[(target + 1) * prob.length];
        return probabilityOfHeads(prob, 0, target, cache);
    }

    public double probabilityOfHeads(double[] prob, int cur, int target, double[] cache) {
        if (cur >= prob.length) {
            if (target == 0) {
                return 1;
            } else {
                return 0;
            }
        }
        // Try to find cache
        int index = target * prob.length + cur;
        double cachedVal = cache[index];
        if (cachedVal > 0) {
            return cachedVal;
        }
        // Calculate the probability
        double probability;
        if (target == 0) {
            probability = 1;
            for (; cur < prob.length; cur++) {
                probability *= (1 - prob[cur]);
            }
        } else {
            double p = prob[cur];
            probability = p * probabilityOfHeads(prob, cur + 1, target - 1, cache) + (1 - p) * probabilityOfHeads(prob, cur + 1, target, cache);
        }
        cache[index] = probability;
        return probability;
    }

}
