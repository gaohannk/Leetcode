package leetcode;

/* Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.
 * Note:
 * Given target value is a floating point.
 * You are guaranteed to have only one unique value in the BST that is closest to the target.
 */
public class ClosestBinarySearchTreeValue {
	public int closestValue(TreeNode root, double target) {
		double min[] = new double[1];
		min[0] = Double.MAX_VALUE;
		TreeNode res = root;
		closestValueHelper(root, target, min, res);
		return res.val;
	}

	private void closestValueHelper(TreeNode root, double target, double[] min, TreeNode res) {
		if (root == null) {
			return;
		}
		if (Math.abs((double) root.val - target) < min[0]) {
			min[0] = Math.abs((double) root.val - target);
			res = root;
		}
		if (root.val > target)
			closestValueHelper(root.left, target, min, res);
		else if (root.val < target)
			closestValueHelper(root.right, target, min, res);

	}
}
