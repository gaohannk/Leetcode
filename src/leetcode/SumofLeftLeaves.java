package leetcode;

/*Find the sum of all left leaves in a given binary tree.

Example:

    3
   / \
  9  20
    /  \
   15   7

There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
*/
public class SumofLeftLeaves {
	public static int sumOfLeftLeaves(TreeNode root) {
		int sum = 0;
		if(root==null)
			return sum;
		sum=helper(root.left, sum, root);
		sum=helper(root.right, sum, root);
		return sum;
	}

	private static int helper(TreeNode root, int sum, TreeNode parent) {
		if (root == null)
			return sum;
		if (root.left == null && root.right == null && root == parent.left)
			sum += root.val;
		sum = helper(root.left, sum, root);
		sum = helper(root.right, sum, root);
		return sum;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left= new TreeNode(9);
		root.right=new TreeNode(20);
		root.right.left=new TreeNode(15);
		root.right.right=new TreeNode(7);
		System.out.println(sumOfLeftLeaves(root));
	}
}
