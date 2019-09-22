package rocks.ninjachen.leet_code_contest.bi_9;

public class SmallestCommonElement {
    public int smallestCommonElement(int[][] mat) {
        int len = mat.length;
        int[] lastIndexArr = new int[len];
        int candidate = -1;
        //First find the max value of first item in each array
        for (int i = 0; i < len; i++) {
            candidate = Math.max(candidate, mat[i][0]);
        }
        while (true) {
            // Check is the candidate common
            if (isCommon(candidate, mat, lastIndexArr)) {
                return candidate;
            }
            candidate = findNextCandidate(candidate, mat, lastIndexArr);
            if(candidate == -1) {
                 return -1;
            }
        }
    }

    private int findNextCandidate(int preCandidate, int[][] mat, int[] lastIndexArr) {
        int nextCandidate = -1;
        for (int i = 0; i < mat.length; i ++) {
            int index = lastIndexArr[i];
            for (int j = index; j < mat[i].length; j++) {
                if(mat[i][j] > preCandidate){
                    lastIndexArr[i] = j;
                    nextCandidate = Math.max(nextCandidate, mat[i][j]);
                    break;
                }
            }
            if(nextCandidate == -1) {
                return nextCandidate;
            }
        }
        return nextCandidate;
    }

    private boolean isCommon(int candidate, int[][] mat, int[] lastIndexArr) {
        for (int i = 0; i < mat.length; i++) {
            int[] arr = mat[i];
            int index = lastIndexArr[i];
            boolean contains = false;
            for (int j = index; j < arr.length; j++) {
                if(arr[j] == candidate) {
                    lastIndexArr[i] = j;
                    contains = true;
                    break;
                }
                if(arr[j] < candidate) {
                    lastIndexArr[i] = j;
                }
            }
            if(!contains){
                return false;
            }
        }
        return true;
    }
}
