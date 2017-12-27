package rocks.ninjachen.hacker_rank_soulutions;

import java.util.*;

/**
 * todo the algorithm is not finshed
 * The anagram problem is from one online contest . Online contest service is provided by the HackerRank.
 */
public class Anagram {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        List<String> allInput = new ArrayList<>();
        HashMap<String, Map<Character, Integer>> allInputAttr = new HashMap<>();
        List<List<String>> output = new ArrayList<>();

        // Read input
        Scanner sc = new Scanner(System.in);
        String inputWord;
        while(sc.hasNext()){
            inputWord = sc.nextLine();
            allInput.add(inputWord);
        }
        sc.close();
        // Sort
        Collections.sort(allInput);
        // Analyze input
        for(int i = 0; i < allInput.size(); i++){
            inputWord = allInput.get(i);
            allInputAttr.put(inputWord, analyze(inputWord));
        }

        // Group
        Iterator<String> itr = allInput.listIterator();
        // A set to flag the dealed inputs
        Set<String> dealedInputs = new HashSet();
        while (itr.hasNext()){
            inputWord = itr.next();
            if(dealedInputs.contains(inputWord))
                continue;
            Iterator<String> itr2 = allInput.iterator();
            List<String> sameGroup = new ArrayList<>();
            sameGroup.add(inputWord);
            dealedInputs.add(inputWord);
            while (itr2.hasNext()){
                String tmpWord = itr2.next();
                if(dealedInputs.contains(tmpWord))
                    continue;
                // Hit the anagram, group
                if(equals(allInputAttr.get(inputWord), allInputAttr.get(tmpWord))){
                    sameGroup.add(tmpWord);
                    dealedInputs.add(tmpWord);
                }
            }
            output.add(sameGroup);
        }

//        Set<String> dealedInputs = new HashSet();
//        for(int i = 0; i < allInput.size(); i++){
//            inputWord = allInput.get(i);
//            if(dealedInputs.contains(inputWord))
//                continue;
//            String tmpLine;
//            Set<String> anagramStrs = new HashSet();
//            for(int j = 1; j < allInput.size(); j++){
//                tmpLine = allInput.get(j);
//                if(dealedInputs.contains(tmpLine))
//                    continue;
//                // Comparing inputLine with tmpLine
//                if(equals(allInputAttr.get(i), allInputAttr.get(j))){
//                    dealedInputs.add(inputWord);
//                    dealedInputs.add(tmpLine);
//                    anagramStrs.add(inputWord);
//                    anagramStrs.add(tmpLine);
//                }
//            }
//            output.add(anagramStrs);
//        }
        // Output
        for(int i = 0; i < output.size(); i++){
            List<String> set = output.get(i);
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
            if(c == ' ')
                continue;
            count = attrs.get(c);
            if(count == null)
                count = 0;
            attrs.put(c, ++count);
        }
        return attrs;
    }

    /**
     * Is two word are anagram
     * @param m1
     * @param m2
     * @return
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