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
public class BinaryTreePaths {
	public List<String> binaryTreePaths(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		List<String> res = new LinkedList<String>();
		if (root == null)
			return res;
		stack.push(root);
		StringBuilder str = new StringBuilder();
		str.append(root.val);
		helper(root, res, str);
		return res;
	}

	public void helper(TreeNode node, List<String> res, StringBuilder str) {
		str.append("->" + node.val);
		if (node.left == null && node.right == null) {
			res.add(str.toString());
			return;
		} else if (node.left != null) {
			helper(node.left, res, str);
		} else if (node.right != null) {
			helper(node.right, res, str);

		}
	}
}
