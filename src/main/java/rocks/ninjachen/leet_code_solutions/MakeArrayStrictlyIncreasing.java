package rocks.ninjachen.leet_code_solutions;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

/**
 * https://leetcode.com/contest/weekly-contest-153/problems/make-array-strictly-increasing/
 */
public class MakeArrayStrictlyIncreasing {
    public static void main(String[] args) {
        int[] arr1 = {1, 5, 3, 6, 7};
        int[] arr2 = {1, 3, 2, 4};
        MakeArrayStrictlyIncreasing s = new MakeArrayStrictlyIncreasing();
        System.out.println(s.makeArrayIncreasing(arr1, arr2));
    }

    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        List<Integer> disOrderList = new ArrayList<>();
        int pre = arr1[0];
        // Find disorder item in arr1
        for (int i = 1; i < arr1.length; i++) {
            if (arr1[i] < pre) {
                disOrderList.add(i);
            } else {
                pre = arr1[i];
            }
        }
        //
        BitSet indexInArr2Used = new BitSet();
        for (int disorderIndex : disOrderList) {
            int min = arr1[disorderIndex - 1];
            int max = -1;
            if (disorderIndex != arr1.length - 1) {
                max = arr1[disorderIndex + 1];
            }
            boolean got = false;
            for (int i = 1; i < arr2.length; i++) {
                if (indexInArr2Used.get(i)) {
                    continue;
                }
                if (arr2[i] >= min && (max == -1 || arr2[i] <= max)) {
                    got = true;
                    indexInArr2Used.set(i);
                }
            }
            if (!got) {
                return -1;
            }
        }
        return 1;
    }
}
