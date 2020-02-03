package leetcode.algo.c;

import leetcode.common.TreeNode;

/**
 * Given a binary tree, count the number of uni-value subtrees.
 *
 * A Uni-value subtree means all nodes of the subtree have the same value.
 *
 * Example :
 *
 * Input:  root = [5,1,5,5,5,null,5]
 *
 * 5
 * / \
 * 1   5
 * / \   \
 * 5   5   5
 *
 * Output: 4
 */

// TODO
public class CountUnivalueSubtrees {
    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        if (root.left != null && root.right != null) {
            res += countUnivalSubtrees(root.left);
            res += countUnivalSubtrees(root.right);
        } else if (root.left == null && root.right != null) {
            res += countUnivalSubtrees(root.right);
        } else if (root.left != null && root.right == null) {
            res += countUnivalSubtrees(root.left);
        }
        return res;
    }
}
