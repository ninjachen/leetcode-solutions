package rocks.ninjachen.leet_code_contest._154;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/contest/weekly-contest-154/problems/reverse-substrings-between-each-pair-of-parentheses/
 */
public class ReverseParentheses {
    public static void main(String[] args){
        ReverseParentheses reverseParentheses = new ReverseParentheses();
//        System.out.println(reverseParentheses.reverseParentheses("(abcd)"));
//        System.out.println(reverseParentheses.reverseParentheses("(u(love)i)"));
        System.out.println(reverseParentheses.reverseParentheses("f(ul)ao(t(y)qbn)()sj"));
    }

    public String reverseParentheses(String s) {
        List<Integer> leftBracketIndexs = new ArrayList<>();
        for (int i = 0; ; i++) {
            // End
            if (i >= s.length()) {
                break;
            }
            char c = s.toCharArray()[i];
            if (c == '(') {
                leftBracketIndexs.add(i);
            } else if (c == ')') {
                Integer lastLeftBracketIndex = popLast(leftBracketIndexs);
                Integer rightBracketIndex = i;
                s = reversePartion(s, lastLeftBracketIndex, rightBracketIndex);
                // Curse Move on
                i = i - 2;
            }
        }
        // Deal the rest left brackets
        while (!leftBracketIndexs.isEmpty()) {
            Integer leftBracketIndex = popLast(leftBracketIndexs);
            int rightBracketIndex;
            for (int i = leftBracketIndex; ; i++) {
                if (s.toCharArray()[i] == ')') {
                    rightBracketIndex = i;
                    break;
                }
            }
            s = reversePartion(s, leftBracketIndex, rightBracketIndex);
        }
        return s;
    }

    private <T> T popLast(List<T> list) {
        int lastIndex = list.size() - 1;
        T latItem = list.get(lastIndex);
        list.remove(lastIndex);
        return latItem;
    }


    private String reversePartion(String text, Integer leftBracketIndex, int rightBracketIndex) {
        char[] chars = text.toCharArray();
        if (chars[leftBracketIndex] == '(' && chars[rightBracketIndex] == ')') {
            char[] charsPartion = new char[rightBracketIndex - leftBracketIndex - 1];
            for (int i1 = rightBracketIndex-1, i2 = 0; i1 > leftBracketIndex; i1--, i2++) {
                charsPartion[i2] = chars[i1];
            }
            String leftPart = text.substring(0, leftBracketIndex);
            String reservePart = new String(charsPartion);
            String rightPart = rightBracketIndex>= text.length()-1 ? "" : text.substring(rightBracketIndex+1);
            text = leftPart + reservePart + rightPart;
        } else {
            System.out.println(text);
        }
        return text;
    }
}
