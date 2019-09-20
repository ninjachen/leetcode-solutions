package rocks.ninjachen.leet_code_contest._150;

import java.util.BitSet;

/**
 * https://leetcode.com/contest/weekly-contest-150/problems/as-far-from-land-as-possible/
 * Given an N x N grid containing only values 0 and 1, where 0 represents water and 1 represents land, find a water cell such that its distance to the nearest land cell is maximized and return the distance.
 * <p>
 * The distance used in this problem is the Manhattan distance: the distance between two cells (x0, y0) and (x1, y1) is |x0 - x1| + |y0 - y1|.
 * <p>
 * If no land or water exists in the grid, return -1.
 * <p>
 * use origin matrix, 0 is water, 1 is land, 2~ is water with (nearest) distance
 */
@SuppressWarnings("Duplicates")
public class AsFarFromLandAsPossible {
    public int maxDistance(int[][] grid) {
        boolean allWater = true;
        boolean allLand = true;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    allWater = false;
                } else if (grid[i][j] == 0) {
                    allLand = false;
                }
            }
        }
        if (allWater || allLand) {
            return -1;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, 0, new BitSet());
                } else if (grid[i][j] == 0) {
                }
            }
        }
        int distanceMax = -1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 1) {
                    int distance = grid[i][j];
                    if (distance == -1) {
                        distance = 1;
                    }
                    distanceMax = Math.max(distanceMax, distance);
                }
            }
        }
        return distanceMax;
    }

    private void dfs(int[][] grid, int i, int j, int distance, BitSet visitedLandBitSet) {
        // End when out of bound, or water cell has a smaller distance.
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return;
        }
        int index = i * grid.length + j;
        // Skip visited
        if(visitedLandBitSet.get(index)){
            return;
        }
        if (grid[i][j] == -1 || (grid[i][j] > 1 && grid[i][j] < distance)) {
            return;
        }
        // Land cell, create new scanner
        if (grid[i][j] == 1) {
            distance = 0;
            visitedLandBitSet.set(index);
            dfs(grid, i, j + 1, distance + 1, visitedLandBitSet);
            dfs(grid, i, j - 1, distance + 1, visitedLandBitSet);
            dfs(grid, i + 1, j, distance + 1, visitedLandBitSet);
            dfs(grid, i - 1, j, distance + 1, visitedLandBitSet);
        }
        // Water cell has a smaller distance, update value.
        if (grid[i][j] == 0 || (grid[i][j] > 1 && grid[i][j] > distance)) {
            // -1 is water's distance 1;
            if (distance == 1) {
                grid[i][j] = -1;
            } else {
                grid[i][j] = distance;
            }
            dfs(grid, i, j + 1, distance + 1, visitedLandBitSet);
            dfs(grid, i, j - 1, distance + 1, visitedLandBitSet);
            dfs(grid, i + 1, j, distance + 1, visitedLandBitSet);
            dfs(grid, i - 1, j, distance + 1, visitedLandBitSet);
        }
    }
}
