package leetcode.algo.i;

import leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 897. Increasing Order Search Tree
 * Time Complexity: O(N) where N is the number of nodes in the given tree.
 * <p>
 * Space Complexity: O(N) the size of the answer.
 */
public class IncreasingOrderSearchTree {
    public TreeNode increasingBST(TreeNode root) {
        if (root == null)
            return null;
        List<Integer> res = new LinkedList<>();
        inOrder(root, res);
        TreeNode newRoot = new TreeNode(res.get(0));
        TreeNode cur = newRoot;
        for (int i = 1; i < res.size(); i++) {
            cur.right = new TreeNode(res.get(i));
            cur = cur.right;
        }
        return newRoot;
    }

    private void inOrder(TreeNode node, List<Integer> res) {
        if (node.left != null) {
            inOrder(node.left, res);
        }
        res.add(node.val);
        if (node.right != null) {
            inOrder(node.right, res);
        }
    }
}
