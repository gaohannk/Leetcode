package leetcode;

import java.util.Stack;

/* Given a binary search tree and a node in it, find the in-order successor of that node in the BST.
 * Note: If the given node has no in-order successor in the tree, return null.
 */
/* Time Complexity - O(n)， Space Complexity - O(n)
 * 
 */
public class InorderSuccessorinBST {

	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		if(root == null || p == null) {
            return null;
        }
		Stack<TreeNode> stack = new Stack<>();
		boolean found = false;
		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			if (found)
				return root;
			if (root.val == p.val)
				found = true;
			root = root.right;
		}
		return root;
	}

}
