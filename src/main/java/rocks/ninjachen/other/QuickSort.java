package rocks.ninjachen.other;

import java.util.Random;

public class QuickSort {
    public int[] sortArray(int[] nums) {
        // shuffle array to avoid worst case
//        shuffle(nums);
        return quickSort(nums, 0 ,nums.length -1);
    }

    private void shuffle(int[] nums) {
        for(int i = 0; i < nums.length;i++){
            Random random = new Random();
            int newIndex = random.nextInt(i);
            swap(nums, i, newIndex);
        }
    }

    private int[] quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int pivotIndex = left;
            int partionedPivotIndex = partition(nums, left, right, pivotIndex);
            quickSort(nums, left, partionedPivotIndex - 1);
            quickSort(nums, partionedPivotIndex + 1, right);
        }
        return nums;
    }

    private int partition(int[] nums, int left, int right, int pivotIndex) {
        //Move pivot to last
        int pivotVal = nums[pivotIndex];
        swap(nums, pivotIndex, right);
        int storeIndex = left;
        // Move all the small item to left.
        for (int i = left; i < right; i++) {
            if (nums[i] < pivotVal) {
                swap(nums, i , storeIndex++);
            }
        }
        //Move pivot back
        swap(nums, storeIndex, right);
        return storeIndex;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
