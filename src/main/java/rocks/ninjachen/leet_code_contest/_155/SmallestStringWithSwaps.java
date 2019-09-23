package rocks.ninjachen.leet_code_contest._155;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SmallestStringWithSwaps {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);
        String perfectWord = new String(charArray);
        List<String> allStrings = new ArrayList<>();
        allStrings.add(s);
        while (true) {
            boolean hasNewValue = false;
            String[] loop = new String[allStrings.size()];
            loop = allStrings.toArray(loop);
            for (String str : loop) {
                for (List<Integer> pair : pairs) {
                    String newString = swap(str, pair.get(0), pair.get(1));
                    if (newString.equals(perfectWord)) {
                        return perfectWord;
                    }
                    if (!allStrings.contains(newString)) {
                        hasNewValue = true;
                        allStrings.add(newString);
                    }
                }

            }
            if (!hasNewValue) {
                break;
            }
        }
        Collections.sort(allStrings);
        return allStrings.get(0);
    }

    private String swap(String s, int i, int j) {
        char[] chars = s.toCharArray();
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
        return new String(chars);
    }
}
