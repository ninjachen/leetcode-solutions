package rocks.ninjachen.leet_code_solutions;

import org.junit.Before;
import org.junit.Test;
import rocks.ninjachen.util.ResourceUtil;

import static org.junit.Assert.*;

public class SearchInsertPositionTest {
    SearchInsertPosition solution;

    @Before
    public void setUp() throws Exception {
        solution = new SearchInsertPosition();
    }

    @Test
    public void testcase1() {
        int actual = solution.searchInsert(ResourceUtil.parseLineToIntArray("[1,3,5,6]"), 2);
        assertEquals(2, actual);
    }
}