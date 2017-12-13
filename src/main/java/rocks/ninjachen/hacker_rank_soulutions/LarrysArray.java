package rocks.ninjachen.hacker_rank_soulutions;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/larrys-array/problem
 * Created by ninja on 12/13/17.
 */
public class LarrysArray {

    public static void main(String[] arg) {
        Scanner scanner = new Scanner(System.in);
        // Read the number of the user case
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            // Read the number of integers in one user case
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = scanner.nextInt();
            }
            boolean sorted = canBeSorted(arr);
            System.out.println(sorted ? "YES" : "NO");
        }
    }

    public static boolean canBeSorted(int... args) {
        // Suppose a runner from [0, length-3].
        // Each time do a shuffle, int the sub array [i, i+1, i+2], i is always the smallest;
        // Check the last 3 int is sorted.
        int len = args.length;
        if (len < 3) {
            // Corner case
            return true;
        }
        // Like bubble sort, it should be thought as 2 runner, i and j
        for (int i = 0; i < len - 2; i++) {
            for(int j =len -3; j>=0;j--){
                int[] sorted = sort(args[j], args[j + 1], args[j + 2]);
                args[j] = sorted[0];
                args[j + 1] = sorted[1];
                args[j + 2] = sorted[2];
            }
        }
//        System.out.println("");
//        System.out.println("After sorted: ");
//        for (int i = 0; i < len; i++) {
//            System.out.print(" "+args[i]+",");
//        }
        boolean sorted = isSorted(args[len - 3], args[len - 2], args[len - 1]);
        return sorted;
    }

    public static int[] sort(int arg0, int arg1, int arg2) {
        int[] arr = {arg0, arg1, arg2};
        if (arr[0] < arr[1] && arr[0] < arr[2]) {
            return arr;
        }
        arr = robotShuffle(arr);
        if (arr[0] < arr[1] && arr[0] < arr[2]) {
            return arr;
        }
        arr = robotShuffle(arr);
        return arr;
    }

    /**
     * A sub logic, focus on only 3 int
     *
     * @param a
     * @param b
     * @param c
     * @return
     */
    public static boolean canBeSorted(int a, int b, int c) {
        if (isSorted(a, b, c))
            return true;
        int[] arr = {a, b, c};
        arr = robotShuffle(arr);
        if (isSorted(arr[0], arr[1], arr[2])) {
            return true;
        }
        arr = robotShuffle(arr);
        if (isSorted(arr[0], arr[1], arr[2])) {
            return true;
        }
        return false;
    }

    /**
     * Perform one robot shuffle
     *
     * @param array
     * @return
     */
    public static int[] robotShuffle(int[] array) {
        int[] newArray = new int[3];
        newArray[0] = array[1];
        newArray[1] = array[2];
        newArray[2] = array[0];
        return newArray;
    }

    /**
     * Sorted is ascending ordering
     */
    public static boolean isSorted(int a, int b, int c) {
        // Should not be occur
        if (a < b && b < c)
            return true;
        else
            return false;
    }
}
