package rocks.ninjachen.leet_code_contest._165;

import org.junit.Before;
import org.junit.Test;
import rocks.ninjachen.util.ResourceUtil;

import static org.junit.Assert.*;

public class TictactoeTest {
    Tictactoe solution;
    @Before
    public void setUp() throws Exception {
        solution = new Tictactoe();
    }

    @Test
    public void tictactoe() {
        assertEquals("A", solution.tictactoe(ResourceUtil.parse2dArray("[[0,0],[2,0],[1,1],[2,1],[2,2]]")));
    }

}