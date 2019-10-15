package rocks.ninjachen.leet_code_contest._158;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rocks.ninjachen.util.ResourceUtil;

import static org.junit.Assert.*;

public class DieSimulatorTest {
    DieSimulator solution;

    @Before
    public void setUp() throws Exception {
        solution = new DieSimulator();
    }

    @Test
    public void testcase0() {
        Assert.assertEquals(34, solution.dieSimulator(2, ResourceUtil.parseLineToIntArray("[1,1,2,2,2,3]")));
    }

    @Test
    public void testcase1() {
        Assert.assertEquals(181, solution.dieSimulator(3, ResourceUtil.parseLineToIntArray("[1,1,1,2,2,3]")));
    }

    @Test
    public void testcase2() {
        Assert.assertEquals(822005673, solution.dieSimulator(20, ResourceUtil.parseLineToIntArray("[8,5,10,8,7,2]")));
    }

    @Test
    public void testcase3() {
        Assert.assertEquals(427883837, solution.dieSimulator(1000, ResourceUtil.parseLineToIntArray("[6,1,14,3,2,8]")));
    }
}