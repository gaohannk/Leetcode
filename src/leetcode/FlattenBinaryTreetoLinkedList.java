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
public class FlattenBinaryTreetoLinkedList {
	public void flatten(TreeNode root) {
		if (root != null) {
			while (root.left != null || root.right != null) {
				if (root.left != null) {
					TreeNode rightmost = root.left;
					TreeNode right = root.left;
					TreeNode temp = root.right;
					while (rightmost.right != null) {
						rightmost = rightmost.right;
					}
					rightmost.right = temp;
					root.right = right;
					root.left = null;
					root = root.right;
				} else
					root = root.right;
			}
		}
	}
}
