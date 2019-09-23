package rocks.ninjachen.leet_code_contest._155;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NthUglyNumberTest {
    NthUglyNumber soulution;

    @Before
    public void setUp() throws Exception {
        soulution = new NthUglyNumber();
    }

    @Test
    public void testcase1() {
        assertEquals(4, soulution.nthUglyNumber(3 ,2, 3, 5));
    }

    @Test
    public void testcase2() {
        assertEquals(6, soulution.nthUglyNumber(4, 2, 3, 4));
    }

    @Test
    public void testcase3() {
        assertEquals(1999999984, soulution.nthUglyNumber(1000000000, 2, 217983653, 336916467));
    }
}