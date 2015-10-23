package leetcode;

public class PathSum3 {
	boolean hasPathSum(TreeNode root, int sum) {
		return hasPathSum(root, 0, sum);
	}

	boolean hasPathSum(TreeNode root, int sum, int target) {
		if (root == null)
			return false;
		sum += root.val;
		if (root.left == null && root.right == null) {
			if (sum == target)
				return true;
			else
				return false;
		}
		return hasPathSum(root.left, sum, target) || hasPathSum(root.right, sum, target);
	}

}
