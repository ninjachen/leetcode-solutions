package rocks.ninjachen.leet_code_contest._160;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class MaxLengthTest {
    MaxLength solution;

    @Before
    public void setUp() throws Exception {
        solution = new MaxLength();
    }

    @Test
    public void testcase1() {
        assertEquals(4, solution.maxLength(Arrays.asList("un", "iq", "ue")));
    }

    @Test
    public void testcase2() {
        assertEquals(16, solution.maxLength(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p")));
    }

    @Test
    public void testcase3() {
        assertEquals(16, solution.maxLength(Arrays.asList("ab", "ba", "cd", "dc", "ef", "fe", "gh", "hg", "ij", "ji", "kl", "lk", "mn", "nm", "op", "po")));
    }

    @Test
    public void testcase4() {
        assertEquals(20, solution.maxLength(Arrays.asList("xdvqiefpcs","vgnacw","raobcnwgufztdykmsvlj")));
    }

}