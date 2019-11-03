package rocks.ninjachen.leet_code_contest.bi_12;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LeaderboardTest {
    Leaderboard solution;

    @Before
    public void setUp() throws Exception {
        solution = new Leaderboard();
    }

    @Test
    public void testcase() {
        solution.addScore(1, 73);
        solution.addScore(2, 56);
        solution.addScore(3, 39);
        solution.addScore(4, 51);
        solution.addScore(5, 4);
        assertEquals(73, solution.top(1));
        solution.reset(1);
        solution.reset(2);
        solution.addScore(2, 51);
        assertEquals(141, solution.top(3));
    }
}