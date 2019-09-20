package rocks.ninjachen.leet_code_contest._150;

import java.util.*;

/**
 * https://leetcode.com/contest/weekly-contest-150/problems/as-far-from-land-as-possible/
 * Given an N x N grid containing only values 0 and 1, where 0 represents water and 1 represents land, find a water cell such that its distance to the nearest land cell is maximized and return the distance.
 * <p>
 * The distance used in this problem is the Manhattan distance: the distance between two cells (x0, y0) and (x1, y1) is |x0 - x1| + |y0 - y1|.
 * <p>
 * If no land or water exists in the grid, return -1.
 */
@SuppressWarnings("Duplicates")
public class AsFarFromLandAsPossible {
    public int maxDistance(int[][] grid) {
        BitSet waterBitSet = new BitSet();
        List<Cell> landList = new ArrayList<>();
        int[][] nearestDistanceMatrix = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                //init
                nearestDistanceMatrix[i][j] = -1;
                // if cell is water, save to water cell list
                if (grid[i][j] == 0) {
                    waterBitSet.set(i * grid[0].length + j);
                } else {
                    landList.add(new Cell(i, j));
                }
            }
        }
        if (waterBitSet.isEmpty() || landList.isEmpty()) {
            return -1;
        }
        // For every land cell, calculate the distance to water cell
        for (Cell landCell : landList) {
            parseLandCell(landCell, waterBitSet, nearestDistanceMatrix);
        }
        int distanceMax = -1;
        for (int i = 0; i < nearestDistanceMatrix.length; i++) {
            for (int j = 0; j < nearestDistanceMatrix[0].length; j++) {
                distanceMax = Math.max(distanceMax, nearestDistanceMatrix[i][j]);
            }
        }
        return distanceMax;
    }

    private void parseLandCell(Cell landCell, BitSet waterBitSet, int[][] nearestDistanceMatrix) {
        int landCellI = landCell.getI();
        int landCellJ = landCell.getJ();
        boolean setDistanceOK = true;
        for (int dis = 1; setDistanceOK; dis++) {
            // all set false, then false
            boolean insideBounds = false;
            for (int i = 0; i <= dis; i++) {
                insideBounds = insideBounds | setDistance(landCellI + i, landCellJ + (dis - i), dis, nearestDistanceMatrix, waterBitSet);
                insideBounds = insideBounds | setDistance(landCellI + i, landCellJ - (dis - i), dis, nearestDistanceMatrix, waterBitSet);
                insideBounds = insideBounds | setDistance(landCellI - i, landCellJ + (dis - i), dis, nearestDistanceMatrix, waterBitSet);
                insideBounds = insideBounds | setDistance(landCellI - i, landCellJ - (dis - i), dis, nearestDistanceMatrix, waterBitSet);
            }
            setDistanceOK = insideBounds;
        }

    }

    /**
     * A safe setter
     *
     * @param i
     * @param j
     * @param distance
     * @param distanceMatrix
     * @param waterBitSet
     * @return
     */
    private boolean setDistance(int i, int j, int distance, int[][] distanceMatrix, BitSet waterBitSet) {
        if (i >= 0 && i < distanceMatrix.length
                && j >= 0 && j < distanceMatrix[0].length) {
            // If the cell is water
            if(waterBitSet.get(i*distanceMatrix[0].length + j)){
                int originValue = distanceMatrix[i][j];
                // Set nearest distance
                if(originValue == -1 || originValue > distance){
                    distanceMatrix[i][j] = distance;
                }
            }
            return true;
        }
        return false;
    }

    public static class Cell {
        int i;
        int j;

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
    }
}
