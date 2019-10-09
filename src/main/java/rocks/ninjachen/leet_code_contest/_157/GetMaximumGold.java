package rocks.ninjachen.leet_code_contest._157;

import java.util.ArrayList;
import java.util.List;

public class GetMaximumGold {
    public int getMaximumGold(int[][] grid) {
        int maxGold = 0;
        int rowNum = grid.length;
        int colNum = grid[0].length;
        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < colNum; j++) {
                if (grid[i][j] > 0) {
                    // start dfs
                    int i1 = i, j1 = j;
                    List<Integer> paths = new ArrayList();
                    int pos = unionij(i1, j1, colNum);
                    maxGold = Math.max(maxGold, dfs(i1, j1, grid, paths, 0));
                }
            }
        }
        return maxGold;
    }

    public int unionij(int i, int j, int colNum) {
        return i * colNum + j;
    }

    public int dfs(int i, int j, int[][] mine, List<Integer> paths, int goldNum) {
        int rowNum = mine.length;
        int colNum = mine[0].length;
        if (i < 0 || j < 0 || i >= mine.length || j >= mine[0].length || paths.contains(unionij(i, j, colNum)) || mine[i][j] == 0) {
            return goldNum;
        }
        paths.add(unionij(i, j, colNum));
        goldNum += mine[i][j];
        List<Integer> paths1 = new ArrayList<>();
        paths1.addAll(paths);
        int maxNum = 0;
        maxNum = Math.max(maxNum, dfs(i + 1, j, mine, paths1, goldNum));
        paths1 = new ArrayList<>();
        paths1.addAll(paths);
        maxNum = Math.max(maxNum, dfs(i - 1, j, mine, paths1, goldNum));
        paths1 = new ArrayList<>();
        paths1.addAll(paths);
        maxNum = Math.max(maxNum, dfs(i, j + 1, mine, paths1, goldNum));
        paths1 = new ArrayList<>();
        paths1.addAll(paths);
        maxNum = Math.max(maxNum, dfs(i, j - 1, mine, paths1, goldNum));
        return maxNum;
    }
}
