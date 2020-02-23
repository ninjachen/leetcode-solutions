package rocks.ninjachen.other.booking;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;

/**
 * An anagram is a word that can be written as a permutation of the characters of another word, like "dirty room" and "dormitory" (ignore spaces). However, "the" and "thee" are not anagrams, since "the" only has a single "e" whereas "thee" has two "e" characters (spaces can occur zero, or multiple times, however.)
 *
 * Given a list of words as strings, you should return another list of strings, each containing words that are mutual anagrams.
 *
 * Each string of the output should be a single group of anagarms joined with commas.
 *
 * Within an output string, the expression should be sorted lexicographically. If a group contains only a single element, output that one-element group as a single string. And the string should be also output in lexicographical order. Given e.g.:
 *
 * pear
 * amleth
 * dormitory
 * tinsel
 * dirty room
 * hamlet
 * listen
 * silnet
 * ... the output would be:
 *
 * amleth,hamlet
 * dirty room,dormitory
 * listen,silnet,tinsel
 * pear
 */
public class Anagram {

    @Test
    public void testcase() {
        List<String> input = Arrays.asList("pear" , "amleth" , "dormitory" , "tinsel" , "dirty room" , "hamlet" , "listen" , "silnet");
        List<List<String>> output = anagram(input);
        // output should be
        //amleth,hamlet
        //dirty room,dormitory
        //listen,silnet,tinsel
        //pear
        for (List<String> list : output) {
            System.out.println(list);
        }
    }

    public List<List<String>> anagram(List<String> input){
        HashMap<String, List<String>> map = new HashMap<>();
        for (String word : input) {
            String sorted = sort(word);
            map.putIfAbsent(sorted, new ArrayList<>());
            map.get(sorted).add(word);
        }
        List<List<String>> output = new ArrayList<>();
        for (Map.Entry<String, List<String>> m : map.entrySet()) {
            output.add(m.getValue());
        }
        return output;
    }

    private String sort(String word) {
        char[] arr = word.toCharArray();
        List<Character> list = new ArrayList<>();
        for (char c : arr) {
            if(c != ' '){
                list.add(c);
            }
        }
        Collections.sort(list);
        StringBuffer sb = new StringBuffer();
        for (char c : list){
            sb.append(c);
        }
        return sb.toString();
    }

}
