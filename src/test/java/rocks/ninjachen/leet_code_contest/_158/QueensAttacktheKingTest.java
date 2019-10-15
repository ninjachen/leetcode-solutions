package rocks.ninjachen.leet_code_contest._158;

import org.junit.Before;
import org.junit.Test;
import rocks.ninjachen.util.ResourceUtil;

import static org.junit.Assert.*;

public class QueensAttacktheKingTest {
    QueensAttacktheKing solution;

    @Before
    public void setUp() throws Exception {
        solution = new QueensAttacktheKing();
    }

    @Test
    public void queensAttacktheKing() {
        int[][] queens = ResourceUtil.parse2dArray("[[0,1],[6,4],[4,7],[0,0],[3,3],[7,7],[2,1],[1,6],[0,4],[4,3],[2,4],[3,7],[3,4],[1,1]]");
        int[] king = ResourceUtil.parseLineToIntArray("[7,2]");
        System.out.println(solution.queensAttacktheKing(queens, king));
    }
}