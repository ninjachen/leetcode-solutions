package rocks.ninjachen.leet_code_contest._168;

import java.util.HashMap;
import java.util.Map;

public class MaxFreq {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        return getAllSubString(s, maxLetters, minSize, maxSize);
    }

    private int getAllSubString(String s, int maxLetters, int minSize, int maxSize) {
        int maxOccur = 0;
        // substring, occurNum
        // Set<String> result = new HashSet<>();
        for (int len = minSize; len <= maxSize; len++) {
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < s.length() - len + 1; i++) {
                String subString = s.substring(i, i + len);
                if (fitLetterNum(subString, maxLetters)) {
                    int occurNum = map.getOrDefault(subString, 0) + 1;
                    map.put(subString, occurNum);
                    maxOccur = Math.max(maxOccur, occurNum);
                }
            }
        }
        return maxOccur;
    }

    private boolean fitLetterNum(String s, int maxLetterNum) {
        int letterNum = 0;
        boolean[] used = new boolean[26];
        for (char c : s.toCharArray()) {
            if (used[c - 'a']) {
                continue;
            } else {
                letterNum++;
                if (letterNum > maxLetterNum)
                    return false;
                used[c - 'a'] = true;
            }
        }
        return true;
    }
}
