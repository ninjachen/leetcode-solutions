package rocks.ninjachen.mockInterview;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CharacterReplacement {
    public int characterReplacement(String s, int k) {
        if (s.length() <= k) {
            return s.length();
        }
        char[] arr = s.toCharArray();
        int i = 0;
        int j = k - 1;
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Integer, Set<Character>> map2 = new HashMap<>();
        int max = 0;
        for (int idx = 0; idx <= j; idx++) {
            char c = arr[idx];
            int num = map1.getOrDefault(c, 0) + 1;
            map1.put(c, num);
            if (num > max) {
                max = num;
            }
            map2.putIfAbsent(num, new HashSet<>());
            map2.get(num).add(c);
        }
        while (j < arr.length) {
            int len = j - i + 1;
            if (len - max <= k) {
                j++;
                if(j == arr.length) break;
                char c = arr[j];
                int num = map1.getOrDefault(c, 0) + 1;
                map1.put(c, num);
                if (num > max) {
                    max = num;
                }
                map2.putIfAbsent(num, new HashSet<>());
                map2.get(num).add(c);
            } else {
                i++;
                j++;
                if(j == arr.length) break;
                // into j
                char c = arr[j];
                int num = map1.getOrDefault(c, 0) + 1;
                map1.put(c, num);
                if (num > max) {
                    max = num;
                }
                map2.putIfAbsent(num, new HashSet<>());
                map2.get(num).add(c);
                // evic i
                c = arr[i - 1];
                num = map1.getOrDefault(c, 0);
                map1.put(c, num - 1);
                Set<Character> set = map2.get(num);
                set.remove(c);
                if(set.isEmpty()) {
                     map2.remove(num);
                }
                max = 0;
                for (int count : map2.keySet()){
                    max = Math.max(max, count);
                }
            }
        }
        return j - i;
    }
}
