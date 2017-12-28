package rocks.ninjachen.hacker_rank_soulutions;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/unbounded-knapsack/problem
 * Created by ninja on 12/27/17.
 */
public class UnboundedKnapsack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // There are n input case
        int num = scanner.nextInt();
        for(int i =0; i < num;i++){
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[] data = new int[n];
            // Init the cache
            int[] cache = new int[k+1];
            for(int j = 0; j < n;j++){
                int tmp = scanner.nextInt();
                data[j] = tmp;
                if(data[j] > k)
                    continue;
                cache[tmp] = tmp;
            }
            int nearest = solveKnapsack(data, k, cache);
            System.out.println(nearest);
        }
        scanner.close();
    }

    /**
     * Calculate the nearest to k
     * @param data
     * @param k
     * @return
     */
    public static int solveKnapsack(int[] data, int k, int[] cache) {
//        System.out.println("solve k " + k);
        int sum = 0;
        if(cache[k] != 0)
            return cache[k];
        for (int i=0; i< data.length;i++){
//            System.out.println("i is " + i);
            int cur = data[i];
            if(k-cur < 0) continue;
            if(k-cur == 0) return k;
//            System.out.println(String.format("start to solveKnapsack(%d) + (%d)", k-data[i], data[i]));
            int tmp = solveKnapsack(data, k-cur, cache) + cur;
            if(tmp == k) return tmp;
            if(tmp < k && tmp > sum){
                sum = tmp;
            }
        }
        cache[k] = sum;
        return sum;
    }
}
