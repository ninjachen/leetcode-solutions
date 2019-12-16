package rocks.ninjachen.leet_code_contest.bi_15;

import java.util.ArrayList;
import java.util.List;

public class CombinationIterator {
    List<String> data;
    int i = 0;

    public CombinationIterator(String characters, int combinationLength) {
        data = parse(characters.toCharArray(), combinationLength);
    }

    public String next() {
        if (i < data.size()) {
            return data.get(i++);
        } else {
            return null;
        }
    }

    public boolean hasNext() {
        return i < data.size();
    }

    public List<String> parse(char[] array, int combinationLength) {
        List<String> output = new ArrayList<>();
        char[] curCombination = new char[combinationLength];
        parseInternal(array, 0, array.length, 0, combinationLength, curCombination, output);
        return output;
    }

    public void parseInternal(char[] array, int start, int end, int curNum, int tarNum, char[] curCombination, List<String> output) {
        if (curNum == tarNum) {
            output.add(new String(curCombination));
        } else {
            for (int i = start; i < end; i++) {
                curCombination[curNum] = array[i];
                parseInternal(array, i + 1, end, curNum + 1, tarNum, curCombination, output);
            }
        }
    }

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
}
