package rocks.ninjachen.hacker_rank_soulutions;

import java.util.ArrayList;
import java.util.Arrays;
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
        // Already sorted
        if (isSorted(inputs, 0, inputs.length - 1)) {
            return "yes";
        }
        int[] sorted = new int[inputs.length];
        System.arraycopy(inputs, 0, sorted, 0, inputs.length);
        Arrays.sort(sorted);
        List<Integer> unsortedIndex = new ArrayList<>();
        for(int i = 0; i<inputs.length;i++){
            if(inputs[i] != sorted[i]){
                unsortedIndex.add(i);
            }
        }
        if(unsortedIndex.size() == 2){
            int first = unsortedIndex.get(0);
            int second = unsortedIndex.get(1);
            return "yes\nswap " + ++first + " " + ++second;
        }

        /**
         * <del>un-continuous array can not be reserved</del>
         * A corner case is the middle element can be equal and can be subreserve
         */
//        if(!iscontinuous(unsortedIndex)){
//            return "no";
//        }
        // do a subreserve
        int[] reserved = subreserve(inputs, unsortedIndex.get(0), unsortedIndex.get(unsortedIndex.size() - 1));
        // travel all the unsorted elements, check is sorted
        for (int i = 0;i<unsortedIndex.size();i++){
            int index = unsortedIndex.get(i);
            if(reserved[index] != sorted[index]){
                return "no";
            }
        }
        // can be reserved
        int first = unsortedIndex.get(0);
        int last = unsortedIndex.get(unsortedIndex.size()-1);
        return "yes\nreverse " + ++first + " " + ++last;
    }

    private static boolean iscontinuous(List<Integer> integers) {
        if(integers.size() >=2){
            int prev = integers.get(0);
            for (int i=1;i<integers.size();i++){
                int cur = integers.get(i);
                if(cur - prev != 1){
                    return false;
                }
                prev = cur;
            }
            return true;
        }
        return false;
    }

    // Do a sub-reserve of inputs, from i to j
    private static int[] subreserve(int[] inputs, int i, int j) {
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

    /**
     * Return first unsorted item index
     *
     * @param inputs
     * @param startIndex include
     * @param endIndex   include
     * @return n when all item is sorted
     */
    private static boolean isSorted(int[] inputs, int startIndex, int endIndex) {
        for (int i = startIndex; i <= endIndex - 1; i++) {
            if (inputs[i] > inputs[i + 1]) {
                return false;
            }
        }
        return true;
    }

}
