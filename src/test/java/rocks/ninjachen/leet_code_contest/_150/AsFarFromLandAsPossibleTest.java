package rocks.ninjachen.leet_code_contest._150;

import org.junit.Before;
import org.junit.Test;
import rocks.ninjachen.hacker_rank_soulutions.Constants;
import rocks.ninjachen.util.ResourceUtil;

import java.util.List;

public class AsFarFromLandAsPossibleTest {
    AsFarFromLandAsPossible solution;

    @Before
    public void setUp() throws Exception {
        solution = new AsFarFromLandAsPossible();
    }

    @Test
    public void maxDistance() {
        String name = Constants.BASE_DIR_LEETCODE + "as-far-from-land-as-possible";
        List<String> lines = ResourceUtil.getResourceLines(getClass().getClassLoader(), name);
        int[][] grid = ResourceUtil.parse2dArray(lines.get(0));
        System.out.println(solution.maxDistance(grid));
    }
}