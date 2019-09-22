package rocks.ninjachen.leet_code_contest.bi_9;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MinKnightMoves {
    public int minKnightMoves(int x, int y) {
        // Define a area, any runner should be in (0, 0) ~ (xBound, yBound) range;
        List<Cell> allPath = new ArrayList<>();
        List<Cell> list1 = new ArrayList<>();
        List<Cell> list2 = new ArrayList<>();
        int xBound = x > 0 ? x + 4 : x - 4;
        int yBound = y > 0 ? y + 4 : y - 4;
//        list1.add(new Cell(0, 0));
        int x1 = 0, y1 = 0;
        int step = 0;
        while (Math.abs(x1 - x) > 3 || Math.abs(y1 - y) > 3) {
            step++;
            if (Math.abs(x1 - x) > Math.abs(y1 - y)) {
                if(x > x1){
                    x1 = x1 + 2;
                } else {
                    x1 = x1 - 2;
                }
                if(y > y1){
                    y1 = y1 + 1;
                } else {
                    y1 = y1 - 1;
                }
            } else {
                if(x > x1){
                    x1 = x1 + 1;
                } else {
                    x1 = x1 - 1;
                }
                if(y > y1){
                    y1 = y1 + 2;
                } else {
                    y1 = y1 - 2;
                }
            }
        }
        list1.add(new Cell(x1, y1));
        for (step++; ; step++) {
            for (Cell cell : list1) {
                if (genNextCell(cell.getX() + 2, cell.getY() + 1, xBound, yBound, list2, x, y, allPath) ||
                        genNextCell(cell.getX() + 2, cell.getY() - 1, xBound, yBound, list2, x, y, allPath) ||
                        genNextCell(cell.getX() - 2, cell.getY() + 1, xBound, yBound, list2, x, y, allPath) ||
                        genNextCell(cell.getX() - 2, cell.getY() - 1, xBound, yBound, list2, x, y, allPath) ||
                        genNextCell(cell.getX() + 1, cell.getY() + 2, xBound, yBound, list2, x, y, allPath) ||
                        genNextCell(cell.getX() + 1, cell.getY() - 2, xBound, yBound, list2, x, y, allPath) ||
                        genNextCell(cell.getX() - 1, cell.getY() + 2, xBound, yBound, list2, x, y, allPath) ||
                        genNextCell(cell.getX() - 1, cell.getY() - 2, xBound, yBound, list2, x, y, allPath)) {
                    return step;
                }
            }
            // This step not match target, go to next step.
            List<Cell> temp = list1;
            list1 = list2;
            list2 = temp;
        }
    }

    private boolean genNextCell(int x, int y, int xBound, int yBound, List<Cell> list, int targetX, int targetY, List<Cell> allPath) {
        // Skip cells out of bounds and already tracked.
        if (outOfRange(x, xBound)) return false;
        if (outOfRange(y, yBound)) return false;
        Cell cell = new Cell(x, y);
        if (allPath.contains(cell)) {
            return false;
        }
        allPath.add(cell);
        list.add(cell);
        if (x == targetX && y == targetY) {
            return true;
        } else {
            return false;
        }
    }

    private boolean outOfRange(int x, int xBound) {
        if (xBound > 0 && x > xBound) {
            return true;
        }
        if (xBound < 0 && x < xBound) {
            return true;
        }
        return false;
    }

    public static class Cell {
        private int x;
        private int y;

        public Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Cell cell = (Cell) o;
            return getX() == cell.getX() &&
                    getY() == cell.getY();
        }

        @Override
        public int hashCode() {
            return Objects.hash(getX(), getY());
        }
    }

}
