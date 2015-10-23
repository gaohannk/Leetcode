package leetcode;

/* Two elements of a binary search tree (BST) are swapped by mistake.
 * Recover the tree without changing its structure.
 * Note:
 * A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
 */
/* O(1)空间的解法:
 * 中序遍历, 记录顺序错误的两个结点。每次比较只需要存一个前驱即可。
 * node1和node2两个要找的错误结点。
 */
public class RecoverBinarySearchTree {
	TreeNode node1 = null;
	TreeNode node2 = null;
	TreeNode prev = null;
	public void recoverTree(TreeNode root) {
		inorderTraverse(root);
		int tmp = node1.val;
		node1.val = node2.val;
		node2.val = tmp;
	}
	private void inorderTraverse(TreeNode root) {
		if (root == null)
			return;
		inorderTraverse(root.left);
		if (prev != null) {
			if (root.val <= prev.val) {
				if (node1 == null)
					node1 = prev;
				node2 = root;
			}
		}
		prev = root;
		inorderTraverse(root.right);
	}
}
