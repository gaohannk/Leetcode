package leetcode;

/* Given a binary tree, determine if it is a valid binary search tree (BST).
 * Assume a BST is defined as follows:
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 */
/* 对于每一个子树，限制它的最大，最小值，如果超过则返回false。
 * 每一层节点，左子树限制最大值小于根，右子树最小值大于根；
 */
public class ValidateBinarySearchTree {
	public boolean isValidBST(TreeNode root) {
		return validate(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public static boolean validate(TreeNode root, int min, int max) {
		if (root == null)
			return true;
		// not in range
		if (root.val <= min || root.val >= max)
			return false;
		// left subtree must be < root.val && right subtree must be > root.val
		return validate(root.left, min, root.val) && validate(root.right, root.val, max);
	}
}
