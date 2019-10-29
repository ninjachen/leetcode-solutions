package rocks.ninjachen.mockInterview;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LengthOfLongestSubstringKDistinctTest {
    LengthOfLongestSubstringKDistinct solution;

    @Before
    public void setUp() throws Exception {
        solution = new LengthOfLongestSubstringKDistinct();
    }

    @Test
    public void lengthOfLongestSubstringKDistinct() {
        Assert.assertEquals(3, solution.lengthOfLongestSubstringKDistinct("eceba", 2));
    }

    @Test
    public void lengthOfLongestSubstringKDistinct2() {
        Assert.assertEquals(5, solution.lengthOfLongestSubstringKDistinct("aaabc", 3));
    }

    @Test
    public void lengthOfLongestSubstringKDistinct3() {
        Assert.assertEquals(4, solution.lengthOfLongestSubstringKDistinct("abaccc", 2));
    }

    @Test
    public void lengthOfLongestSubstringKDistinct4() {
        Assert.assertEquals(1, solution.lengthOfLongestSubstringKDistinct("aba", 1));
    }

}