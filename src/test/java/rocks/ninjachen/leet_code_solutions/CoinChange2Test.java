package rocks.ninjachen.leet_code_solutions;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CoinChange2Test {
    CoinChange2 solution;

    @Before
    public void setUp() throws Exception {
        solution = new CoinChange2();
    }

    @Test
    public void change() {
        System.out.println(solution.change(500, new int[]{1, 2, 5}));
    }
}