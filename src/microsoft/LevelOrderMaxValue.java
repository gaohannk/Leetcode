package microsoft;

import leetcode.t.TreeNode;

import java.util.*;

/**
 *  Find max value in each row of a tree, return int array. eg.
 * [1,3,5,2,0,null,3,null,null,null,4] -> [1,5,2,4]
 * // 1
 * // 3 5
 * // 2 0 n. 3
 * // n n n 4
 */
public class LevelOrderMaxValue {
    public List<Integer> levelOrder(TreeNode root) {
        List<Integer> res = new LinkedList<Integer>();
        if (root == null)
            return res;
        ArrayList<TreeNode> currlayer = new ArrayList<TreeNode>();
        currlayer.add(root);
        while (true) {
            if (currlayer.isEmpty())
                break;
            ArrayList<TreeNode> nextlayer = new ArrayList<TreeNode>();
            int currMaxValue = Integer.MIN_VALUE;
            for (TreeNode node : currlayer) {
                currMaxValue = Math.max(node.val, currMaxValue);
                if (node.left != null) {
                    nextlayer.add(node.left);
                }
                if (node.right != null) {
                    nextlayer.add(node.right);
                }
            }
            res.add(currMaxValue);
            currlayer = nextlayer;
        }
        return res;
    }
}
