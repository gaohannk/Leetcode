package leetcode;

import java.util.Stack;

/* Given a binary search tree and a node in it, find the in-order successor of that node in the BST.
 * Note: If the given node has no in-order successor in the tree, return null.
 */
/* Time Complexity - O(h)， Space Complexity - O(1)
 * Morris Traversal
 */
public class InorderSuccessorinBST3 {

	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		if (root == null || p == null) {
			return null;
		}

		while (root != null) {
			if (root.left == null) {
				System.out.println();
				root = root.right;
			} else {
				TreeNode pre = root.left;
				while (pre.right != null && pre.right != root)
					pre = pre.right;
				if (pre.right == null) {
					pre.right = root;
					root = root.left;

				} else {
					pre.right = null;
					System.out.println();
					root = root.right;
				}
			}
		}
		return root;
	}

}
