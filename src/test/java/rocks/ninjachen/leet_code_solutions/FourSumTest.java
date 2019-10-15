package rocks.ninjachen.leet_code_solutions;

import org.junit.Before;
import org.junit.Test;
import rocks.ninjachen.util.ResourceUtil;

import static org.junit.Assert.*;

public class FourSumTest {
    FourSum solution;

    @Before
    public void setUp() throws Exception {
        solution = new FourSum();
    }

    @Test
    public void testcase1 () {
        System.out.println(solution.fourSum(ResourceUtil.parseLineToIntArray("[1,0,-1,0,-2,2]"), 0));
    }
}