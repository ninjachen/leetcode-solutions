package rocks.ninjachen.leet_code_solutions;

/**
 * binary gap
 * https://codility.com/c/run/trainingFS5GBU-CJ2#
 * Created by ninja on 6/7/16.
 */
class BinaryGap {
    public static void main(String[] arg){
        testCase1();
    }

    private static void testCase1() {
        BinaryGap binaryGap = new BinaryGap();
        System.out.println(binaryGap.solution(1041));
        System.out.println(0>>1);
    }

    public int solution(int N) {
        // write your code in Java SE 8
        int cur = 0;
        int max = 0;
        //skip all the 0s at the end
        while(((N & 1) == 0) && (N > 0 )){
            N = N >> 1;
        }

        while( N > 0){
            if((N & 1) == 0){
                cur++;
            }else{
                if(cur > max){
                    max = cur;
                }
                cur = 0;
            }
            N = N >> 1;
        }
        return max;
    }
}