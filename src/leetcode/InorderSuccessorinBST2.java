package leetcode;

import java.util.Stack;

/* Given a binary search tree and a node in it, find the in-order successor of that node in the BST.
 * Note: If the given node has no in-order successor in the tree, return null.
 */
/* Time Complexity - O(h)， Space Complexity - O(1)
*/
public class InorderSuccessorinBST2 {

	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		if (root == null || p == null) {
			return null;
		}
		TreeNode successor = null;
		while (root != null) {
			if (root.val < p.val) {
				root = root.right;
			} else {
				successor = root;
				root = root.left;
			}
		}
		return successor;
	}

}
