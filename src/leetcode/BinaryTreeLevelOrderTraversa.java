package leetcode;

import java.util.*;

/* Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
 *     3
 *    / \
 *   9  20
 *  /  \
 * 15   7
 * return its level order traversal as:
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 */
public class BinaryTreeLevelOrderTraversa {
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (root == null)
			return res;
		ArrayList<TreeNode> layer = new ArrayList<TreeNode>();
		layer.add(root);
		while (true) {
			if (layer.isEmpty())
				break;
			ArrayList<TreeNode> nextlayer = new ArrayList<TreeNode>();
			ArrayList<Integer> currlayer = new ArrayList<Integer>();
			for (TreeNode node : layer) {
				currlayer.add(node.val);
				if (node.left != null) {
					nextlayer.add(node.left);
				}
				if (node.right != null) {
					nextlayer.add(node.right);
				}
			}
			res.add(currlayer);
			layer = nextlayer;
		}
		return res;
	}
}
