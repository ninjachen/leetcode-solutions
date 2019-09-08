package rocks.ninjachen.leet_code_solutions;


import java.util.LinkedList;
import java.util.Queue;

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
        int len1 = nums1.length;
        int len2 = nums2.length;
        if(len1 > len2){
            //we want num1 is longer then num2, do swap
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
            len1 = nums1.length;
            len2 = nums2.length;
        }
        // i in [leftRnage, rightRange]
        int leftRange = 0, rightRange = len1;
        int i = len1 / 2;
        int j;
        while (true) {
            j = (len1 + len2 + 1) / 2 - i;
            // we want num1[i] >= num2[j-1], num2[j] >= num1 [i -1]
            if (i < nums1.length && j >=1 && nums1[i] < nums2[j - 1]) {
                leftRange = i;
                i = (i + rightRange + 1) / 2;
//                i++;
            } else if (j < nums2.length && i >= 1 && nums2[j] < nums1[i - 1]) {
                rightRange = i;
                i = (i + leftRange) / 2;
//                i--;
            } else {
                // got it
                int maxOfLeft;
                if(i == 0){
                    maxOfLeft = nums2[j - 1];
                }else if(j == 0){
                    maxOfLeft = nums1[i - 1];
                }else {
                    maxOfLeft= Math.max(nums1[i - 1], nums2[j - 1]);
                }
                Queue<Integer> q = new LinkedList<>();
                if ((len1 + len2) % 2 == 1) {
                    return maxOfLeft;
                } else {
                    int minOfRight;
                    if(i == len1){
                        minOfRight = nums2[j];
                    }else if(j == len2){
                        minOfRight = nums1[i];
                    }else {
                        minOfRight = Math.min(nums1[i], nums2[j]);
                    }
                    return (maxOfLeft + minOfRight) / 2.0;
                }
            }
        }
    }
}
