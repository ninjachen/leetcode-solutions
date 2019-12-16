package rocks.ninjachen.leet_code_contest._167;

import org.junit.Before;
import org.junit.Test;
import rocks.ninjachen.util.ResourceUtil;

import static org.junit.Assert.assertEquals;

public class MaxSideLengthTest {
    MaxSideLength solution;

    @Before
    public void setUp() throws Exception {
        solution = new MaxSideLength();
    }

    @Test
    public void testcase1() {
        int[][] matrix = ResourceUtil.parse2dArray("[[1,1,3,2,4,3,2],[1,1,3,2,4,3,2],[1,1,3,2,4,3,2]]");
        assertEquals(2, solution.maxSideLength(matrix, 4));
    }

    @Test
    public void testcase2() {
        int[][] matrix = ResourceUtil.parse2dArray("[[18,70],[61,1],[25,85],[14,40],[11,96],[97,96],[63,45]]");
        assertEquals(2, solution.maxSideLength(matrix, 40184));
    }
}