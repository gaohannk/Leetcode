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
public class FlattenBinaryTreetoLinkedList3 {
	public void flatten(TreeNode root) {
		flatten(root, new TreeNode[1]);
	}

	private void flatten(TreeNode root, TreeNode[] prev) {
		if (root == null)
			return;
		if (prev[0] == null) {
			prev[0] = root;
		} else {
			prev[0].right = root;
			prev[0] = root;
		}
		TreeNode leftBeforeModification = root.left;
		TreeNode rightBeforeModification = root.right;
		root.left = null;
		flatten(leftBeforeModification, prev);
		flatten(rightBeforeModification, prev);
	}
}
