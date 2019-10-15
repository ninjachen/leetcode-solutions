package rocks.ninjachen.leet_code_solutions;

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int middle = (lo + hi) / 2;
            if (nums[middle] > nums[hi]) {
                lo = middle + 1;
            } else {
                hi = middle;
            }
        }
        int privotIndex = lo;
        // Search in [privotIndex, privotIndex + len - 1], both is inclusive
        hi = privotIndex + nums.length - 1;
        while (lo <= hi) {
            int middle = (lo + hi) / 2;
            int middleVal = nums[middle % nums.length];
            if (middleVal == target) {
                return middle % nums.length;
            } else if (middleVal > target) {
                hi = middle - 1;
            } else {
                lo = middle + 1;
            }
        }
        return -1;
    }

}
