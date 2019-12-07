package leetcode.algo.b;

import leetcode.common.TreeNode;

/**
 * Given a binary tree, return the tilt of the whole tree.
 * <p>
 * The tilt of a tree node is defined as the absolute difference between the sum of all left subtree node values and the sum of all right subtree node values. Null node has tilt 0.
 * <p>
 * The tilt of the whole tree is defined as the sum of all nodes' tilt.
 * <p>
 * Example:
 * Input:
 * 1
 * /   \
 * 2     3
 * Output: 1
 * Explanation:
 * Tilt of node 2 : 0
 * Tilt of node 3 : 0
 * Tilt of node 1 : |2-3| = 1
 * Tilt of binary tree : 0 + 0 + 1 = 1
 * Note:
 * <p>
 * The sum of node values in any subtree won't exceed the range of 32-bit integer.
 * All the tilt values won't exceed the range of 32-bit integer.
 */
public class BinaryTreeTilt {
    public int findTilt(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int tilt = Math.abs(getSum(root.left) - getSum(root.right));
        return tilt + findTilt(root.left) + findTilt(root.right);
    }

    private int getSum(TreeNode root) {
        if (root == null)
            return 0;
        return root.val + getSum(root.left) + getSum(root.right);
    }
}
