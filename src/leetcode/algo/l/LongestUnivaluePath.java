package leetcode.algo.l;

import leetcode.common.TreeNode;

public class LongestUnivaluePath {
    int res = 0;

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        helper(root);
        return res;
    }

    private int helper(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = helper(node.left), right = helper(node.right);
        int cur = 0;
        if (node.left != null && node.left.val == node.val) {
            cur = Math.max(left + 1, cur);
        }
        if (node.right != null && node.val == node.right.val) {

            cur = Math.max(right + 1, cur);
        }
        if (node.left != null && node.right != null && node.left.val == node.val && node.val == node.right.val) {
            res = Math.max(res, left + right + 2);

        }
        // Update Global value
        res = Math.max(res, cur);
        return cur;
    }
}
