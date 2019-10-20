package leetcode.b;

import java.util.LinkedList;
import java.util.List;

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
// Best MinDeleteNoMoreThanThree
public class BinaryTreePaths {
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> res = new LinkedList<String>();
		StringBuilder sb = new StringBuilder();
		if (root == null)
			return res;
		helper(root, res, sb);
		return res;
	}

	public void helper(TreeNode node, List<String> res, StringBuilder sb) {
		if (node.left == null && node.right == null) {
			sb.append(node.val);
			res.add(sb.toString());
			sb.delete(sb.length() - String.valueOf(node.val).length(), sb.length());
			return;
		} else {
			sb.append(node.val + "->");
		}
		if (node.left != null)
			helper(node.left, res, sb);
		if (node.right != null)
			helper(node.right, res, sb);
		sb.delete(sb.length() - 2 - String.valueOf(node.val).length(), sb.length());
	}
}
