package rocks.ninjachen.leet_code_solutions;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CoinChangeTest {
    CoinChange solution;

    @Before
    public void setUp() throws Exception {
        solution = new CoinChange();
    }

    @Test
    public void testcase1() {
        Assert.assertEquals(-1, solution.coinChange(new int[]{2}, 3));
    }

//    @Test
//    public void testcase11() {
//        Set<List<Integer>> set = new HashSet<>();
//        set.add(Arrays.asList(1,2,3));
//        set.add(Arrays.asList(1,2,3));
//        Assert.assertEquals(1, set.size());
//        Assert.assertEquals(-1, solution.coinChange(new int[]{2}, 3));
//    }
}