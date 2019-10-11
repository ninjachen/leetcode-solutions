package rocks.ninjachen.leet_code_solutions;

import java.util.ArrayList;
import java.util.List;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        List<String> lastTransformedWords = new ArrayList<>();
        lastTransformedWords.add(beginWord);
        wordList.remove(beginWord);
        for (int count = 2; ; count++) {
            List<String> nextTransformedWords = new ArrayList<>();
            boolean allTransFormedFail = true;
            for (String transFormedWord : lastTransformedWords) {
                boolean noContent = true;
                List<String> wordsNextLoop = new ArrayList<>();
                for (String word : wordList) {
                    noContent = false;
                    if (isOneCharDiff(transFormedWord, word)) {
                        if (endWord.equals(word)) {
                            return count;
                        }
                        allTransFormedFail = false;
                        nextTransformedWords.add(word);
                    } else {
                        wordsNextLoop.add(word);
                    }
                }
                wordList = wordsNextLoop;
                if (noContent) {
                    return 0;
                }
            }
            if (allTransFormedFail) {
                return 0;
            }
            lastTransformedWords = nextTransformedWords;
        }
    }

    public boolean isOneCharDiff(String word1, String word2) {
        char[] word1Arr = word1.toCharArray();
        char[] word2Arr = word2.toCharArray();
        boolean oneDiff = false;
        for (int i = 0; i < word1Arr.length; i++) {
            if (word1Arr[i] != word2Arr[i]) {
                if (oneDiff) {
                    // Have more than 2 difference
                    return false;
                }
                oneDiff = true;
            }
        }
        return oneDiff;
    }
}
