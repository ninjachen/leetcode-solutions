package rocks.ninjachen.LeetCodeSolutions;

/**
 * CyclicRotation
 * https://codility.com/demo/results/trainingJY2GMK-8B7/
 * Created by ninja on 6/7/16.
 */
public class CyclicRotation {
    public int[] solution(int[] A, int K) {
        // write your code in Java SE 8
        if(A == null) return null;
        int length = A.length;
        int[] B = new int[length];
        //traversal the array A
        int indexB;
        for(int i=0;i<length;i++){
            indexB=i+K;
            if(indexB > length - 1){
                indexB = indexB % length;
            }
            B[indexB] = A[i];
        }
        return B;
    }
}
