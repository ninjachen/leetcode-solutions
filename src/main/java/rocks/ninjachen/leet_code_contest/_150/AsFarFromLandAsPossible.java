package rocks.ninjachen.leet_code_contest._150;

import java.util.*;

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
        Set<Integer> waterSet = new HashSet<>();
        Set<Integer> landSet = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int index = i * grid[0].length + j;
                if (grid[i][j] == 1) {
                    landSet.add(index);
                } else if (grid[i][j] == 0) {
                    waterSet.add(index);
                }
            }
        }
        if (waterSet.isEmpty() || landSet.isEmpty()) {
            return -1;
        }
        // Mark every water cell with distance 1
        for (int distance = 1; !waterSet.isEmpty(); distance++) {
            for (int landIndex : landSet) {
                int i = landIndex / grid[0].length;
                int j = landIndex % grid[0].length;
                for (int z = 0; z <= distance; z++) {
                    setDistance(i + z, j + (distance - z), grid, waterSet, distance);
                    setDistance(i + z, j - (distance - z), grid, waterSet, distance);
                    setDistance(i - z, j + (distance - z), grid, waterSet, distance);
                    setDistance(i - z, j - (distance - z), grid, waterSet, distance);
                }
            }

        }
        int distanceMax = -1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 1) {
                    int distance = grid[i][j];
                    distanceMax = Math.max(distanceMax, distance -1);
                }
            }
        }
        return distanceMax;
    }

    /**
     * The distance write to the original matrix is 1-based. Eg 2 on the matrix is distance 1;
     * @param i
     * @param j
     * @param grid
     * @param waterSet
     * @param distance
     */
    private void setDistance(int i, int j, int[][] grid, Set<Integer> waterSet, int distance) {
        int index = i * grid[0].length + j;
        // Out of bounds
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length){
            return;
        }
        if(grid[i][j] == 0 && waterSet.contains(index)){
            grid[i][j] = distance + 1;
            waterSet.remove(index);
        }
    }
}
