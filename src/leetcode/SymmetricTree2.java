package leetcode;

/* Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * For example, this binary tree is symmetric:
 * 
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * But the following is not:
 *    1
 *   / \
 *  2   2
 *   \   \
 *   3    3
 * Note:
 * Bonus points if you could solve it both recursively and iteratively.
 */
/* 递归解法：
 * 左子树和右子树对称的条件：
 * 两个节点值相等，或者都为空
 * 左节点的左子树和右节点的右子树对称
 * 左节点的右子树和右节点的左子树对称
 */
public class SymmetricTree2 {
	public boolean isSymmetric(TreeNode root) {
		if (root == null)
			return true;
		return isSymmetric(root.left, root.right);
	}

	public boolean isSymmetric(TreeNode left, TreeNode right) {
		if (left == null && right == null)
			return true;
		if (left != null && right != null) {
			if (left.val != right.val)
				return false;
			return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
		} else
			return false;
	}
}
