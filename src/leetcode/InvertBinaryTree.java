package leetcode;
/* invert a binary tree.
 *      4
 *   /   \
 *  2     7
 * / \   / \
 *1   3 6   9
 *to
 *    4
 *  /   \
 * 7     2
 * / \   / \
 *9   6 3   1
 */
public class InvertBinaryTree {
	public TreeNode invertTree(TreeNode root) {
		if (root == null)
			return null;
		TreeNode node = root.left;
		root.left = root.right;
		root.right = node;
		invertTree(root.left);
		invertTree(root.right);
		return root;
	}
}
