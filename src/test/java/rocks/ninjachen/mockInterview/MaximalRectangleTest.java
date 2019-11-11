package rocks.ninjachen.mockInterview;

import org.junit.Before;
import org.junit.Test;
import rocks.ninjachen.hacker_rank_soulutions.Constants;
import rocks.ninjachen.util.ResourceUtil;

import java.util.List;

import static org.junit.Assert.*;

public class MaximalRectangleTest {
    MaximalRectangle solution;

    @Before
    public void setUp() throws Exception {
        solution = new MaximalRectangle();
    }

    @Test
    public void maximalRectangle() {
//        assertEquals('1', '0' + Integer.parseInt("1"));
//        assertEquals('1', "1".toCharArray()[0]);
        char[][] matrix = ResourceUtil.parseLineToCharArray("[[\"1\",\"0\",\"1\",\"0\",\"0\"],[\"1\",\"0\",\"1\",\"1\",\"1\"],[\"1\",\"1\",\"1\",\"1\",\"1\"],[\"1\",\"0\",\"0\",\"1\",\"0\"]]");
        assertEquals(6, solution.maximalRectangle(matrix));
    }

    @Test
    public void maximalRectangle2() {
        char[][] matrix = ResourceUtil.parseLineToCharArray("[[\"0\"]]");
        assertEquals(0, solution.maximalRectangle(matrix));
    }

    @Test
    public void maximalRectangle3() {
        char[][] matrix = ResourceUtil.parseLineToCharArray("[[\"1\",\"0\",\"1\",\"1\",\"1\"],[\"0\",\"1\",\"0\",\"1\",\"0\"],[\"1\",\"1\",\"0\",\"1\",\"1\"],[\"1\",\"1\",\"0\",\"1\",\"1\"],[\"0\",\"1\",\"1\",\"1\",\"1\"]]");
        assertEquals(6, solution.maximalRectangle(matrix));
    }

    @Test
    public void maximalRectangle4() {
        char[][] matrix = ResourceUtil.parseLineToCharArray("[[\"0\",\"1\",\"1\",\"0\",\"1\"],[\"1\",\"1\",\"0\",\"1\",\"0\"],[\"0\",\"1\",\"1\",\"1\",\"0\"],[\"1\",\"1\",\"1\",\"1\",\"0\"],[\"1\",\"1\",\"1\",\"1\",\"1\"],[\"0\",\"0\",\"0\",\"0\",\"0\"]]");
        assertEquals(9, solution.maximalRectangle(matrix));
    }

    @Test
    public void maximalRectangle5() {
        String name = Constants.BASE_DIR_LEETCODE + "maximal-rectangle";
        List<String> lines = ResourceUtil.getResourceLines(getClass().getClassLoader(), name);
        char[][] matrix = ResourceUtil.parseLineToCharArray(lines.get(0));
        assertEquals(147, solution.maximalRectangle(matrix));
    }
}