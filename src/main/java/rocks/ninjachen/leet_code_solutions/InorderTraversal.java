package rocks.ninjachen.leet_code_solutions;

import rocks.ninjachen.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 */
public class InorderTraversal {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    // Inorder traversal is : leftNode, cur.val, rightNode
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<Integer>();
        }
        // Add init value
        List<Object> list = new ArrayList<>();
        list.add(root);
        boolean stop = false;
        // Use stop flag to check is the scanner scan the bottom of the tree
        while (!stop) {
            stop = true;
            List<Object> nextList = new ArrayList<>();
            for (Object obj : list) {
                // Inside the list: [TreeNode:left, Integer:val, TreeNode:right]
                if (obj instanceof TreeNode) {
                    TreeNode node = (TreeNode) obj;
                    if (node.left != null) {
                        nextList.add(node.left);
                        stop = false;
                    }
                    nextList.add(new Integer(node.val));
                    if (node.right != null) {
                        nextList.add(node.right);
                        stop = false;
                    }
                } else if (obj instanceof Integer) {
                    Integer i = (Integer) obj;
                    nextList.add(i);
                } else {
                    throw new RuntimeException("Invalid item.");
                }
            }
            list = nextList;
        }
        // Convert List<Object> to List<Integer>
        List<Integer> answer = new ArrayList<>();
        for (Object obj : list) {
            answer.add((Integer) obj);
        }
        return answer;
    }
}
