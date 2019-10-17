package rocks.ninjachen.leet_code_solutions;

import java.util.*;

public class CoinChange2 {
    public int change(int amount, int[] coins) {
        Set<List<Integer>> answer = change(amount, coins, new HashMap<>());
        return answer.size();
    }

    public Set<List<Integer>> change(int amount, int[] coins, HashMap<Integer, Set<List<Integer>>> cache) {
        if (amount < 0) {
            return null;
        } else if (amount == 0) {
            Set<List<Integer>> answer = new HashSet<>();
            answer.add(new ArrayList<>());
            return answer;
        } else {
            if (cache.containsKey(amount)) {
                return cache.get(amount);
            }
            Set<List<Integer>> answer = new HashSet<>();
            Set<List<Integer>> cached = new HashSet<>();
            for (int coin : coins) {
                Set<List<Integer>> subAnswer = change(amount - coin, coins, cache);
                if (subAnswer == null) {
                    continue;
                } else {
                    for (List<Integer> combination : subAnswer) {
                        combination.add(coin);
                        Collections.sort(combination);
                        answer.add(combination);
                        cached.add(new ArrayList<>(combination));
                    }
                }
            }
            cache.put(amount, cached);
            return answer;
        }
    }
}
