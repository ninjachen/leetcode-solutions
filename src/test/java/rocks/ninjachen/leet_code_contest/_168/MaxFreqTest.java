package rocks.ninjachen.leet_code_contest._168;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaxFreqTest {
    MaxFreq solution;

    @Before
    public void setUp() throws Exception {
        solution = new MaxFreq();
    }

    @Test
    public void maxFreq() {
        assertEquals(2, solution.maxFreq("dbaaacbcbb", 3,2,6));
    }
}