package rocks.ninjachen.leet_code_contest._160;

import java.util.List;

public class MaxLength {
    public int maxLength(List<String> arr) {
        return dfs(arr, "", 0);
    }

    public int dfs(List<String> arr, String contactStr, int index) {
        int maxLen = 0;
        if (!isUnique(contactStr)) {
            return 0;
        } else {
            maxLen = Math.max(maxLen, contactStr.length());
        }
        for (int i = index; i < arr.size(); i++) {
            maxLen = Math.max(maxLen, dfs(arr, contactStr + arr.get(i), i));
        }
        return maxLen;
    }

    public boolean isUnique(String str) {
        char[] arrays = str.toCharArray();
        boolean[] used = new boolean[26];
        for (char c : arrays) {
            if (used[c - 'a']) {
                return false;
            }
            used[c - 'a'] = true;
        }
        return true;
    }

}
