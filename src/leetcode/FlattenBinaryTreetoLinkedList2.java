package leetcode;

import java.util.*;

/* Given a binary tree, flatten it to a linked list in-place.
 * For example,
 * Given
 *
 *         1
 *        / \
 *       2   5
 *      / \   \
 *     3   4   6
 * The flattened tree should look like:
 *  1
 *   \
 *    2
 *     \
 *      3
 *       \
 *        4
 *         \
 *          5
 *           \
 *            6
 * Hints:
 * If you notice carefully in the flattened tree, each node's right child points to the next node of a pre-order traversal.
 */
public class FlattenBinaryTreetoLinkedList2 {
	public void flatten(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode p = root;

		while (p != null || !stack.empty()) {
			if (p.right != null)
				stack.push(p.right);
			if (p.left != null) {
				p.right = p.left;
				p.left = null;
			} else if (!stack.empty())
				p.right = stack.pop();
			p = p.right;
		}
	}
}
