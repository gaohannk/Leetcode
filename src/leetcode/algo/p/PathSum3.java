package leetcode.algo.p;

import leetcode.common.TreeNode;

public class PathSum3 {
	boolean hasPathSum(TreeNode root, int sum) {
		return hasPathSum(root, 0, sum);
	}

	boolean hasPathSum(TreeNode root, int sum, int target) {
		if (root == null)
			return false;
		sum += root.val;
		// must reach leaf nodes
		if (root.left == null && root.right == null) {
			return sum == target;
		}
		return hasPathSum(root.left, sum, target) || hasPathSum(root.right, sum, target);
	}

}
