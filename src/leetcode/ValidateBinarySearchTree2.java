package leetcode;

import java.util.ArrayList;

/* Given a binary tree, determine if it is a valid binary search tree (BST).
 * Assume a BST is defined as follows:
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 */
/* 中序遍历，结果递增
 */
public class ValidateBinarySearchTree2 {
	public boolean isValidBST(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (root == null)
			return true;
		helper(root, list);
		for (int i = 1; i < list.size(); i++) {
			if (list.get(i) <= list.get(i - 1))
				return false;
		}
		return true;
	}

	public void helper(TreeNode root, ArrayList<Integer> list) {
		if (root != null) {
			helper(root.left, list);
			list.add(root.val);
			helper(root.right, list);
		}
	}
}
