package rocks.ninjachen.leet_code_solutions;

/**
 * Created by ninja on 6/7/16.
 */
public class BalancePointOfTradeHero {
    public static void main(String[] args) {
        BalancePointOfTradeHero s = new BalancePointOfTradeHero();
        int N = 102;
        System.out.print(s.solution(N));
    }

    public int solution(int N) {
        // write your code in Java SE 8
        // get length of N
        int length = 0;
        int temp = N;
        while (temp > 0) {
            temp = temp >> 1;
            length++;
        }
        for (int P = 1; P < (length / 2); P++) {
            if(isAllEqual(N, P, length)) return P;
        }
        return -1;
    }

    public boolean isAllEqual(int N, int P, int length) {
        for (int i = 0; i < length / 2; i++) {
            if ((i + P) > (length - 1)) return true;
            // all the N[i] == N[i+P]
            if (getBit(N, i) != getBit(N, i + P)) {
                return false;
            }
        }
        return true;
    }

    /**
     * i is the index of the bit
     *
     * @return true then the bit is 1;
     */
    public boolean getBit(int num, int i) {
        return ((num & (i << i)) != 0);
    }
}
