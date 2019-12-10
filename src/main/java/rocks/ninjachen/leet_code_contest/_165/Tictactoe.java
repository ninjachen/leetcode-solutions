package rocks.ninjachen.leet_code_contest._165;


/**
 * https://leetcode.com/accounts/login/?next=/contest/weekly-contest-165/problems/find-winner-on-a-tic-tac-toe-game/
 */
public class Tictactoe {
        public String tictactoe(int[][] moves) {
            //0 is empty, 1 is a, b is 2
            int[][] panel = new int[3][3];
            for (int i = 0; i < moves.length; i++) {
                int[] mv = moves[i];
                panel[mv[0]][mv[1]] = (i % 2 == 0 ? 1 : 2);
            }
            //0 is draw, 1 is a, b is 2
            int winner = 0;
            int i = 0;
            while (winner == 0 && i <= 2) {
                winner = check(panel[i][0], panel[i][1], panel[i][2]);
                i++;
            }
            if (winner > 0) {
                return (winner == 1 ? "A" : "B");
            }
            i = 0;
            while (winner == 0 && i <= 2) {
                winner = check(panel[0][i], panel[1][i], panel[2][i]);
                i++;
            }
            if (winner > 0) {
                return (winner == 1 ? "A" : "B");
            }
            if ((winner = check(panel[0][0], panel[1][1], panel[2][2])) > 0
                    || (winner = check(panel[0][2], panel[1][1], panel[2][0])) > 0) {

            }
            if (winner > 0) {
                return (winner == 1 ? "A" : "B");
            } else {
                // check empty value on panel
                for (int j = 0; j < panel.length; j++) {
                    for (int k = 0; k < panel[0].length; k++) {
                        if (panel[j][k] == 0)
                            return "Pending";
                    }
                }
                return "Draw";
            }
        }

        // all input is 1 or 2
        // return 0 if the input is not same, or return 1, or return 2
        public int check (int a, int b, int c) {
            if (a == b && b == c) {
                return a;
            } else {
                return 0;
            }
        }
}
