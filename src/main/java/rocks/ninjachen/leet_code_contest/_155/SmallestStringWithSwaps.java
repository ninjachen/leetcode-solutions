package rocks.ninjachen.leet_code_contest._155;

import java.util.*;

public class SmallestStringWithSwaps {

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        // <Index, list of all chars>
        Map<Integer, List<Character>> map = new HashMap<>();

        UnionFind unionFind = new UnionFind(s.length());
        for (int i = 0; i < pairs.size(); i++) {
            List<Integer> pair = pairs.get(i);
            unionFind.union(pair.get(0), pair.get(1));
        }
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = s.charAt(i);
            int iRoot = unionFind.findRoot(i);
            map.computeIfAbsent(iRoot, k-> new ArrayList<>());
            map.get(iRoot).add(c);
        }
        for (List<Character> list : map.values()) {
            Collections.sort(list);
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < chars.length; i++) {
            int iRoot = unionFind.findRoot(i);
            char smallestChar = map.get(iRoot).remove(0);
            sb.append(smallestChar);
        }
        return sb.toString();
    }

    public static class UnionFind {
        private int[] size;
        private int[] parent;

        public UnionFind(int n) {
            size = new int[n];
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                size[i] = 1;
                parent[i] = i;
            }
        }

        public int findRoot(int n) {
            // Find, until find the root, the root's parent is root self.
            while (n != parent[n]) {
                parent[n] = parent[parent[n]];
                n = parent[n];
            }
            return parent[n];
        }

        /**
         * Union the smaller group (p|q) into the bigger group
         * @param p
         * @param q
         */
        public void union (int p, int q) {
            int pRoot = findRoot(p);
            int qRoot = findRoot(q);
            if(pRoot == qRoot) {
                return;
            }
            // If p's group is bigger, set q's parent as p
            if(size[pRoot] > size[qRoot]) {
                parent[qRoot] = pRoot;
                size[pRoot] = size[pRoot] + size[qRoot];
            }else {
                parent[pRoot] = qRoot;
                size[qRoot] = size[pRoot] + size[qRoot];
            }
        }

    }
}
