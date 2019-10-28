package rocks.ninjachen.leet_code_contest._160;

import org.junit.Before;
import org.junit.Test;
import rocks.ninjachen.util.ResourceUtil;

import static org.junit.Assert.*;

public class GrayCodeTest {
    GrayCode solution;

    @Before
    public void setUp() throws Exception {
        solution = new GrayCode();
    }

    @Test
    public void testcase1() {
        assertArrayEquals(new int[]{0,1}, ResourceUtil.toArray(solution.grayCode(1)));
    }

    @Test
    public void testcase2() {
        assertArrayEquals(new int[]{0, 1, 3, 2}, ResourceUtil.toArray(solution.grayCode(2)));
    }
}