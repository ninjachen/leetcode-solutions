package rocks.ninjachen.leet_code_solutions;

import rocks.ninjachen.util.TreeNode;

/**
 * https://leetcode.com/problems/validate-binary-search-tree/submissions/
 */
public class ValidateBinarySearchTree {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return isValidBST(root, root.val, root.val);
        }
    }

    public boolean isValidBST(TreeNode node, Integer min, Integer max) {
        if (min == null)
            min = node.val;
        if (max == null)
            max = node.val;
        if (node.left != null) {
            if (node.left.val >= min) {
                return false;
            }
            min = node.left.val;
            boolean isLeftValid = isValidBST(node.left, min, null);
            if (!isLeftValid) {
                return false;
            }
        }
        if(node.right != null) {
            if (node.right.val <= max) {
                return false;
            }
            max = node.right.val;
            boolean isRightValid = isValidBST(node.right, null, max);
            if (!isRightValid) {
                return false;
            }
        }
        return true;
    }
}
