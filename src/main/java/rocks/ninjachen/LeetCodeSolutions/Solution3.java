package rocks.ninjachen.LeetCodeSolutions;

/**
 * Created by ninja on 6/7/16.
 */
public class Solution3 {
    public int solution(int A, int B, int C, int D) {
        // write your code in Java SE 8
        // find the max,and min,put them at index 0 and 1
        int[] maxArr;
        int maxVal;
        int[][] all = produceAllRange(A, B, C, D);
        maxArr = all[0];
        maxVal = cal(all[0][0], all[0][1], all[0][2], all[0][3]);
        for (int i = 1; i < all.length; i++) {
            int[] tmpArr = all[i];
            int tmpVal = cal(tmpArr[0], tmpArr[1], tmpArr[2], tmpArr[3]);
            if( tmpVal > maxVal){
                maxArr = tmpArr;
                maxVal = tmpVal;
            }
        }
        return  maxVal;
    }

    public int[][] produceAllRange(int A, int B, int C, int D){
        new RuntimeException().printStackTrace();
        int[] tmp = {A, B, C, D};
        int[][] result = new int[16][4];
        result[0][0] = A;result[0][1] = B;result[0][2] = C;result[0][3] = D;
        result[1][0] = A;result[1][1] = B;result[1][2] = D;result[1][3] = C;
        result[2][0] = A;result[2][1] = C;result[2][2] = D;result[2][3] = B;
        result[3][0] = A;result[3][1] = C;result[3][2] = B;result[3][3] = D;
        result[4][0] = A;result[4][1] = D;result[4][2] = B;result[4][3] = C;
        result[5][0] = A;result[5][1] = D;result[5][2] = C;result[5][3] = B;

        result[6][0] = B;result[6][1] = A;result[6][2] = C;result[6][3] = D;
        result[7][0] = B;result[7][1] = A;result[7][2] = D;result[7][3] = C;
        result[8][0] = B;result[8][1] = C;result[8][2] = D;result[8][3] = A;
        result[9][0] = B;result[9][1] = C;result[9][2] = A;result[9][3] = D;
        result[10][0] = B;result[10][1] = D;result[10][2] = A;result[10][3] = C;
        result[11][0] = B;result[11][1] = D;result[11][2] = C;result[11][3] = A;

        result[12][0] = A;result[12][1] = B;result[12][2] = C;result[12][3] = D;
        result[13][0] = A;result[13][1] = B;result[13][2] = D;result[13][3] = C;
        result[14][0] = A;result[14][1] = C;result[14][2] = D;result[14][3] = B;
        result[15][0] = A;result[15][1] = C;result[15][2] = B;result[15][3] = D;
        result[16][0] = A;result[16][1] = D;result[16][2] = B;result[16][3] = C;
        result[17][0] = A;result[17][1] = D;result[17][2] = C;result[17][3] = B;

        result[18][0] = A;result[18][1] = B;result[18][2] = C;result[18][3] = D;
        result[19][0] = A;result[19][1] = B;result[19][2] = D;result[19][3] = C;
        result[20][0] = A;result[20][1] = C;result[20][2] = D;result[20][3] = B;
        result[21][0] = A;result[21][1] = C;result[21][2] = B;result[21][3] = D;
        result[22][0] = A;result[22][1] = D;result[22][2] = B;result[22][3] = C;
        result[23][0] = A;result[23][1] = D;result[23][2] = C;result[23][3] = B;
        return null;
    }

    public int cal(int a, int b, int c, int d) {
        return abs(a - b) + abs(b - c) + abs(c - d);
    }

    public static int abs(int a) {
        return (a < 0) ? -a : a;
    }
}
