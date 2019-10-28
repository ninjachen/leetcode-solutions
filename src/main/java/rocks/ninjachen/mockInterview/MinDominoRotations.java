package rocks.ninjachen.mockInterview;

public class MinDominoRotations {
    public int minDominoRotations(int[] A, int[] B) {
        if (A.length == 1) {
            return 0;
        } else if (A.length == 2) {
            if (A[0] == A[1] || B[0] == B[1]) {
                return 0;
            } else if (A[0] == B[1] || B[0] == A[1]) {
                return 1;
            } else {
                return -1;
            }
        } else {
            // a length large than 3, A[0] or B[0] are candidates;
            // suppose a[0]
            int minA0 = -1;
            int minB0 = -1;
            if (A[0] == A[1] || A[0] == B[1]) {
                minA0 = minDominoRotations(A, B, A[0]);
            }
            if (B[0] == B[1] || B[0] == A[1]) {
                minB0 = minDominoRotations(A, B, B[0]);
            }
            if (minA0 == -1 && minB0 == -1) {
                return -1;
            } else if (minA0 == -1) {
                return minB0;
            } else if (minB0 == -1) {
                return minA0;
            } else {
                return minA0 <= minB0 ? minA0 : minB0;
            }
        }
    }

    // Suppose target is the same values after swap
    public int minDominoRotations(int[] A, int[] B, int target) {
        int minSwapA = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == target) {
                continue;
            } else if (B[i] == target) {
                minSwapA++;
            } else {
                minSwapA = -1;
                break;
            }
        }
        int minSwapB = 0;
        for (int i = 0; i < B.length; i++) {
            if (B[i] == target) {
                continue;
            } else if (A[i] == target) {
                minSwapB++;
            } else {
                minSwapB = -1;
                break;
            }
        }
        if (minSwapA == -1 && minSwapB == -1) {
            return -1;
        } else if (minSwapA == -1) {
            return minSwapB;
        } else if (minSwapB == -1) {
            return minSwapA;
        } else {
            return minSwapA < minSwapB ? minSwapA : minSwapB;
        }
    }

}
