package rocks.ninjachen.leet_code_solutions;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FirstMissingPositiveTest {
    FirstMissingPositive solution;

    @Before
    public void setUp() throws Exception {
        solution = new FirstMissingPositive();
    }

    @Test
    public void firstMissingPositive() {
        Assert.assertEquals(3, solution.firstMissingPositive(new int[]{1,2,0}));
    }

    @Test
    public void firstMissingPositive2() {
        Assert.assertEquals(2, solution.firstMissingPositive(new int[]{3,4,-1,1}));
    }

    @Test
    public void firstMissingPositive3() {
        Assert.assertEquals(3, solution.firstMissingPositive(new int[]{2, 1}));
    }

}