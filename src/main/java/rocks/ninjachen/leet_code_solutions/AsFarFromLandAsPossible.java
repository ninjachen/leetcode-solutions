package rocks.ninjachen.leet_code_solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public static Map<String, Integer> cache = new HashMap<>();

    public int maxDistance(int[][] grid) {
        int distanceMax = -1;
        List<String> waterList = new ArrayList<>();
        List<String> landList = new ArrayList<>();
        int len = grid.length;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                // if cell is water, find the far-est land
                if (grid[i][j] == 0) {
                    waterList.add(i+","+j);
                }else {
                    landList.add(i+","+j);
                }
            }
        }
        if(waterList.isEmpty() || landList.isEmpty()){
            return -1;
        }
        for (String cell : waterList){
            String [] ints = cell.split(",");
            int i = Integer.valueOf(ints[0]);
            int j = Integer.valueOf(ints[1]);
            int distanceFar = findNearestLandDistance(i, j, landList, len, grid);
            if (distanceFar > distanceMax) {
                distanceMax = distanceFar;
            }
        }
        return distanceMax;
    }

    private int findNearestLandDistance(int waterCellI, int waterCellJ, List<String> landList, int len, int[][] grid) {
        int minDistance = -1;
        for (String cell : landList){
            String [] ints = cell.split(",");
            int i = Integer.valueOf(ints[0]);
            int j = Integer.valueOf(ints[1]);
            int distance = getDistance(waterCellI, waterCellJ, i, j);
            if (minDistance == -1 || distance < minDistance) {
                minDistance = distance;
            }
        }
        for (int distance = 1; ;distance++){
            int landI,landJ;
            landI = waterCellI - distance;
            landJ = waterCellJ;
            if(landI > 0 && landI < len){
                if(grid[landI][landJ] == 1){
                    return distance;
                }
            }
            landI = waterCellI + distance;
            landJ = waterCellJ;
            if(landI > 0 && landI < len){
                if(grid[landI][landJ] == 1){
                    return distance;
                }
            }
            landI = waterCellI;
            landJ = waterCellJ - distance;
            if(landJ > 0 && landJ < len){
                if(grid[landI][landJ] == 1){
                    return distance;
                }
            }
            landI = waterCellI;
            landJ = waterCellJ + distance;
            if(landJ > 0 && landJ < len){
                if(grid[landI][landJ] == 1){
                    return distance;
                }
            }
            return minDistance;
//            if(distance)
        }


//        return minDistance;
    }

    private int getDistance(int i1, int j1, int i2, int j2) {
        String key = String.format("%d,%d_%d,%d", i1,j1,i2,j2);
        Integer distance = cache.get(key);
        if (distance == null) {
            distance = Math.abs(i1 - i2) + Math.abs(j1 - j2);
            cache.put(key, distance);
            String key2 = String.format("%d,%d_%d,%d", i2,j2,i1,j1);
            cache.put(key2, distance);
        }
        return distance;
    }
}
