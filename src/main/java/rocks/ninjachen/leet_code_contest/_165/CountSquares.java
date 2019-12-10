package rocks.ninjachen.leet_code_contest._165;

/**
 * https://leetcode.com/contest/weekly-contest-165/problems/count-square-submatrices-with-all-ones/
 */
public class CountSquares {
    public int countSquares(int[][] matrix) {
        int maxLen = Math.min(matrix.length, matrix[0].length);
        int count = 0;
        for (int len = 1; len <= maxLen; len++) {
            for (int i = 0; i < matrix.length - len + 1; i++) {
                for (int j = 0; j < matrix[0].length - len + 1; j++) {
                    if (check(matrix, i, j, len))
                        count++;
                }
            }
        }
        return count;
    }

    public boolean check(int[][] matrix, int i, int j, int len) {
        for (int ii = i; ii < i + len; ii++) {
            for (int jj = j; jj < j + len; jj++) {
                if (matrix[ii][jj] == 0)
                    return false;
            }
        }
        return true;
    }
}
