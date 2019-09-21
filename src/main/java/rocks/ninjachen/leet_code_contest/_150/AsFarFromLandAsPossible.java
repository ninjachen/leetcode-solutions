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
    public static class Cell {
        private int i;
        private int j;

        public Cell(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Cell cell = (Cell) o;
            return getI() == cell.getI() &&
                    getJ() == cell.getJ();
        }

        @Override
        public int hashCode() {
            return Objects.hash(getI(), getJ());
        }
    }

    public int maxDistance(int[][] grid) {
        Set<Cell> waterSet = new HashSet<>();
        Set<Cell> landSet = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
//                int index = i * grid[0].length + j;
                if (grid[i][j] == 1) {
                    landSet.add(new Cell(i, j));
                } else if (grid[i][j] == 0) {
                    waterSet.add(new Cell(i, j));
                }
            }
        }
        if (waterSet.isEmpty() || landSet.isEmpty()) {
            return -1;
        }
        // Mark every water cell with distance 1
        for (int distance = 1; !waterSet.isEmpty(); distance++) {
            for (Cell landIndex : landSet) {
                int i = landIndex.getI();
                int j = landIndex.getJ();
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
    private void setDistance(int i, int j, int[][] grid, Set<Cell> waterSet, int distance) {
//        int index = i * grid[0].length + j;
        // Out of bounds
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length){
            return;
        }
        Cell cell = new Cell(i, j);
        if(grid[i][j] == 0 && waterSet.contains(cell)){
            grid[i][j] = distance + 1;
            waterSet.remove(cell);
        }
    }
}
