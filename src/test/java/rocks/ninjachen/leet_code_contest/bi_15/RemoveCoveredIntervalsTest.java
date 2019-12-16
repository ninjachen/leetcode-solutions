package rocks.ninjachen.leet_code_contest.bi_15;

import org.junit.Before;
import org.junit.Test;
import rocks.ninjachen.util.ResourceUtil;

import static org.junit.Assert.*;

public class RemoveCoveredIntervalsTest {
    RemoveCoveredIntervals solution;

    @Before
    public void setUp() throws Exception {
        solution = new RemoveCoveredIntervals();
    }

    @Test
    public void removeCoveredIntervals() {
        int[][] array = ResourceUtil.parse2dArray("[[1,4],[3,6],[2,8]]");
        assertEquals(2, solution.removeCoveredIntervals(array));
    }

    @Test
    public void removeCoveredIntervals2() {
        int[][] array = ResourceUtil.parse2dArray("[[34335,39239],[15875,91969],[29673,66453],[53548,69161],[40618,93111]]");
        assertEquals(2, solution.removeCoveredIntervals(array));
    }
}