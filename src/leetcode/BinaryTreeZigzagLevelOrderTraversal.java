package leetcode;

import java.util.*;

/* Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its zigzag level order traversal as:
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 */
public class BinaryTreeZigzagLevelOrderTraversal {
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {

		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (root == null)
			return res;
		ArrayList<TreeNode> layer = new ArrayList<TreeNode>();
		layer.add(root);
		boolean flag = false;
		while (true) {
			if (layer.isEmpty())
				break;
			ArrayList<TreeNode> nextlayer = new ArrayList<TreeNode>();
			ArrayList<Integer> currlayer = new ArrayList<Integer>();
			for (TreeNode node : layer) {
				currlayer.add(node.val);
				if (node.left != null)
					nextlayer.add(node.left);
				if (node.right != null)
					nextlayer.add(node.right);
			}
			if (flag)
				Collections.reverse(currlayer);
			res.add(currlayer);
			flag = !flag;
			layer = nextlayer;
		}
		return res;
	}
}
