package leetcode.algo.u;

import leetcode.common.TreeNode;

/**
 * A binary tree is univalued if every node in the tree has the same value.
 * <p>
 * Return true if and only if the given tree is univalued.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: [1,1,1,1,1,null,1]
 * Output: true
 * Example 2:
 * <p>
 * <p>
 * Input: [2,2,2,5,2]
 * Output: false
 */
public class UnivaluedBinaryTree {
    public boolean isUnivalTree(TreeNode root) {
        if (root == null)
            return true;
        return helper(root, root.val);
    }

    private boolean helper(TreeNode root, int val) {
        if (root == null)
            return true;
        if(root.val != val)
            return false;
        return helper(root.left, val) && helper(root.right, val);
    }
}
