package rocks.ninjachen.leet_code_contest._164;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountServers {
    public int countServers(int[][] grid) {
        Map<Integer, List<int[]>> rowMap = new HashMap<>();
        Map<Integer, List<int[]>> colMap = new HashMap<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    rowMap.putIfAbsent(i, new ArrayList());
                    colMap.putIfAbsent(j, new ArrayList());
                    int[] cell = new int[]{i, j};
                    rowMap.get(i).add(cell);
                    colMap.get(j).add(cell);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) continue;
                boolean canCommunicate = false;
                List<int[]> cdds = rowMap.get(i);
                if (cdds != null) {
                    for (int[] cdd : cdds) {
                        if (cdd[0] != i || cdd[1] != j) {
                            canCommunicate = true;
                            break;
                        }
                    }
                }
                if (!canCommunicate) {
                    cdds = colMap.get(j);
                    if (cdds != null) {
                        for (int[] cdd : cdds) {
                            if (cdd[0] != i || cdd[1] != j) {
                                canCommunicate = true;
                                break;
                            }
                        }
                    }
                }
                if (canCommunicate) {
                    count++;
                }
            }
        }
        return count;
    }
}
