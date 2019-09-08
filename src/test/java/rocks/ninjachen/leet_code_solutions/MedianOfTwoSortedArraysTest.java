package rocks.ninjachen.leet_code_solutions;

import org.junit.Test;
import rocks.ninjachen.hacker_rank_soulutions.AlmostSorted;

import static org.junit.Assert.*;

public class MedianOfTwoSortedArraysTest {
    private MedianOfTwoSortedArrays solution = new MedianOfTwoSortedArrays();

    @Test
    public void testCase1() {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        // 3 1 2 should be YES
        assertEquals(2.0, solution.findMedianSortedArrays(nums1, nums2),0);
    }

    @Test
    public void testCase2() {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        // 3 1 2 should be YES
        assertEquals(2.5, solution.findMedianSortedArrays(nums1, nums2),0);
    }

    @Test
    public void testCase3() {
        int[] nums1 = {};
        int[] nums2 = {1};
        // 3 1 2 should be YES
        assertEquals(1, solution.findMedianSortedArrays(nums1, nums2),0);
    }

    @Test
    public void testCase4() {
        int[] nums1 = {};
        int[] nums2 = {2,3};
        // 3 1 2 should be YES
        assertEquals(2.5, solution.findMedianSortedArrays(nums1, nums2),0);
    }

    @Test
    public void testCase5() {
        int[] nums1 = {1,2,3,6,7};
        int[] nums2 = {4,5,8,9,10};
        // 3 1 2 should be YES
        assertEquals(5.5, solution.findMedianSortedArrays(nums1, nums2),0);
    }
}