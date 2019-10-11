package rocks.ninjachen.leet_code_solutions;


import java.util.*;

/**
 * https://leetcode.com/problems/word-ladder-ii/
 */
public class WordLadder2 {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        HashSet<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) {
            return result;
        }
        HashMap<String, Integer> distanceMap = new HashMap<>();
        HashMap<String, List<String>> neighborMap = new HashMap<>();
        neighborMap.put(beginWord, new ArrayList<>());
        for (String word : wordList) {
            neighborMap.put(word, new ArrayList<>());
        }
//        System.out.println(String.format("before bfs cost %d ms", System.currentTimeMillis() - startT));
        bfs(beginWord, endWord, dict, distanceMap, neighborMap);
//        System.out.println(String.format("bfs cost %d ms", System.currentTimeMillis() - startT));
        List<String> curPath = new ArrayList<>();
        dfs(beginWord, endWord, dict, distanceMap, neighborMap, curPath, result);
//        System.out.println(String.format("bfs cost %d ms", System.currentTimeMillis() - startT));
        return result;

    }

    /**
     * DFS to output the transform path
     * @param beginWord
     * @param endWord
     * @param dict
     * @param distanceMap
     * @param neighborMap
     * @param result
     */
    private void dfs(String beginWord, String endWord, HashSet<String> dict, HashMap<String, Integer> distanceMap, HashMap<String, List<String>> neighborMap, List<String> curPath, List<List<String>> result) {
        curPath.add(beginWord);
        if (beginWord.equals(endWord)) {
            result.add(new ArrayList<>(curPath));
        } else {
            List<String> neighbors = neighborMap.get(beginWord);
            if (neighbors != null) {
                for (String neighbor : neighbors) {
                    Integer distance = distanceMap.get(beginWord);
                    Integer neighborDistance = distanceMap.get(neighbor);
                    if (neighborDistance == distance + 1) {
                        dfs(neighbor, endWord, dict, distanceMap, neighborMap, curPath, result);
                    }
                }
            }
        }
        curPath.remove(curPath.size() - 1);
    }

    /**
     * BFS to calculate the distance.
     * @param beginWord
     * @param endWord
     * @param dict
     * @param distanceMap
     * @param neighborMap
     */
    private void bfs(String beginWord, String endWord, HashSet<String> dict, HashMap<String, Integer> distanceMap, HashMap<String, List<String>> neighborMap) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        distanceMap.put(beginWord, 0);
        boolean gotcha = false;
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                String curWord = queue.poll();
                int curDistance = distanceMap.get(curWord);
                List<String> neighbors = getNeighbors(curWord, dict);
                for (String neighbor : neighbors) {
                    neighborMap.get(curWord).add(neighbor);
                    if (distanceMap.containsKey(neighbor)) {
                        continue;
                    }
                    distanceMap.put(neighbor, curDistance + 1);
                    if (endWord.equals(neighbor)) {
                        gotcha = true;
                    } else {
                        queue.offer(neighbor);
                    }
                }
            }
            if (gotcha) {
                break;
            }
        }

    }

    private List<String> getNeighbors(String curWord, HashSet<String> dict) {
        List<String> allNeighbors = new ArrayList<>();
        char[] chars = curWord.toCharArray();
        for (char c = 'a'; c <= 'z'; c++) {
            for (int i = 0; i < chars.length; i++) {
                if (c == chars[i]) continue;
                char oldVal = chars[i];
                chars[i] = c;
                String newWord = new String(chars);
                if (dict.contains(newWord)) {
                    allNeighbors.add(newWord);
                }
                chars[i] = oldVal;
            }
        }
        return allNeighbors;
    }

}
