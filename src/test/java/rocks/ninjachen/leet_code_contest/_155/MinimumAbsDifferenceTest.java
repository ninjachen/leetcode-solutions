package rocks.ninjachen.leet_code_contest._155;


import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class MinimumAbsDifferenceTest {
    MinimumAbsDifference soulution;

    @Before
    public void setUp() throws Exception {
        soulution = new MinimumAbsDifference();
    }

    @Test
    public void testCase1() {
        int[] arr = {40,11,26,27,-20};
        System.out.println(soulution.minimumAbsDifference(arr));
    }
}