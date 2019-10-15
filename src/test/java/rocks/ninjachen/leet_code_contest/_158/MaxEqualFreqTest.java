package rocks.ninjachen.leet_code_contest._158;

import org.junit.Before;
import org.junit.Test;
import rocks.ninjachen.leet_code_contest._158.MaxEqualFreq;
import rocks.ninjachen.util.ResourceUtil;

import static org.junit.Assert.*;

public class MaxEqualFreqTest {
    MaxEqualFreq solution;

    @Before
    public void setUp() throws Exception {
        solution = new MaxEqualFreq();
    }

    @Test
    public void testcase1() {
        assertEquals(8, solution.maxEqualFreq(ResourceUtil.parseLineToIntArray("[10,2,8,9,3,8,1,5,2,3,7,6]")));
    }

    @Test
    public void testcase2() {
        assertEquals(2, solution.maxEqualFreq(ResourceUtil.parseLineToIntArray("[1,2]")));
    }

    @Test
    public void testcase3() {
        assertEquals(2, solution.maxEqualFreq(ResourceUtil.parseLineToIntArray("[1,1]")));
    }

    @Test
    public void testcase4() {
        assertEquals(9, solution.maxEqualFreq(ResourceUtil.parseLineToIntArray("[1,2,3,4,5,6,7,8,9]")));
    }

    @Test
    public void testcase5() {
        assertEquals(7, solution.maxEqualFreq(ResourceUtil.parseLineToIntArray("[2,2,1,1,5,3,3,5]")));
    }

    @Test
    public void testcase6() {
        assertEquals(7, solution.maxEqualFreq(ResourceUtil.parseLineToIntArray("[1,1,2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,8,8,8,42,21,45,27,78,39,78,24,47,60,22,33,45,18,56,91,93,66,79,65,43,7,57,63,74,25,11,14,100,95,19,3,22,18,94,52,91,33,95,16,93,63,65,8,88,51,47,7,51,77,36,48,89,72,81,75,13,69,9,31,16,38,34,76,7,82,10,90,64,28,22,99,40,88,27,94,85,43,75,95,86,82,46,9,74,67,51,93,97,35,2,49]")));
    }
}