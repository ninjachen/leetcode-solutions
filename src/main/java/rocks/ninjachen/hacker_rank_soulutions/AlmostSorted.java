package rocks.ninjachen.hacker_rank_soulutions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/almost-sorted/problem
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
        System.out.println(almostSorted(inputs));
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
    public static String almostSorted(int[] inputs) {
        Integer unSortedStartIndex = unSortedStartIndex(inputs, 0, inputs.length - 1);
        // Already sorted
        if (unSortedStartIndex == null) {
            return "yes";
        }
        int length = inputs.length;
        // Unsorted array is [$unSortedStartIndex, length-1]
        int[] swapRange = canSwap(inputs, unSortedStartIndex, length - 1);
        if (swapRange != null) {
            return "yes\nswap " + ++swapRange[0] + " " + ++swapRange[1];
        }
        int[] reverseRange = canReverse(inputs, unSortedStartIndex, length - 1);
        if (reverseRange != null) {
            return "yes\nreverse " + ++reverseRange[0] + " " + ++reverseRange[1];
        }
        // Other wise, return no
        return "no";
    }

    /**
     * Scan the inputs[startIndex] ~ inputs[endIndex], check is exist a range to swap
     *
     * @param inputs
     * @param startIndex
     * @param endIndex
     * @return null when can not swap, otherwise return {m, n}
     */
    private static int[] canSwap(int[] inputs, int startIndex, int endIndex) {
        if (startIndex >= endIndex) return null;
        int[] result = new int[2];
        int firstUnsorted = startIndex;
        if (endIndex - startIndex == 1) {
            result[0] = startIndex;
            result[1] = endIndex;
            return result;
        }
        for (int i = firstUnsorted + 1; i <= endIndex - 1; i++) {
            // swap firstUnsorted,i; check is sorted
            int[] array1 = new int[inputs.length];
            // copy to prevent side effect
            System.arraycopy(inputs, 0, array1, 0, inputs.length);
            // swap [firstUnsorted, i]
            int tmp = array1[i];
            array1[i] = array1[firstUnsorted];
            array1[firstUnsorted] = tmp;
            if (isSorted(array1)) {
                result[0] = firstUnsorted;
                result[1] = i;
                return result;
            }
        }
        return null;
    }

    private static boolean isSorted(int[] input) {
        return unSortedStartIndex(input, 0, input.length-1) == null;
    }

    /**
     * Scan the inputs[startIndex] ~ inputs[endIndex], check is exist a range to swap
     *
     * @param inputs
     * @param startIndex
     * @param endIndex
     * @return null when can not reverse, otherwise return {m, n}
     */
    private static int[] canReverse(int[] inputs, int startIndex, int endIndex) {
        if (startIndex >= endIndex) return null;
        int[] result = new int[2];
        int firstUnsorted = startIndex;
        for (int i = firstUnsorted + 1; i <= endIndex - 1; i++) {
            // copy to prevent side effect
            // reserve [firstUnsorted, i]
            int[] array1 = reserve(inputs, firstUnsorted, i);
            if (isSorted(array1)) {
                result[0] = firstUnsorted;
                result[1] = i;
                return result;
            }
        }
        return null;
    }

    private static int[] reserve(int[] inputs, int i, int j) {
        List<Integer> reserved = new ArrayList<>();
        int[] array = new int[inputs.length];
        System.arraycopy(inputs, 0, array, 0, inputs.length);
        // i => j
        int indexOfInput = i;
        for (int indexOfArray = j; indexOfArray >= i; indexOfArray--) {
            // j =>
            array[indexOfArray] = inputs[indexOfInput];
            indexOfInput++;
        }
        return array;
    }

//    private static boolean sorted(int[] inputs) {
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
     * @param startIndex include
     * @param endIndex   include
     * @return n when all item is sorted
     */
    private static Integer unSortedStartIndex(int[] inputs, int startIndex, int endIndex) {
        for (int i = startIndex; i <= endIndex - 1; i++) {
            if (inputs[i] > inputs[i + 1]) {
                return i;
            }
        }
        return null;
    }

}
