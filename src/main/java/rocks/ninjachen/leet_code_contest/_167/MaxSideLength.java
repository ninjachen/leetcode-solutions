package rocks.ninjachen.leet_code_contest._167;

public class MaxSideLength {
    public int maxSideLength(int[][] mat, int threshold) {
        // int i = 0, j = 0;
        int sideLen = 1;
        int rowLen = mat.length;
        int colLen = mat[0].length;
        // boolean visited = new boolean[rowLen][colLen];
        int maxSideLen = 0;
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                int maxSideLenSub = dfs(i, j, mat, maxSideLen, threshold);
                maxSideLen = Math.max(maxSideLen, maxSideLenSub);
            }
        }
        return maxSideLen;
    }

    private int dfs(int i, int j, int[][] mat, int maxSideLen, int threshold) {
        int rowLen = mat.length;
        int colLen = mat[0].length;
        if (i + maxSideLen > rowLen || j + maxSideLen > colLen) {
            return -1;
        }
        int sum = 0;
        if (maxSideLen > 0) {
            for (int ii = i; ii < i + maxSideLen - 1; ii++) {
                for (int jj = j; jj < j + maxSideLen - 1; jj++) {
                    sum += mat[ii][jj];
                }
            }
        }
        // int ii = i + maxSideLen - 1;
        maxSideLen++;
        while (true) {
            if (i + maxSideLen > rowLen || j + maxSideLen > colLen) {
                break;
            }
            for (int ii = i; ii <= i + maxSideLen - 1; ii++) {
                sum += mat[ii][j + maxSideLen - 1];
            }
            for (int jj = j; jj <= j + maxSideLen - 1; jj++) {
                sum += mat[i + maxSideLen - 1][jj];
            }
            sum -= mat[i + maxSideLen - 1][j + maxSideLen - 1];
            if (sum > threshold) {
                break;
            } else {
                maxSideLen++;
            }
        }
        return maxSideLen - 1;
    }
}
