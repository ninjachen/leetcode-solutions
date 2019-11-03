package rocks.ninjachen.mockInterview;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestStrChain {
    public int longestStrChain(String[] words) {
        if (words.length == 0) return 0;
        Map<Integer, Set<String>> map = new HashMap<>();
        int shortLen = -1, longLen = -1;
        for (String word : words) {
            int len = word.length();
            if (shortLen == -1) {
                shortLen = len;
            } else {
                shortLen = Math.min(shortLen, len);
            }
            longLen = Math.max(longLen, len);
            if (map.get(len) == null) {
                map.put(len, new HashSet<>());
            }
            map.get(len).add(word);
        }
        int max = 1;
        for (int i = shortLen; i <= longLen; i++) {
            Set<String> cdds = map.get(i);
            if (cdds != null) {
                for (String word : cdds) {
                    int curMax = dfs(map, word, 1);
                    if (curMax == (longLen - shortLen + 1))
                        return curMax;
                    max = Math.max(max, curMax);
                }
            }
        }
        return max;
    }

    public int dfs(Map<Integer, Set<String>> map, String curWord, int arrLen) {
        int nextWordLen = curWord.length() + 1;
        Set<String> words = map.get(nextWordLen);
        if (words == null) {
            return arrLen;
        } else {
            int max = arrLen;
            for (String word : words) {
                if (isPredecessor(curWord, word)) {
                    max = Math.max(max, dfs(map, word, arrLen + 1));
                }
            }
            return max;
        }
    }

    public boolean isPredecessor(String word1, String word2) {
        if (word1 == null || word2 == null) {
            return false;
        } else {
            if (word1.length() == word2.length() - 1) {
                char[] arr1 = word1.toCharArray();
                char[] arr2 = word2.toCharArray();
                boolean diff = false;
                int i1 = 0, i2 = 0;
                for (; i1 < arr1.length && i2 < arr2.length; ) {
                    char c1 = arr1[i1];
                    char c2 = arr2[i2];
                    if (c1 == c2) {
                        i1++;
                        i2++;
                    } else {
                        if (!diff) {
                            diff = true;
                            i2++;
                        } else {
                            return false;
                        }
                    }
                }
                if(diff && i2 == arr2.length) {
                    return true;
                } else if(!diff) {
                        return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
    }
}
