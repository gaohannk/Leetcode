package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/* Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the 
 * values along the path equals the given sum.
 * For example:
 * Given the below binary tree and sum = 22,
 *             5
 *            / \
 *           4   8
 *          /   / \
 *         11  13  4
 *        /  \      \
 *       7    2      1
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */

public class PathSum2 {
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null)
			return false;
		Queue<TreeNode> nodes = new LinkedList<TreeNode>();
		Queue<Integer> values = new LinkedList<Integer>();
		
		nodes.add(root);
		values.add(root.val);

		while (!nodes.isEmpty()) {
			TreeNode curr = nodes.poll();
			int sumValue = values.poll();

			if (curr.left == null && curr.right == null && sumValue == sum) 
				return true;

			if (curr.left != null) {
				nodes.add(curr.left);
				values.add(sumValue + curr.left.val);
			}

			if (curr.right != null) {
				nodes.add(curr.right);
				values.add(sumValue + curr.right.val);
			}
		}
		return false;
	}
}
