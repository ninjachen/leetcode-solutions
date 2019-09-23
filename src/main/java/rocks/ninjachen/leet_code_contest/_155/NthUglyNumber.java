package rocks.ninjachen.leet_code_contest._155;

public class NthUglyNumber {

    public int nthUglyNumber(int n, int a, int b, int c) {
        int a1 = a, b1 = b, c1 = c;
        int output = -1;
        for (int i = 0; i < n; i++) {
            output = Math.min(a1, Math.min(b1, c1));
            if (a1 == output) {
                a1 = a1 + a;
            }
            if (b1 == output) {
                b1 = b1 + b;
            }
            if (c1 == output) {
                c1 = c1 + c;
            }
        }
        return output;
    }
}
