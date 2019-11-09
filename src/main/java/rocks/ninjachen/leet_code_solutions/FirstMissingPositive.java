package rocks.ninjachen.leet_code_solutions;


import java.util.concurrent.locks.ReentrantLock;

/**
 * todo
 * its un-complete
 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        if (nums.length == 0) {
            return 1;
        }
        int x;
        for (x = 1; x <= nums.length; x++) {
            if (nums[x - 1] != x) {
                break;
            }
        }
        if (x == nums.length + 1) {
            return x;
        }
        int i = 0;
        int slow = i;
        int oldVal;
        oldVal = nums[i];
        // set as visited
        nums[i] = 0;
        if (oldVal >= 0 && oldVal < nums.length) {
            i = oldVal;
        } else {
            i = 0;
        }
        while (true) {
            if (i == 0) {
                // search slow
                for (slow = slow + 1; slow < nums.length; slow++) {
                    if (nums[slow] <= 0)
                        continue;
                    else
                        break;
                }
                if (slow == nums.length) {
                    break;
                }
            } else {

            }
            // loop i
            oldVal = nums[i];
            // set as visited
            nums[i] = 0;
            if (oldVal >= 0 && oldVal < nums.length) {
                i = oldVal;
            } else {
                i = 0;
            }
        }
        for (i = 1; i < nums.length; i++) {
            if (nums[i] != 0) {
                return i;
            }
        }
        short s = 42;
        int i1 = 100;
        int[] arr = {1,2};
        return nums.length;
    }
}
