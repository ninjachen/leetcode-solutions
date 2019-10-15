package rocks.ninjachen.leet_code_contest._158;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/contest/weekly-contest-158/problems/queens-that-can-attack-the-king
 */
public class QueensAttacktheKing {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> result = new ArrayList<>();
        //Add all queen cordinate to hashset
        Set<Integer> queenSet = new HashSet<>();
        for (int k = 0; k < queens.length; k++) {
            int row = queens[k][0];
            int col = queens[k][1];
            queenSet.add(row * 8 + col);
        }
        int i = king[0], j = king[1];
        // 1. i++
        int i1 = i + 1, j1 = j;
        while (i1 >= 0 && i1 < 8 && j1 >= 0 && j1 < 8) {
            if (contains(queenSet, i1, j1, result)) {
                break;
            }
            i1++;
        }
        // 2. i--
        i1 = i - 1;
        j1 = j;
        while (i1 >= 0 && i1 < 8 && j1 >= 0 && j1 < 8) {
            if (contains(queenSet, i1, j1, result)) {
                break;
            }
            i1--;
        }
        // 3. j++
        i1 = i;
        j1 = j + 1;
        while (i1 >= 0 && i1 < 8 && j1 >= 0 && j1 < 8) {
            if (contains(queenSet, i1, j1, result)) {
                break;
            }
            j1++;
        }
        // 4. j--
        i1 = i;
        j1 = j - 1;
        while (i1 >= 0 && i1 < 8 && j1 >= 0 && j1 < 8) {
            if (contains(queenSet, i1, j1, result)) {
                break;
            }
            j1--;
        }
        // 5. i++ j++
        i1 = i + 1;
        j1 = j + 1;
        while (i1 >= 0 && i1 < 8 && j1 >= 0 && j1 < 8) {
            if (contains(queenSet, i1, j1, result)) {
                break;
            }
            i1++;
            j1++;
        }
        // 6. i++ j--
        i1 = i + 1;
        j1 = j - 1;
        while (i1 >= 0 && i1 < 8 && j1 >= 0 && j1 < 8) {
            if (contains(queenSet, i1, j1, result)) {
                break;
            }
            i1++;
            j1--;
        }
        // 7. i-- j++
        i1 = i - 1;
        j1 = j + 1;
        while (i1 >= 0 && i1 < 8 && j1 >= 0 && j1 < 8) {
            if (contains(queenSet, i1, j1, result)) {
                break;
            }
            i1--;
            j1++;
        }
        // 8. i-- j--
        i1 = i - 1;
        j1 = j - 1;
        while (i1 >= 0 && i1 < 8 && j1 >= 0 && j1 < 8) {
            if (contains(queenSet, i1, j1, result)) {
                break;
            }
            i1--;
            j1--;
        }
        return result;
    }

    private boolean contains(Set<Integer> queenSet, int i1, int j1, List<List<Integer>> result) {
        if (queenSet.contains(i1 * 8 + j1)) {
            List<Integer> queenCell = new ArrayList<>();
            queenCell.add(i1);
            queenCell.add(j1);
            result.add(queenCell);
            return true;
        } else {
            return false;
        }
    }
}
