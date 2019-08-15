package rocks.ninjachen.leet_code_solutions;


/**
 * https://leetcode.com/problems/median-of-two-sorted-arrays
 * Created by ninja on 08/15/19.
 */
@SuppressWarnings("Duplicates")
public class MedianOfTwoSortedArrays {

    /**
     * nums1 and nums2 are sorted respectively
     * 1. Return the middle one element, if num1.length + num2.length is odd
     * 2. Return the average value of the two middle elements, if num1.length + num2.length is even
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //
        int nums1Index = 0, nums2Index = 0, totalIndex = -1;
        if ((nums1.length + nums2.length) % 2 == 1) {
            //Total length is odd, find the middle one
            int middleIndex = (nums1.length + nums2.length - 1) / 2;
            boolean isNums1;
            for (; ; ) {
                isNums1 = isNums1Small(nums1, nums2, nums1Index, nums2Index);
                totalIndex++;
                if (totalIndex == middleIndex) {
                    return isNums1 ? nums1[nums1Index] : nums2[nums2Index];
                } else {
                    //Runner forward
                    if (isNums1) {
                        nums1Index++;
                    } else {
                        nums2Index++;
                    }
                }
            }
        } else {
            //Total length is
            double r;
            int middleIndexl = (nums1.length + nums2.length - 1) / 2;
            int r1 = -1, r2 = -1;
            for (; ; ) {
                boolean isNums1 = isNums1Small(nums1, nums2, nums1Index, nums2Index);
                totalIndex++;
                if (totalIndex == middleIndexl) {
                    r1 = isNums1 ? nums1[nums1Index] : nums2[nums2Index];
                    if (isNums1) {
                        nums1Index++;
                    } else {
                        nums2Index++;
                    }
                    isNums1 = isNums1Small(nums1, nums2, nums1Index, nums2Index);
                    if (isNums1) {
                        r2 = nums1[nums1Index];
                    } else {
                        r2 = nums2[nums2Index];
                    }
                    r = (r1 + r2) / 2.0;
                    return r;
                }
                if (isNums1) {
                    nums1Index++;
                } else {
                    nums2Index++;
                }
            }
        }
    }

    /**
     * Decide is nums1[index1] is less than nums2[index2]
     * @param nums1
     * @param nums2
     * @param index1
     * @param index2
     * @return
     */
    private boolean isNums1Small(int[] nums1, int[] nums2, int index1, int index2) {
        boolean isNums1;
        if (index1 >= nums1.length) {
            isNums1 = false;
        } else if (index2 >= nums2.length) {
            isNums1 = true;
        } else {
            isNums1 = nums1[index1] < nums2[index2];
        }
        return isNums1;
    }

}
