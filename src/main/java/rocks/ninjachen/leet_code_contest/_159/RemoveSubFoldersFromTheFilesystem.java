package rocks.ninjachen.leet_code_contest._159;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/contest/weekly-contest-159/problems/remove-sub-folders-from-the-filesystem/
 */
public class RemoveSubFoldersFromTheFilesystem {
    public List<String> removeSubfolders(String[] folder) {
        // Construct the node tree
        List<Node> rootNodes = new ArrayList<>();
        for (String folderStr : folder) {
            if (folderStr.length() <= 1) continue;
            if (folderStr.charAt(0) != '/') continue;
            String[] path = folderStr.split("/");
            // Trye to add path to root
            Node parent = null;
            Node cur = null;
            String curPath = "/" + path[1];
            for (Node node : rootNodes) {
                if (node.name.equals(path[1])) {
                    cur = node;
                    break;
                }
            }
            if (cur == null) {
                cur = new Node(null, path[1], curPath);
                rootNodes.add(cur);
                if (1 == path.length - 1) {
                    cur.isInFolderArray = true;
                }
            }
            // Move forward
            parent = cur;
            cur = null;
            if (parent.isInFolderArray) {
                continue;
            }
            for (int i = 2; i < path.length; i++) {
                curPath = curPath + "/" + path[i];
                for (Node node : parent.children) {
                    if (node.name.equals(path[i])) {
                        cur = node;
                        break;
                    }
                }
                if (cur == null) {
                    cur = new Node(null, path[i], curPath);
                    parent.children.add(cur);
                    if (i == path.length - 1) {
                        cur.isInFolderArray = true;
                    }
                }
                // Move forward
                parent = cur;
                cur = null;
                if (parent.isInFolderArray) {
                    break;
                }
            }
        }
        List<String> output = new ArrayList<>();
        List<Node> queue = new ArrayList<>(rootNodes);
        while (!queue.isEmpty()) {
            List<Node> nextQueue = new ArrayList<>();
            for (Node node : queue) {
                List<String> folderList = Arrays.asList(folder);
                if (folderList.contains(node.path)) {
                    output.add(node.path);
                } else {
                    nextQueue.addAll(node.children);
                }
            }
            queue = nextQueue;
        }
        return output;
    }

    public static class Node {
        Node parent;
        List<Node> children = new ArrayList<>();
        String name;
        String path;
        boolean isInFolderArray = false;

        public Node(Node parent, String name, String path) {
            this.parent = parent;
            this.name = name;
            this.path = path;
        }

        public boolean equals(Object obj) {
            if (obj instanceof Node) {
                return ((Node) obj).path.equals(this.path);
            }
            return false;
        }
    }

}
