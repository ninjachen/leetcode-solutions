package rocks.ninjachen.leet_code_solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/spiral-matrix/
 * Created by ninja on 3/1/16.
 */
public class SpiralMatrixSolution {
    static final int RIGHT = 0;
    static final int DOWN = 1;
    static final int LEFT = 2;
    static final int UP = 3;

    public static void main(String[] arg) {
        SpiralMatrixSolution solution = new SpiralMatrixSolution();
        int[][] matrix = {{1,2,3}

                                };
        List<Integer> integers = solution.spiralOrder(matrix);
        for (int i : integers){
            System.out.print(i);
            System.out.print(System.lineSeparator());
        }
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix.length ==0)   return  new ArrayList<>();
        int direction = RIGHT;
        final int rows = matrix.length;
        final int cols = matrix[0].length;
        int curX = 0;
        int curY = 0;
        boolean[][] trace = new boolean[rows][cols];
        List<Integer> result = new ArrayList<>(rows * cols);
        while (true){
            if(!trace[curY][curX]){
                result.add(matrix[curY][curX]);
                trace[curY][curX]=true;
            }
            if(isEnd(result, rows, cols)){
                return result;
            }
            int[] curPosition = {curY, curX};
            if(!canForward(direction, curPosition, trace))
                direction = turnRight(direction);
            int[] nextPosition = getNext(direction, curPosition);
            curX = nextPosition[1];
            curY = nextPosition[0];
        }
    }

    private int[] getNext(int direction, int[] curPosition) {
        int[] nextPosition = {curPosition[0], curPosition[1]};
        switch (direction){
            case RIGHT:
                nextPosition[1]++;
                return nextPosition;
            case DOWN:
                nextPosition[0]++;
                return nextPosition;
            case LEFT:
                nextPosition[1]--;
                return nextPosition;
            case UP:
                nextPosition[0]--;
                return nextPosition;
            default:
                return null;
        }
    }

    private boolean isEnd(List<Integer> result, int rows, int cols) {
        if(result.size() == rows * cols)
            return true;
        return false;
    }

    public boolean canForward(int direction, int[] curPosition, boolean[][] trace){
        System.out.println(String.format("canForward? direction:%d, Y:%d, X:%d",direction,curPosition[0],curPosition[1]));
        int[] nextPosition = getNext(direction, curPosition);
        //check bound
        if(nextPosition[0] <0 || nextPosition[0]>=trace.length || nextPosition[1] < 0 ||nextPosition[1]>=trace[0].length){
            return false;
        }
        return !trace[nextPosition[0]][nextPosition[1]];
    }

    public int turnRight(int origin){
//        System.out.println(String.format("turnRight"));
        return ( origin + 1 ) % 4;
    }
}