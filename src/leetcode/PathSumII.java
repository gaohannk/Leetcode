package leetcode;

import java.util.*;

/* Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * For example:
 * Given the below binary tree and sum = 22,
 *             5
 *            / \
 *           4   8
 *          /   / \
 *         11  13  4
 *        /  \    / \
 *       7    2  5   1
 * return
 * [
 *   [5,4,11,2],
 *   [5,8,4,5]
 * ]
 */
public class PathSumII {
	public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (root == null)
			return res;

		Stack<TreeNode> nodes = new Stack<TreeNode>();
		Stack<Integer> accSums = new Stack<Integer>();
		LinkedList<TreeNode> path = new LinkedList<TreeNode>();
		nodes.add(root);
		accSums.add(root.val);

		while (!nodes.isEmpty()) {
			TreeNode node = nodes.pop();
			Integer accSum = accSums.pop();
			path.add(node);

			if (node.left == null && node.right == null) {
				if (accSum == sum) {
					res.add(getPath(path));
				}
				path.remove(path.size() - 1);
				while (!nodes.isEmpty() && !path.isEmpty() && path.peekLast().right != nodes.peek())
					path.remove(path.size() - 1);

			}
			if (node.right != null) {
				nodes.add(node.right);
				accSums.add(accSum + node.right.val);
			}

			if (node.left != null) {
				nodes.add(node.left);
				accSums.add(accSum + node.left.val);
			}
		}
		return res;
	}

	public ArrayList<Integer> getPath(LinkedList<TreeNode> s) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		for (TreeNode node : s) {
			res.add(node.val);
		}
		return res;
	}
}
