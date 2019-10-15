package rocks.ninjachen.leet_code_solutions;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rocks.ninjachen.util.ResourceUtil;

public class SearchInRotatedSortedArrayTest {
    SearchInRotatedSortedArray solution;

    @Before
    public void setUp() throws Exception {
        solution = new SearchInRotatedSortedArray();
    }

    @Test
    public void testcase1() {
        Assert.assertEquals(-1, solution.search(ResourceUtil.parseLineToIntArray("[4,5,6,7,0,1,2]"), 3));
    }

    @Test
    public void testcase2() {
        Assert.assertEquals(4, solution.search(ResourceUtil.parseLineToIntArray("[4,5,6,7,0,1,2]"), 0));
    }

    @Test
    public void testcase3() {
        Assert.assertEquals(1, solution.search(new int[]{1, 3, 5}, 3));
    }

    @Test
    public void testcase4() {
        int i =0, j=1;
        Assert.assertEquals(0, solution.search(new int[]{5, 1, 3}, 5));
    }
}