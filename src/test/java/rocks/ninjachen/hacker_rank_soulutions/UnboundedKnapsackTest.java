package rocks.ninjachen.hacker_rank_soulutions;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

import static org.junit.Assert.*;

/**
 * Created by ninja on 12/27/17.
 */
public class UnboundedKnapsackTest {
    @Test
    public void solveKnapsack() throws Exception {
        int[] date = {1, 6, 9};
        int[] cache = new int[13];
        cache[1] = 1;
        cache[6] = 6;
        cache[9] = 9;
        int approach = UnboundedKnapsack.solveKnapsack(date, 12, cache);
        System.out.println("approach is " + approach);
    }

    @Test
    public void solveKnapsack1() throws Exception {
        InputStream inputIn = getClass().getClassLoader().getResourceAsStream(Constants.BASE_DIR + "unbounded-knapsack-input1.txt");
        InputStream expectIn = getClass().getClassLoader().getResourceAsStream(Constants.BASE_DIR + "unbounded-knapsack-expect1.txt");
        HashMap<int[], String> testCases = new HashMap<>();
        try {
            Scanner inputScanner = new Scanner(inputIn);
            Scanner expectScanner = new Scanner(expectIn);
            int amount = inputScanner.nextInt();
            for (int i = 0; i < amount; i++) {
                int n = inputScanner.nextInt();
                int k = inputScanner.nextInt();
                int[] data = new int[n];
                int[] cache = new int[k+1];
                for (int j=0;j<n;j++){
                    data[j] = inputScanner.nextInt();
                    if(data[j] > k)
                        continue;
                }
                int approach = UnboundedKnapsack.solveKnapsack(data, k, cache);
                System.out.println("approach is " + approach);
                assertEquals(expectScanner.nextInt(), approach);
            }
        } finally {
            try {
                inputIn.close();
                expectIn.close();
            } catch (Throwable ignore) {
            }
        }
    }

}