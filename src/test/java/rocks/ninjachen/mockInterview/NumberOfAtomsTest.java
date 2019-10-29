package rocks.ninjachen.mockInterview;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NumberOfAtomsTest {
    NumberOfAtoms solution;

    @Before
    public void setUp() throws Exception {
        solution = new NumberOfAtoms();
    }

    @Test
    public void countOfAtoms() {
        System.out.println(solution.countOfAtoms("Mg(OH)2"));
    }

    @Test
    public void countOfAtoms2() {
        System.out.println(solution.countOfAtoms("Be32"));
    }
}