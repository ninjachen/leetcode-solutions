package rocks.ninjachen.mockInterview;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class MaximalRectangle {
    static boolean[][] used;

    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0)
            return 0;
        used = new boolean[matrix.length][matrix[0].length];
        Set<Square> allsquare = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    allsquare.add(new Square(i, j, i, j));
                }
            }
        }
        Set<Square> curLoop = new HashSet<>(allsquare);
        // first loop
        if (!curLoop.isEmpty()) {
            Set<Square> nextLoop = new HashSet<>();
            for (Square square : curLoop) {
                if(square.i1 == square.i2 && square.j1 == square.j2) {
                    if(used[square.i1][square.j1])
                        continue;;
                }
                Set<Square> squares = bfs(square, matrix);
                for (Square s : squares) {
                    if (allsquare.add(s)) {
                        nextLoop.add(s);
                    }
                    used[s.i1][s.j1] = true;
                    used[s.i2][s.j2] = true;
                }
            }
            curLoop = nextLoop;
        }
        while (!curLoop.isEmpty()) {
            Set<Square> nextLoop = new HashSet<>();
            for (Square square : curLoop) {
                Set<Square> squares = bfs(square, matrix);
                for (Square s : squares) {
                    if (allsquare.add(s)) {
                        nextLoop.add(s);
                    }
                }
            }
            curLoop = nextLoop;
        }
        int maxsize = 0;
        for (Square square : allsquare) {
            int size = ((square.i2 - square.i1) + 1) * ((square.j2 - square.j1) + 1);
            maxsize = Math.max(maxsize, size);
        }
        return maxsize;
    }

    public Set<Square> bfs(Square square, char[][] matrix) {
        int i1 = square.i1;
        int j1 = square.j1;
        int i2 = square.i2;
        int j2 = square.j2;
        int ii, jj;
        Set<Square> result = new HashSet<>();
        // use cache
        if (isone(i1 - 1, j1, matrix)) {
            ii = i1 - 1;
            boolean allone = true;
            for (jj = j1; jj <= j2; jj++) {
                if (!isone(ii, jj, matrix)) {
                    allone = false;
                    break;
                }
            }
            if (allone) {
                setused(ii, j1, ii, j2, matrix);
//                i1 = ii;
                result.add(new Square(ii, j1, i2, j2));
            }
        }
        if (isone(i1, j1 - 1, matrix)) {
            //  j1 => j1 - 1
            jj = j1 - 1;
            boolean allone = true;
            for (ii = i1; ii <= i2; ii++) {
                if (!isone(ii, jj, matrix)) {
                    allone = false;
                    break;
                }
            }
            if (allone) {
                setused(i1, jj, i2, jj, matrix);
//                j1 = jj;
                result.add(new Square(i1, jj, i2, j2));
            }
        }
        if (isone(i2 + 1, j2, matrix)) {
            //
            ii = i2 + 1;
            boolean allone = true;
            for (jj = j1; jj <= j2; jj++) {
                if (!isone(ii, jj, matrix)) {
                    allone = false;
                    break;
                }
            }
            if (allone) {
                setused(ii, j1, ii, j2, matrix);
//                i2 = ii;
                result.add(new Square(i1, j1, ii, j2));
            }
        }
        if (isone(i2, j2 + 1, matrix)) {
            jj = j2 + 1;
            //  j1 => j1 + 1
            boolean allone = true;
            for (ii = i1; ii <= i2; ii++) {
                if (!isone(ii, jj, matrix)) {
                    allone = false;
                    break;
                }
            }
            if (allone) {
                setused(i1, jj, i2, jj, matrix);
//                j2 = jj;
                result.add(new Square(i1, j1, i2, jj));
            }
        }
        return result;
    }

    public boolean isone(int i, int j, char[][] matrix) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length) {
            return false;
        } else {
            if (matrix[i][j] == '1') {
                return true;
            } else {
                return false;
            }
        }
    }

    public void setused(int i1, int j1, int i2, int j2, char[][] matrix) {
        for (int ii = i1; ii <= i2; ii++) {
            for (int jj = j1; jj <= j2; jj++) {
                used[ii][jj] = true;
            }
        }
    }

    static class Square {
        int i1;
        int j1;
        int i2;
        int j2;

        public Square(int i1, int j1, int i2, int j2) {
            this.i1 = i1;
            this.j1 = j1;
            this.i2 = i2;
            this.j2 = j2;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Square square = (Square) o;
            return i1 == square.i1 &&
                    j1 == square.j1 &&
                    i2 == square.i2 &&
                    j2 == square.j2;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i1, j1, i2, j2);
        }
    }

}
