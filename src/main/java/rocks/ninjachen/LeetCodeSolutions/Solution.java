package rocks.ninjachen.LeetCodeSolutions;

/**
 * Created by ninja on 6/7/16.
 */
// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] A = {2, 3, -1, 1, 3};
        System.out.print(s.solution(A));
    }

    public int solution(int[] A) {
        // write your code in Java SE 8
        if(A == null) return -1;
        int length = A.length;
        boolean[] visited = new boolean[length];
        int step = 0;
        int curVal = 0;
        int curIndex = 0;
        while(true){
            curVal = A[curIndex];
            visited[curIndex] = true;
            curIndex = curVal + curIndex;
            step++;
            //check is out of range
            if(curIndex > length -1 || curIndex < 0) return step;
            // check infinite loop
            if(visited[curIndex]) return -1;
        }
    }
}