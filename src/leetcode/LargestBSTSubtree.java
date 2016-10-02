package leetcode;

/*Given a binary tree, find the largest subtree which is a Binary Search Tree (BST), where largest means subtree with largest number of nodes in it.

Note:
A subtree must include all of its descendants.
Here's an example:

    10
    / \
   5  15
  / \   \ 
 1   8   7
The Largest BST Subtree in this case is the highlighted one. 
The return value is the subtree's size, which is 3.

 

Hint:

You can recursively use algorithm similar to 98. Validate Binary Search Tree at each node of the tree, which will result in O(nlogn) time complexity.
Follow up:
Can you figure out ways to solve it with O(n) time complexity?
*/
public class LargestBSTSubtree {
	public static int largestBSTSubtree2(TreeNode root) {
		int res = 0;
		if (root == null)
			return 0;
		if (isValidBST(root.left) && isValidBST(root.right)) {
			if (root.left != null && root.right != null) {
				if (root.left.val <= root.val && root.val <= root.right.val)
					res = largestBSTSubtree(root.left) + largestBSTSubtree(root.right) + 1;
				else {
					res = Math.max(largestBSTSubtree(root.left), largestBSTSubtree(root.right));
				}
			} else if (root.left != null) {
				if (root.left.val <= root.val)
					res = largestBSTSubtree(root.left) + 1;
				else
					res = largestBSTSubtree(root.left);
			} else if (root.right != null) {
				if (root.val <= root.right.val)
					res = largestBSTSubtree(root.right) + 1;
				else
					res = largestBSTSubtree(root.right);
			} else
				res = 1;
		} else if (isValidBST(root.left)) {
			if (root.right != null)
				res = Math.max(largestBSTSubtree(root.left), largestBSTSubtree(root.right));
			else {
				if (root.left.val <= root.val)
					res = largestBSTSubtree(root.left) + 1;
				else
					res = largestBSTSubtree(root.left);
			}

		} else if (isValidBST(root.right)) {
			if (root.left != null)
				res = Math.max(largestBSTSubtree(root.left), largestBSTSubtree(root.right));
			else {
				if (root.val <= root.right.val)
					res = largestBSTSubtree(root.right) + 1;
				else
					res = largestBSTSubtree(root.right);
			}
		} else {
			res = Math.max(largestBSTSubtree(root.left), largestBSTSubtree(root.right));
		}
		return res;
	}

	public static int largestBSTSubtree(TreeNode root) {
		int res = 0;
		if (root == null)
			return 0;
		if (root.left != null && root.right != null) {
			if (isValidBST(root.left) && isValidBST(root.right) && root.left.val <= root.val
					&& root.val <= root.right.val) {
				res = largestBSTSubtree(root.left) + largestBSTSubtree(root.right) + 1;
			} else
				res = Math.max(largestBSTSubtree(root.left), largestBSTSubtree(root.right));

		} else if (root.left != null) {
			if (isValidBST(root.left) && root.left.val <= root.val)
				res = largestBSTSubtree(root.left) + largestBSTSubtree(root.right) + 1;
			else
				res = largestBSTSubtree(root.left);
		} else if (root.right != null) {
			if (isValidBST(root.right) && root.val <= root.right.val)
				res = largestBSTSubtree(root.left) + largestBSTSubtree(root.right) + 1;
			else
				res = largestBSTSubtree(root.right);
		} else
			res = 1;
		return res;
	}

	public static boolean isValidBST(TreeNode root) {
		return validate(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public static boolean validate(TreeNode root, int min, int max) {
		if (root == null)
			return true;
		// not in range
		if (root.val <= min || root.val >= max)
			return false;
		// left subtree must be < root.val && right subtree must be > root.val
		return validate(root.left, min, root.val) && validate(root.right, root.val, max);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(15);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(8);
		root.right.right = new TreeNode(7);
		System.out.println(largestBSTSubtree(root));
	}
}
