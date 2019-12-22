package rocks.ninjachen.leet_code_contest._168;

import org.junit.Before;
import org.junit.Test;
import rocks.ninjachen.util.ResourceUtil;

import java.util.Arrays;

import static org.junit.Assert.*;

public class MaxCandiesTest {
    MaxCandies solution;

    @Before
    public void setUp() throws Exception {
        solution = new MaxCandies();
    }

    @Test
    public void maxCandies() {
        int[] status = ResourceUtil.parseLineToIntArray("[1,0,1,0]");
        System.out.println(Arrays.toString(status));
        int[] candies = ResourceUtil.parseLineToIntArray("[7,5,4,100]");
        int[][] keys = ResourceUtil.parse2dArray("[[],[],[1],[]]");
        int[][] containedBoxes = ResourceUtil.parse2dArray("[[1,2],[3],[],[]]");
        int[] initialBoxes = ResourceUtil.parseLineToIntArray("[0]");
        assertEquals(16, solution.maxCandies(status, candies, keys, containedBoxes, initialBoxes));
    }
}