package rocks.ninjachen.leet_code_solutions;

/**
 * https://leetcode.com/problems/search-insert-position/submissions/
 */
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1 ;
        while (true) {
            if (right <= left + 1) {
                if (nums[left] > target) {
                    return left;
                } else if (nums[left] == target) {
                    return left;
                } else if (nums[right] > target) {
                    //The target should between left and right.
                    return right;
                } else if (nums[right] == target) {
                    return right;
                } else {
                    return right + 1;
                }
            }
            int middle = (left + right) / 2;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] < target) {
                // Find in [middle, right]
                left = middle;
            } else {
                // Find in [left, middle]
                right = middle;
            }
        }

    }
}
