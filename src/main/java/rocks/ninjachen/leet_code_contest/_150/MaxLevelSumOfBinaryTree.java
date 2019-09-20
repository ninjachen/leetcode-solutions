package rocks.ninjachen.leet_code_contest._150;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/contest/weekly-contest-150/problems/maximum-level-sum-of-a-binary-tree/
 * Input: [1,7,0,7,-8,null,null]
 * Output: 2
 * Explanation:
 * Level 1 sum = 1.
 * Level 2 sum = 7 + 0 = 7.
 * Level 3 sum = 7 + -8 = -1.
 * So we return the level with the maximum sum which is level 2.
 */
public class MaxLevelSumOfBinaryTree {
    public int maxLevelSum(TreeNode root) {
        //<level, list of nodes>
        Map<Integer, List<TreeNode>> map = new HashMap();
        formatToMap(root, 1, map);
        int maxVal = -1;
        int minLevel = 99999;
        for (Integer level : map.keySet()) {
            int val = 0;
            List<TreeNode> list = map.get(level);
            for (TreeNode node : list) {
                val += node.val;
            }
            if (val > maxVal) {
                maxVal = val;
                minLevel = level;
            } else if (val == maxVal && level < minLevel) {
                minLevel = level;
            }
        }
        return minLevel;
    }

    public void formatToMap(TreeNode node, int level, Map<Integer, List<TreeNode>> map) {
        List<TreeNode> list = map.get(level);
        if (list == null) {
            list = new ArrayList<>();
            map.put(level, list);
        }
        list.add(node);
        if (node.left != null) {
            formatToMap(node.left, level + 1, map);
        }
        if (node.right != null) {
            formatToMap(node.right, level + 1, map);
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
