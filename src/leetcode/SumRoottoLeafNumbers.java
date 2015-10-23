package leetcode;

/* Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * Find the total sum of all root-to-leaf numbers.
 * For example,
 *   1
 *  / \
 * 2   3
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * Return the sum = 12 + 13 = 25.
 */
public class SumRoottoLeafNumbers {
	public int sumNumbers(TreeNode root) {
		if (root == null)
			return 0;

		int[] res = new int[1];
		int curr = 0;
		helper(root, curr, res);
		return res[0];
	}

	private void helper(TreeNode node, int curr, int[] result) {
		if (node == null)
			return;
		if (node.left == null && node.right == null) {
			result[0] += 10 * curr + node.val;
		}
		curr = 10 * curr + node.val;
		helper(node.left, curr, result);
		helper(node.right, curr, result);
	}
}
