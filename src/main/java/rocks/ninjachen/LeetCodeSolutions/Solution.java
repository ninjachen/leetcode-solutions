package rocks.ninjachen.LeetCodeSolutions;

/**
 * Created by ninja on 6/7/16.
 */
class Solution {
    public static void main(String[] arg){
        testCase1();
    }

    private static void testCase1() {
        Solution solution = new Solution();
        System.out.println(solution.solution(1024));
    }

    public int solution(int N) {
        // write your code in Java SE 8
        int maxCount=0;
        int curCount=0;
        while(N > 0){
            if((N|0) == 0){
                curCount++;
            }else{
                if(curCount > maxCount){
                    maxCount=curCount;
                    curCount=0;
                }
            }
            N = N >> 1;
        }
        if(curCount > maxCount){
            maxCount = curCount;
            curCount=0;
        }
        return maxCount;
    }
}