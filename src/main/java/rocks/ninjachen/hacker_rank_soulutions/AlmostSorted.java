package rocks.ninjachen.hacker_rank_soulutions;

import java.util.Scanner;

/**
 * Created by ninja on 12/13/17.
 */
public class AlmostSorted {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] inputs = new int[num];
        for (int i = 0; i < num; i++) {
            inputs[i] = scanner.nextInt();
        }
        scanner.close();
        String str = almostSorted(inputs);
    }

    /**
     * Sort is ascending
     * 1. Return yes when already sorted
     * 2. Return swap m,n
     * 2. Return reverse m,n
     * 2. Return no when can not perform one operation
     *
     * @param inputs
     * @return
     */
    private static String almostSorted(int[] inputs) {
        Integer unSortedStartIndex = unSortedStartIndex(inputs);
        // Already sorted
        if (unSortedStartIndex == null) {
            return "yes";
        }
        int length = inputs.length;
        // Unsorted array is [$unSortedStartIndex, length-1]
        int[] swapRange = canSwap(inputs, unSortedStartIndex, length-1);
        int[] reverseRange = canReverse(inputs, unSortedStartIndex, length-1);
        return "no";
    }

    /**
     *
     * @param inputs
     * @param startIndex
     * @param endIndex
     * @return null when can not swap, otherwise return {m, n}
     */
    private static int[] canSwap(int[] inputs, int startIndex, int endIndex ) {
        return null;
    }

    /**
     *
     * @param inputs
     * @param startIndex
     * @param endIndex
     * @return null when can not reverse, otherwise return {m, n}
     */
    private static int[] canReverse(int[] inputs, int startIndex, int endIndex ) {
        return null;
    }

//    private static boolean isSorted(int[] inputs) {
//        int n = inputs[0];
//        for (int i = 0; i < inputs.length; i++) {
//            if (n > inputs[i]) {
//                return false;
//            }
//            n = inputs[i];
//        }
//        return false;
//    }

    /**
     * Return first unsorted item index
     *
     * @param inputs
     * @return n when all item is sorted
     */
    private static Integer unSortedStartIndex(int[] inputs) {
        int n = inputs[0];
        for (int i = 0; i < inputs.length; i++) {
            if (n > inputs[i]) {
                return i;
            }
            n = inputs[i];
        }
        return null;
    }

}
