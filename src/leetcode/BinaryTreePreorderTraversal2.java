package leetcode;

import java.util.ArrayList;
import java.util.List;

/* Given a binary tree, return the preorder traversal of its nodes' values.
 * For example:
 * Given binary tree {1,#,2,3},
 *  1
 *   \
 *    2
 *   /
 *  3
 * return [1,2,3].
 * Note: Recursive solution is trivial, could you do it iteratively?
 */
public class BinaryTreePreorderTraversal2 {
	public List<Integer> preorderTraversal(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (root == null)
			return list;
		helper(list, root);
		return list;
	}

	public void helper(ArrayList<Integer> list, TreeNode node) {
		if (node != null) {
			list.add(node.val);
			helper(list, node.left);
			helper(list, node.right);
		}
	}
}
