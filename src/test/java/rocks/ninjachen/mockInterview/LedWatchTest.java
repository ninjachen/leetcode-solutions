package rocks.ninjachen.mockInterview;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LedWatchTest {
    LedWatch solution;

    @Before
    public void setUp() throws Exception {
        solution = new LedWatch();
    }

    @Test
    public void testcase1() {
        System.out.println(solution.readBinaryWatch(1));
    }

    @Test
    public void testcase2() {
        System.out.println(solution.readBinaryWatch(8));
    }
}