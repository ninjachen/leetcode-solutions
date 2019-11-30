package rocks.ninjachen.leet_code_contest._164;

import org.junit.Before;
import org.junit.Test;
import rocks.ninjachen.hacker_rank_soulutions.Constants;
import rocks.ninjachen.util.ResourceUtil;

import java.util.List;

import static org.junit.Assert.*;

public class MinTimeToVisitAllPointsTest {
    MinTimeToVisitAllPoints solution;

    @Before
    public void setUp() throws Exception {
        solution = new MinTimeToVisitAllPoints();
    }

    @Test
    public void minTimeToVisitAllPoints() {
        String name = Constants.BASE_DIR_LEETCODE + "min-time-to-visit-all-points-test";
        List<String> lines = ResourceUtil.getResourceLines(getClass().getClassLoader(), name);
        int[][] grid = ResourceUtil.parse2dArray(lines.get(0));
        assertEquals(49088, solution.minTimeToVisitAllPoints(grid));
    }
}