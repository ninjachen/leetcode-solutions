package rocks.ninjachen.leet_code_solutions;

import org.junit.Before;
import org.junit.Test;
import rocks.ninjachen.util.ResourceUtil;

import java.util.Random;
import java.util.Stack;

import static org.junit.Assert.*;

public class FindKthLargestTest {
    FindKthLargest solution;

    @Before
    public void setUp() throws Exception {
        solution = new FindKthLargest();
    }

    @Test
    public void findKthLargest() {
        assertEquals(5, solution.findKthLargest(ResourceUtil.parseLineToIntArray("[3,2,1,5,6,4]"), 2));
    }

    @Test
    public void findKthLargest2() {
        assertEquals(1, solution.findKthLargest(ResourceUtil.parseLineToIntArray("[1]"), 1));
    }

    @Test
    public void findKthLargest3() {
        assertEquals(1, solution.findKthLargest(ResourceUtil.parseLineToIntArray("[2,1]"), 2));
    }
}