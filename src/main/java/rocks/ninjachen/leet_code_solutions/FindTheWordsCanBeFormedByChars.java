package rocks.ninjachen.leet_code_solutions;


import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/contest/weekly-contest-150/problems/find-words-that-can-be-formed-by-characters/
 * Input: words = ["cat","bt","hat","tree"], chars = "atach"
 * Output: 6
 * Explanation:
 * The strings that can be formed are "cat" and "hat" so the answer is 3 + 3 = 6.
 */
public class FindTheWordsCanBeFormedByChars {
    public static void main(String[] arg){
        String[] words = {"cat","bt","hat","tree"};
        String chars = "atach";
        FindTheWordsCanBeFormedByChars solution = new FindTheWordsCanBeFormedByChars();
        System.out.println(solution.countCharacters(words, chars));
    }

    public int countCharacters(String[] words, String chars) {
        Map<Character, Integer> charMap = formatMap(chars);
        int count = 0;
        for (String word : words) {
            Map<Character, Integer> wordMap = formatMap(word);
            if (couldForm(charMap, wordMap)) {
                count += word.length();
            }
        }
        return count;
    }

    private boolean couldForm(Map<Character, Integer> charMap, Map<Character, Integer> wordMap) {
        for (Character key : wordMap.keySet()){
            Integer charCount = charMap.getOrDefault(key, 0);
            Integer wordCount = wordMap.getOrDefault(key, 0);
            if(wordCount > charCount){
                return false;
            }
        }
        return true;
    }

    private Map<Character, Integer> formatMap(String word) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : word.toCharArray()) {
            Integer count = map.getOrDefault(c, 0);
            map.put(c, count + 1);
        }
        return map;
    }
}
