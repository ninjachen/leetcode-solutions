package rocks.ninjachen.mockInterview;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class NumberOfAtoms {
    public String countOfAtoms(String formula) {
        Map<String, Integer> eleMap = new HashMap<>();
        if (formula.length() == 0) {
            return print(eleMap);
        }
        char[] arr = formula.toCharArray();
        // Two runner
        int lastIndex = 0;
        int curIndex = 0;
        while (curIndex < arr.length) {
            if (upcase(arr[curIndex])) {
                // First upcase letter, find next upcase letter
                int i;
                for (i = curIndex + 1; i < arr.length; i++) {
                    // stop when meet another Upcase letter or (
                    if (arr[i] == '(' || upcase(arr[i]))
                        break;
                }
                parseSingleElement(arr, curIndex, i, eleMap);
                curIndex = i;
            } else if (arr[curIndex] == '(') {
                // First upcase letter, find next upcase letter
                int i;
                int leftCount = 1;
                for (i = curIndex + 1; i < arr.length; i++) {
                    // Find the pair symbol )
                    if (arr[i] == '(')
                        leftCount++;
                    else if (arr[i] == ')')
                        leftCount--;
                    if (leftCount == 0)
                        break;
                }
                int rightI = i;
                for (i = i + 1; i < arr.length; i++) {
                    // stop when meet another Upcase letter or (
                    if (arr[i] == '(' || upcase(arr[i]))
                        break;
                }
                parseGroupElement(arr, curIndex, rightI, i, eleMap);
                curIndex = i;
            }
        }
        return print(eleMap);
    }

    public boolean upcase(char c) {
        return c >= 'A' && c <= 'Z';
    }

    public boolean lowcase(char c) {
        return c >= 'a' && c <= 'z';
    }

    // endIndex exclude, input such as Mg, Mg2, H
    public void parseSingleElement(char[] arr, int startIndex, int endIndex, Map<String, Integer> map) {
        int i;
        for (i = startIndex + 1; i < endIndex && lowcase(arr[i]); i++) {

        }
        StringBuffer sb = new StringBuffer();
        for (int index = startIndex; index < i; index++) {
            sb.append(arr[index]);
        }
        String name = sb.toString();
        int count;
        if (i == endIndex) {
            count = 1;
        } else {
            sb = new StringBuffer();
            for (int index = i; index < endIndex; index++) {
                sb.append(arr[index]);
            }
            count = Integer.valueOf(sb.toString());
        }
        map.put(name, map.getOrDefault(name, 0) + count);
    }

    // endIndex exclude, input such as (OH)2 (OH) K4(ON(SO3)2)2
    public void parseGroupElement(char[] arr, int leftIndex, int rightIndex, int endIndex, Map<String, Integer> map) {
        int time;
        if (rightIndex == endIndex - 1) {
            time = 1;
        } else {
            StringBuffer sb = new StringBuffer();
            for (int i = rightIndex + 1; i < endIndex; i++) {
                sb.append(arr[i]);
            }
            time = Integer.valueOf(sb.toString());
        }
        // (inside) proxy to parseSingleElement or parseGroupElement
        Map<String, Integer> insideMap = new HashMap<>();
        for (int i = leftIndex + 1; i < rightIndex; ) {
            if (upcase(arr[i])) {
                int j;
                for (j = i + 1; j < rightIndex; j++) {
                    if (arr[j] == '(' || upcase(arr[j])) {
                        break;
                    }
                }
                parseSingleElement(arr, i, j, insideMap);
                i = j;
            } else if (arr[i] == '(') {
                int leftIndexInside = i;
                int leftCountInside = 1;
                for (i = i + 1; i < rightIndex; i++) {
                    // Find the pair symbol )
                    if (arr[i] == '(')
                        leftCountInside++;
                    else if (arr[i] == ')')
                        leftCountInside--;
                    if (leftCountInside == 0)
                        break;
                }
                int rightIndexInside = i;
                for (i = i + 1; i < rightIndex; i++) {
                    // stop when meet another Upcase letter or (
                    if (arr[i] == '(' || upcase(arr[i]))
                        break;
                }
                parseGroupElement(arr, leftIndexInside, rightIndexInside, i, insideMap);
            }
        }
        for (String key : insideMap.keySet()) {
            int count = insideMap.get(key) * time;
            map.put(key, map.getOrDefault(key, 0) + count);
        }
    }

    public String print(Map<String, Integer> map) {
        StringBuffer sb = new StringBuffer();
        for (String key : new TreeSet<>(map.keySet())) {
            sb.append(key);
            int count = map.get(key);
            if (count > 1) {
                sb.append(count);
            }
        }
        return sb.toString();
    }
}
