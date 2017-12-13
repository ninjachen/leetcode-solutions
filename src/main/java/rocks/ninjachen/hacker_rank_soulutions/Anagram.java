package rocks.ninjachen.hacker_rank_soulutions;

import java.util.*;

/**
 * The anagram problem is from one online contest . Online contest service is provided by the HackerRank.
 */
public class Anagram {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        List<String> allInput = new ArrayList<>();
        List<Map<Character, Integer>> allInputAttr = new ArrayList<>();
        List<Set<String>> output = new ArrayList<>();

        // Read input
        Scanner sc = new Scanner(System.in);
        String inputLine;
        while(sc.hasNext()){
            inputLine = sc.next();
            allInput.add(inputLine);
        }
        // Sort
        Collections.sort(allInput);
        // Analyze input
        for(int i =0; i < allInput.size(); i++){
            inputLine = allInput.get(i);
            allInputAttr.add(analyze(inputLine));
        }

        // Group
        Set<String> dealedInputs = new HashSet();
        for(int i = 0; i < allInput.size(); i++){
            inputLine = allInput.get(i);
            if(dealedInputs.contains(inputLine))
                continue;
            String tmpLine;
            Set<String> anagramStrs = new HashSet();
            for(int j = 1; j < allInput.size(); j++){
                tmpLine = allInput.get(i);
                if(dealedInputs.contains(tmpLine))
                    continue;
                // Compareing inputLine with tmpLine
                if(equals(allInputAttr.get(i), allInputAttr.get(j))){
                    dealedInputs.add(inputLine);
                    dealedInputs.add(tmpLine);
                    anagramStrs.add(inputLine);
                    anagramStrs.add(tmpLine);
                }
            }
            output.add(anagramStrs);
        }
        // Output
        for(int i = 0; i < output.size(); i++){
            Set<String> set = output.get(i);
            StringBuffer sb = new StringBuffer();
            for(String s : set){
                sb.append(s);
                sb.append(",");
            }
            if(sb.length() > 0){
                // Remove last comma
                sb.deleteCharAt(sb.length()-1);
            }
            System.out.println(sb.toString());
        }
    }

    /**
     * Analyze the input string's attribuite
     */
    public static Map<Character, Integer> analyze(String input){
        Map<Character, Integer> attrs = new HashMap<>();
        char c;
        Integer count;
        for(int i = 0; i < input.length(); i++){
            c = input.charAt(i);
            count = attrs.get(c);
            if(count == null)
                count = 0;
            attrs.put(c, ++count);
        }
        return attrs;
    }

    /**
     * todo
     */
    public static boolean equals(Map<Character, Integer> m1, Map<Character, Integer> m2){
        if(m1.size() != m2.size()){
            return false;
        }
        for(Character key: m1.keySet()){
            Integer c1 = m1.get(key);
            Integer c2 = m2.get(key);
            if(c2 == null)
                c2 = 0;
            if(c1 != c2)
                return false;
        }
        return true;
    }
}