package rocks.ninjachen.leet_code_contest._164;

import java.util.*;

public class SuggestedProducts {
        public List<List<String>> suggestedProducts(String[] products, String searchWord) {
            Arrays.sort(products);
            Map<Character, List<String>> productMap = new HashMap<>();
            for(String product : products) {
                Character c = product.charAt(0);
                productMap.putIfAbsent(c, new ArrayList());
                productMap.get(c).add(product);
            }
            List<String> originSet = productMap.get(searchWord.charAt(0));
            if (originSet == null) {
                originSet = new ArrayList<>();
            }
            List<List<String>> result = new ArrayList<>();
            result.add(setToList(originSet));
            for(int i = 1; i < searchWord.length(); i++) {
                List<String> thisSet = new ArrayList<>();
                for(String str : originSet) {
                    if(i < str.length() && searchWord.charAt(i) == str.charAt(i)) {
                        thisSet.add(str);
                    }
                }
                originSet = thisSet;
                result.add(setToList(originSet));
            }
            return result;
        }

        public List<String> setToList(List<String> set) {
            List<String> list = new ArrayList<>();
            if(set != null && !set.isEmpty()) {
                int count = 3;
                for (String str : set) {
                    list.add(str);
                    count--;
                    if (count == 0)
                        break;
                }
            }
            return list;
        }
}
