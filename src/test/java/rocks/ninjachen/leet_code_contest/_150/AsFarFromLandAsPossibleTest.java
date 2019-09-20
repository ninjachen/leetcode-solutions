package rocks.ninjachen.leet_code_contest._150;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rocks.ninjachen.hacker_rank_soulutions.Constants;
import rocks.ninjachen.util.ResourceUtil;

import java.util.List;

public class AsFarFromLandAsPossibleTest {
    AsFarFromLandAsPossible solution;

    @Before
    public void setUp() throws Exception {
        solution = new AsFarFromLandAsPossible();
    }

    @Test
    public void maxDistance1() {
        String name = Constants.BASE_DIR_LEETCODE + "as-far-from-land-as-possible1";
        List<String> lines = ResourceUtil.getResourceLines(getClass().getClassLoader(), name);
        int[][] grid = ResourceUtil.parse2dArray(lines.get(0));
        Assert.assertEquals(4, solution.maxDistance(grid));
    }

    @Test
    public void maxDistance2() {
        String name = Constants.BASE_DIR_LEETCODE + "as-far-from-land-as-possible2";
        List<String> lines = ResourceUtil.getResourceLines(getClass().getClassLoader(), name);
        int[][] grid = ResourceUtil.parse2dArray(lines.get(0));
        Assert.assertEquals(2, solution.maxDistance(grid));
    }
}