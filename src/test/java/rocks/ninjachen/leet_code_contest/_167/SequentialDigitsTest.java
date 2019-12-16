package rocks.ninjachen.leet_code_contest._167;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SequentialDigitsTest {
    SequentialDigits solution;

    @Before
    public void setUp() throws Exception {
        solution = new SequentialDigits();
    }

    @Test
    public void sequentialDigits() {
        System.out.println(solution.sequentialDigits(100, 300));
    }
}