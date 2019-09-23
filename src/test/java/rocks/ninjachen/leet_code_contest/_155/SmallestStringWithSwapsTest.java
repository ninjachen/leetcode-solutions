package rocks.ninjachen.leet_code_contest._155;

import org.junit.Before;
import org.junit.Test;
import rocks.ninjachen.util.ResourceUtil;

import java.util.List;

import static org.junit.Assert.*;

public class SmallestStringWithSwapsTest {
    SmallestStringWithSwaps solution;

    @Before
    public void setUp() throws Exception {
        solution = new SmallestStringWithSwaps();
    }

    @Test
    public void testcase0() {
        List<List<Integer>> lists = ResourceUtil.parse2dList("[[0,3],[1,2]]");
        assertEquals("bacd", solution.smallestStringWithSwaps("dcab", lists));
    }

    @Test
    public void testcase1() {
        List<List<Integer>> lists = ResourceUtil.parse2dList("[[1,0],[7,1],[9,1],[3,0],[7,1],[0,4],[6,5],[2,6],[6,4],[6,0]]");
        assertEquals("bdgmxxxzbz", solution.smallestStringWithSwaps("zbxxxdgmbz", lists));
    }
}