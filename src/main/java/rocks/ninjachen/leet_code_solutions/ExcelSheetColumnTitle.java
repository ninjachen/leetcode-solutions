package rocks.ninjachen.leet_code_solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/excel-sheet-column-title/submissions/
 */
public class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        char[] dict = "#ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        List<Character> chars = new ArrayList<>();
        while (n > 0) {
            int i = n % 26;
            if (i == 0) {
                chars.add('Z');
                n = n / 26 - 1;
            } else {
                chars.add(dict[i]);
                n = n / 26;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = chars.size() - 1; i >= 0; i--) {
            sb.append(chars.get(i));
        }
        return sb.toString();
    }
}
