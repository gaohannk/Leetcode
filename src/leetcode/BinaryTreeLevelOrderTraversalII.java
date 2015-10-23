package leetcode;

import java.util.ArrayList;

/* Given a binary tree, return the bottom-up level order traversal of its nodes' values. 
 * (ie, from left to right, level by level from leaf to root).
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
 *       3
 *      / \
 *     9  20
 *   /  \
 *  15   7
 * return its bottom-up level order traversal as:
 * [ 
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 */
public class BinaryTreeLevelOrderTraversalII {
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> res_reverse = new ArrayList<ArrayList<Integer>>();
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
		for (int i = res.size() - 1; i >= 0; i--) {
			res_reverse.add(res.get(i));
		}
		return res_reverse;
	}
}
