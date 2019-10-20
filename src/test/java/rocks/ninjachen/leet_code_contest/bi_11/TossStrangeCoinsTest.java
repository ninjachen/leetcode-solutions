package rocks.ninjachen.leet_code_contest.bi_11;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rocks.ninjachen.util.ResourceUtil;

import static org.junit.Assert.*;

public class TossStrangeCoinsTest {
    TossStrangeCoins solution;

    @Before
    public void setUp() throws Exception {
        solution = new TossStrangeCoins();
    }

    @Test
    public void testcase1() {
        Assert.assertEquals(0.4, solution.probabilityOfHeads(new double[]{0.4}, 1), 0);
    }

    @Test
    public void testcase2() {
        double[] input = ResourceUtil.parseLineToDoubleArray("[1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1]");
        Assert.assertEquals(99, solution.probabilityOfHeads(input, 99), 0);
    }
}