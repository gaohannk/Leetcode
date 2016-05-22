package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/*
 * Given a binary tree, return all root-to-leaf paths.
 * For example, given the following binary tree:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 * All root-to-leaf paths are:
 * ["1->2->5", "1->3"]
 */
public class BinaryTreePaths2 {
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> res = new LinkedList<String>();
		StringBuilder sb = new StringBuilder();
		if (root == null)
			return res;
		sb.append(root.val);
		if (root.left != null)
			helper(root.left, res, sb);
		if (root.right != null)
			helper(root.right, res, sb);
		if (root.left == null && root.right == null)
			res.add(sb.toString());
		return res;
	}

	public void helper(TreeNode node, List<String> res, StringBuilder sb) {
		sb.append("->" + node.val);
		if (node.left == null && node.right == null) {
			res.add(sb.toString());
			sb.delete(sb.length() - 2 - String.valueOf(node.val).length(), sb.length());
			return;
		}
		if (node.left != null)
			helper(node.left, res, sb);
		if (node.right != null)
			helper(node.right, res, sb);
		sb.delete(sb.length() - 2 - String.valueOf(node.val).length(), sb.length());
	}
}
