package rocks.ninjachen.leet_code_contest._154;

import org.junit.Assert;
import org.junit.Test;
import rocks.ninjachen.hacker_rank_soulutions.Constants;
import rocks.ninjachen.util.FileUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class KConcatenationMaxSumTest {
    KConcatenationMaxSum solution = new KConcatenationMaxSum();

    @Test
    public void testCase1() {
        int[] arr = {1, 2};
        Assert.assertEquals(9, solution.kConcatenationMaxSum(arr, 3));
    }

    @Test
    public void testCase2() {
        int[] arr = {1, -2, 1};
        Assert.assertEquals(2, solution.kConcatenationMaxSum(arr, 5));
    }

    @Test
    public void testCase3() {
        int[] arr = {-1, -2};
        Assert.assertEquals(0, solution.kConcatenationMaxSum(arr, 7));
    }

    @Test
    public void testCase4() {
        int[] arr = {-5, -2, 0, 0, 3, 9, -2, -5, 4};
        Assert.assertEquals(20, solution.kConcatenationMaxSum(arr, 5));
    }

    @Test
    public void testCase5() {
        int[] arr = {-9,13,4,-16,-12,-16,3,-7,5,-16,16,8,-1,-13,15,3};
        Assert.assertEquals(36, solution.kConcatenationMaxSum(arr, 6));
    }

    @Test
    public void testCase6() {
        String name = Constants.BASE_DIR_LEETCODE + "k-concatenation-max-sum.txt";
        List<String> lines = FileUtil.getResourceLines(getClass().getClassLoader(), name);
        String line0 = lines.get(0);
        int[]  arr = FileUtil.parseLineToIntArray(line0);
        int k = Integer.parseInt(lines.get(1));
        Assert.assertEquals(664859242, solution.kConcatenationMaxSum(arr, k));
    }

}