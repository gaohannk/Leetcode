package leetcode.algo.b;

import leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

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
//BFS
public class BinaryTreeTilt2 {
    public int findTilt(TreeNode root) {
        if (root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int res = 0;
        while (!queue.isEmpty()) {
            Queue<TreeNode> next = new LinkedList<>();
            while (queue.size() > 0) {
                TreeNode node = queue.poll();
                res += Math.abs(getSum(node.left) - getSum(node.right));
                if (node.left != null) {
                    next.offer(node.left);
                }
                if (node.right != null) {
                    next.offer(node.right);
                }
            }
            queue = next;
        }
        return res;
    }

    private int getSum(TreeNode root) {
        if (root == null)
            return 0;
        return root.val + getSum(root.left) + getSum(root.right);
    }
}
