package rocks.ninjachen.mockInterview;

import org.junit.Before;
import org.junit.Test;
import rocks.ninjachen.util.ResourceUtil;

import static org.junit.Assert.*;

public class LongestStrChainTest {
    LongestStrChain solution;

    @Before
    public void setUp() throws Exception {
        solution = new LongestStrChain();
    }

    @Test
    public void longestStrChain() {
        String[] arr = ResourceUtil.parseLineToStringArray("[\"ksqvsyq\",\"ks\",\"kss\",\"czvh\",\"zczpzvdhx\",\"zczpzvh\",\"zczpzvhx\",\"zcpzvh\",\"zczvh\",\"gr\",\"grukmj\",\"ksqvsq\",\"gruj\",\"kssq\",\"ksqsq\",\"grukkmj\",\"grukj\",\"zczpzfvdhx\",\"gru\"]");
        assertEquals(7, solution.longestStrChain(arr));
    }

    @Test
    public void isPredecessor1() {
        String word1 = "zcpzvh";
        String word2 = "ksqvsyq";
        assertFalse(solution.isPredecessor(word1, word2));
    }

    @Test
    public void isPredecessor2() {
        String word1 = "czvh";
        String word2 = "zczvh";
        assertTrue(solution.isPredecessor(word1, word2));
    }
}