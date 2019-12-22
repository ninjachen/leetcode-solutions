package rocks.ninjachen.leet_code_contest._168;

import org.junit.Before;
import org.junit.Test;
import rocks.ninjachen.util.ResourceUtil;

import static org.junit.Assert.*;

public class IsPossibleDivideTest {
    IsPossibleDivide solution;

    @Before
    public void setUp() throws Exception {
        solution = new IsPossibleDivide();
    }

    @Test
    public void isPossibleDivide() {
        int[] arr = ResourceUtil.parseLineToIntArray("[15,16,17,18,19,16,17,18,19,20,6,7,8,9,10,3,4,5,6,20]");
        assertEquals(false, solution.isPossibleDivide(arr, 5));
    }
}