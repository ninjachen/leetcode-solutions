package rocks.ninjachen.leet_code_contest._168;

import java.util.Arrays;

public class IsPossibleDivide {
    public boolean isPossibleDivide(int[] nums, int k) {
        if (nums.length % k != 0) {
            return false;
        }
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        //consum k items in a loop
        for (int i = 0; i < nums.length / k; i++) {
            int count = 0;
            int[] temp = new int[k];
            for (int ii = 0; ii < nums.length; ii++) {
                if (visited[ii])
                    continue;
                if (count > 0 && nums[ii] == temp[count - 1])
                    continue;
                if (count > 0 && nums[ii] - temp[count - 1] > 1) {
                    return false;
                }
                visited[ii] = true;
                temp[count] = nums[ii];
                count++;
                if (count == k)
                    break;
            }
            if (temp[k - 1] == 0)
                return false;
        }
        return true;
    }
}
