package rocks.ninjachen.mockInterview;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rocks.ninjachen.util.ResourceUtil;

public class MinDominoRotationsTest {
    MinDominoRotations solution;

    @Before
    public void setUp() throws Exception {
        solution = new MinDominoRotations();
    }

    @Test
    public void testcase1() {
        int min = solution.minDominoRotations(
                ResourceUtil.parseLineToIntArray("[1,2,1,1,1,2,2,2]"),
                ResourceUtil.parseLineToIntArray("[2,1,2,2,2,2,2,2]")
        );
        Assert.assertEquals(1, min);
    }
}