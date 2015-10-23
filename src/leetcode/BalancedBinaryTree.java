package leetcode;

/* Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees 
 * of every node never differ by more than 1.
 */
public class BalancedBinaryTree {
	public boolean isBalanced(TreeNode root) {
		if (root == null)
			return true;
		boolean left = isBalanced(root.left);
		boolean right = isBalanced(root.right);
		if (left && right && Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1)
			return true;
		return false;
	}

	public int getHeight(TreeNode root) {
		if (root == null)
			return 0;
		int left = getHeight(root.left);
		int right = getHeight(root.right);
		return Math.max(left, right) + 1;

	}
}
