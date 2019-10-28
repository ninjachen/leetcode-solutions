package rocks.ninjachen.mockInterview;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConvertToTitleTest {
    ConvertToTitle solution;

    @Before
    public void setUp() throws Exception {
        solution = new ConvertToTitle();
    }

    @Test
    public void testcase1() {
        assertEquals("A", solution.convertToTitle(1));
    }

    @Test
    public void testcase2() {
        assertEquals("B", solution.convertToTitle(2));
    }

    @Test
    public void testcase3() {
        assertEquals("AA", solution.convertToTitle(27));
    }

    @Test
    public void testcase4() {
        assertEquals("BA", solution.convertToTitle(53));
    }
}