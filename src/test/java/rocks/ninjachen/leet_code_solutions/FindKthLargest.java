package rocks.ninjachen.leet_code_solutions;

public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        if (k == 1 && nums.length == 1)
            return nums[0];
        k = nums.length - k;
        return findKthLargest(nums, k, 0, nums.length - 1);
        // int left = 0, right = nums.length;
        // int mid = (left + right) / 2;
        // int pivotIndex = partition(nums, left, right);
    }

    public int findKthLargest(int[] nums, int k, int left, int right) {
        if (left <= right) {
            int pivotIndex = partition(nums, left, right);
            if (pivotIndex == k) {
                return nums[pivotIndex];
            } else if (pivotIndex < k) {
                return findKthLargest(nums, k, pivotIndex + 1, right);
            } else {
                return findKthLargest(nums, k, left, pivotIndex - 1);
            }
        }
        return -1;
    }

    public int partition(int[] nums, int left, int right) {
        int pivotVal = nums[left];
        swap(nums, left, right);
        int leftIndex = left;
        for (int i = left; i < right; i++) {
            if (nums[i] < pivotVal)
                swap(nums, i, leftIndex++);
        }
        swap(nums, leftIndex, right);
        return leftIndex;
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
