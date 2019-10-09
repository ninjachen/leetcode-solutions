package rocks.ninjachen.leet_code_contest._157;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rocks.ninjachen.util.ResourceUtil;

import static org.junit.Assert.*;

public class GetMaximumGoldTest {
    GetMaximumGold solution;

    @Before
    public void setUp() throws Exception {
        solution = new GetMaximumGold();
    }

    @Test
    public void testcase1() {
        int[][] grid = ResourceUtil.parse2dArray("[[0,6,0],[5,8,7],[0,9,0]]");
        Assert.assertEquals(24, solution.getMaximumGold(grid));
    }

    @Test
    public void testcase2() {
        int[][] grid = ResourceUtil.parse2dArray("[[1,0,7],[2,0,6],[3,4,5],[0,3,0],[9,0,20]]");
        Assert.assertEquals(28, solution.getMaximumGold(grid));
    }
}