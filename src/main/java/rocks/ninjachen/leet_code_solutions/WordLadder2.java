package rocks.ninjachen.leet_code_solutions;


import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.List;

public class WordLadder2 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        if (!wordList.contains(endWord)) {
            return result;
        }
        BitSet used = new BitSet();
        Node root = new Node(beginWord, null);
        root.wordList = wordList;
        List<Node> parents = new ArrayList<>();
        parents.add(root);
        boolean gotcha = false; // flag to stop the next loop
        int i = 0;
        long startT = System.currentTimeMillis();
        while (!parents.isEmpty() && !gotcha) {
            System.out.println(String.format("Loop %d, cost %d ms", ++i, System.currentTimeMillis() - startT));
            List<Node> children = new ArrayList<>();
            for (Node parent : parents) {
                List<String> allNeighbors = getAllNeighbors(parent.val, parent.wordList, used);
                for (String neighbor : allNeighbors) {
                    if (endWord.equals(neighbor)) {
                        gotcha = true;
                    }
                    Node child = new Node(neighbor, parent);
                    children.add(child);
//                    List<String> words = new ArrayList<>();
                    child.wordList = wordList;
//                    words.addAll(parent.wordList);
//                    words.remove(neighbor);
                }
            }
            System.out.println(String.format("Loop %d, Find %d parents, %d children, cost %d ms", i, parents.size(), children.size(), System.currentTimeMillis() - startT));
            if (gotcha) {
                // Find the shortest path, print.
                for (Node node : children) {
                    if (node.val.equals(endWord)) {
                        List<String> paths = new ArrayList<>();
                        while (node != null) {
                            paths.add(node.val);
                            node = node.parent;
                        }
                        Collections.reverse(paths);
                        result.add(paths);
                    }
                }
            }
            for (Node child : children) {
                used.set(child.val.hashCode());
            }

            parents = children;
        }
        return result;
    }

    private List<String> getAllNeighbors(String word, List<String> dict, BitSet used) {
        List<String> neighbors = new ArrayList<>();
        char[] chars = word.toCharArray();
        for (char c = 'a'; c <= 'z'; c++) {
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == c) continue;
                char oldChar = chars[i];
                chars[i] = c;
                String newWord = new String(chars);
                if (!used.get(newWord.hashCode()) && dict.contains(newWord)) {
                    neighbors.add(newWord);
                }
                //Reset the char
                chars[i] = oldChar;
            }
        }
        return neighbors;
    }

    private static class Node {
        String val;
        Node parent;
        List<String> wordList;

        public Node(String val, Node parent) {
            this.val = val;
            this.parent = parent;
        }
    }

}
