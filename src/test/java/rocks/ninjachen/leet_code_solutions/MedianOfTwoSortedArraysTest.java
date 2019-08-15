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
}