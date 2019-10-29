package rocks.ninjachen.mockInterview;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstringKDistinct {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s.length() < k) {
            return s.length();
        }
        Map<Character, Integer> map = new HashMap<>();
        // init a window from i to j, init length is k.
        int i = 0;
        int j;
        for (j = 0; j < k; j++) {
            char c = s.charAt(j);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (; j < s.length(); j++) {
            char c = s.charAt(j);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (map.keySet().size() <= k) {
                // Duplicate char
                continue;
            } else {
                // pop item at i
                c = s.charAt(i);
                int count = map.getOrDefault(c, 0) - 1;
                if (count == 0) {
                    map.remove(c);
                } else {
                    map.put(c, count);
                }
                i++;
            }
        }
        // j is overflow
        j--;
        return j - i + 1;
    }
}
