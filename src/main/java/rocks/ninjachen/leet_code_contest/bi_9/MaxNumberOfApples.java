package rocks.ninjachen.leet_code_contest.bi_9;

import java.util.Arrays;

public class MaxNumberOfApples {
    public int maxNumberOfApples(int[] arr) {
        Arrays.sort(arr);
        int weight = 5000;
        int num = 0;
        for (int i = 0; i < arr.length; i++) {
            if(weight >= arr[i]) {
                weight -= arr[i];
                 num++;
            }else {
                break;
            }
        }
        return num;
    }
}
