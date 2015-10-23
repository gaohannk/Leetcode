package leetcode;
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
import java.util.Stack;

public class FlattenBinaryTreetoLinkedList4 {
	public void flatten(TreeNode root) {
		if (root == null) 
			return;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		TreeNode prev = null;
		while (!stack.empty()) {
			TreeNode top = stack.pop();
			if (top.right != null)
				stack.push(top.right);
			if (top.left != null)
				stack.push(top.left);
			if (prev != null) {
				prev.right = top;
				prev.left = null;
			}
			prev = top;
		}
	}
}
