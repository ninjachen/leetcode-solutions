package rocks.ninjachen.hacker_rank_soulutions;

/**
 * todo this is hard in math
 * https://www.hackerrank.com/contests/projecteuler/challenges/euler199
 * Created by ninja on 12/26/17.
 */
public class IterativeCirclePacking {
    public static void main(String[] args){
        int n = 4; int m = 1;
        double result = icp(n, m);
        System.out.println(result);
    }

    private static double icp(int n, int m) {
        // 0 iteration, suppose the big circle's radius is 1;
        // R = r0 + ro/sin(180/n), r0 = 1/(1+ 1/sin(180/n))
        double angle = 180 / n;
        double r0 = 1/(1+ 1/Math.sin(angle));
        double spaceRate = n * Math.pow(r0, 2);
        return spaceRate;
    }
}
