package rocks.ninjachen.LeetCodeSolutions;

/**
 * 233 NumberOfDigitOne
 * https://leetcode.com/problems/number-of-digit-one/
 * Created by ninja on 6/4/16.
 */
public class NumberOfDigitOne {
    public static void main(String[] args) {
        NumberOfDigitOne solution = new NumberOfDigitOne();
        System.out.println(solution.countDigitOne(1));
    }

    //
//    public int countDigitOne(int n) {
//        int count = 0;
//        int tmp;
//        Integer tmpCount;
//        if (n <= 0) return count;
//        for (int i = 0; i <= n; i++) {
//            //count 1 in one number
//            tmp = i;
//            tmpCount = 0;
//            while (tmp > 0) {
//                if ((tmp % 10) == 1) tmpCount++;
//                tmp /= 10;
//            }
//            count += tmpCount;
//        }
//        return count;
//    }
    public int countDigitOne(int n) {
        if(n<1) return 0;
        int count = 0;
        for (long k = 1; k <= n; k *= 10) {
            long a = n / k, b = n % k;
            count += (a + 8) / 10 * k + (a % 10 == 1 ? (b + 1) : 0);
        }
        return count;
    }
}
