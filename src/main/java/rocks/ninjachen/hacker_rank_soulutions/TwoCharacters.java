package rocks.ninjachen.hacker_rank_soulutions;

import java.util.*;

/**
 * Created by ninja on 12/27/17.
 */
public class TwoCharacters {

        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int len = in.nextInt();
            String s = in.next();

            int i = twoChar(s);
            System.out.println(i);
        }

        private static int twoChar(String input) {
            // choose 2 in the attr.size(), from top to low
            List<KV<Character>> attr = analyze(input);
            //Maybe sort the map
            Collections.sort(attr, Collections.reverseOrder());
            // Calculate all the candidates
            Map<String, Integer> cands = new HashMap<>();
            if (attr.size() >= 2) {
                for (int i = 0; i < attr.size(); i++) {
                    for (int j = 0; j < attr.size(); j++) {
                        if (i == j) continue;
                        Character c1 = attr.get(i).key;
                        Character c2 = attr.get(j).key;
                        String str;
                        if(c1 < c2){
                            char[] cs = {c1, c2};
                            str = new String(cs);
                        }else {
                            char[] cs = {c2, c1};
                            str = new String(cs);
                        }
                        // Already calculated
                        if(cands.get(str) != null) continue;

                        String filtered = filter(input, c1, c2);
                        if (isValid(filtered)) {
                            cands.put(str, filtered.length());
                        }else {
                            cands.put(str, 0);
                        }
                    }
                }
            }
            List<KV<String>> candList = new ArrayList<>();
            for(String key : cands.keySet()){
                KV<String> kv = new KV<>(key, cands.get(key));
                candList.add(kv);
            }
            Collections.sort(candList, Collections.reverseOrder());
            if(!candList.isEmpty()){
                return candList.get(0).value;
            }
            // By default, 0 is empty
            return 0;
        }

        /**
         * CHeck is the string  twoCharacter
         *
         * @param string
         * @return
         */
        private static boolean isValid(String string) {
            Set<Character> elements = new HashSet<>();
            char c = string.charAt(0);
            elements.add(c);
            for (int i = 1; i < string.length(); i++) {
                char tmp = string.charAt(i);
                if (c == tmp)
                    return false;
                c = tmp;
                elements.add(c);
                if (elements.size() > 2)
                    return false;
            }
            return true;
        }

        /**
         * Remove all the char in input string, exclude c1 and c2
         *
         * @param input
         * @param c1
         * @param c2
         * @return
         */
        private static String filter(String input, Character c1, Character c2) {
            StringBuffer sb = new StringBuffer();
            for (char c : input.toCharArray()) {
                if (c == c1 || c == c2) {
                    sb.append(c);
                }
            }
            return sb.toString();
        }

        /**
         * Analyze the string's char appearance rate
         *
         * @param s
         * @return
         */
        private static List<KV<Character>> analyze(String s) {
            HashMap<Character, Integer> map = new HashMap<>();
            for (char c : s.toCharArray()){
                Integer count = map.get(c);
                if(count == null) count = 0;
                map.put(c, ++count);
            }
            List<KV<Character>> kvs = new ArrayList<>();
            for (char key : map.keySet()){
                KV<Character> kv = new KV<>(key, map.get(key));
                kvs.add(kv);
            }
            return kvs;
        }

        public static class KV<K> implements Comparable<KV>{
            K key;
            Integer value;

        public KV(K key, Integer value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public int compareTo(KV o) {
            if(o.value != null && value != null){
                return value - o.value;
            }
            return 0;
        }
    }
}
