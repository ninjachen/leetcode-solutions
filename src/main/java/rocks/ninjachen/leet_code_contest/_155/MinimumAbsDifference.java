package rocks.ninjachen.leet_code_contest._155;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumAbsDifference {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int pre, cur, diff;
        int minimumDiff = -1;
        pre = arr[0];
        for (int i = 1; i < arr.length; i++, pre = cur) {
            cur = arr[i];
            diff = cur - pre;
            if (minimumDiff == -1 || diff < minimumDiff) {
                minimumDiff = diff;
            }
        }
        List<List<Integer>> output = new ArrayList<>();
        pre = arr[0];
        for (int i = 1; i < arr.length; i++, pre = cur) {
            cur = arr[i];
            diff = cur - pre;
            if (diff == minimumDiff) {
                List<Integer> pair = new ArrayList<>();
                pair.add(pre);
                pair.add(cur);
                output.add(pair);
            }
        }
        return output;
    }
}
