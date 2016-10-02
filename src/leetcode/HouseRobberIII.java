package leetcode;

import java.util.Stack;

/* The thief has found himself a new place for his thievery again. 
 * There is only one entrance to this area, called the "root." 
 * Besides the root, each house has one and only one parent house. 
 * After a tour, the smart thief realized that "all houses in this place forms a binary tree". 
 * It will automatically contact the police if two directly-linked houses were broken into on the same night.
 * Determine the maximum amount of money the thief can rob tonight without alerting the police.
 * Example 1:
     3
    / \
   2   3
    \   \ 
     3   1
     Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
     Example 2:
     3
    / \
   4   5
  / \   \ 
 1   3   1
 Maximum amount of money the thief can rob = 4 + 5 = 9.
*/
public class HouseRobberIII {
	class Node {
		public Node(int val2) {
			this.val = val2;
		}

		boolean rob = false;
		int norobValue;
		int robValue;
		Node left, right;
		int val;
	}

	public int rob(TreeNode root) {
		if (root == null)
			return 0;
		Node r = tree(root);
		dfs(r);
		return Math.max(r.norobValue, r.robValue);
	}
	private Node tree(TreeNode root) {
		Node r = new Node(root.val);
		if (root.left != null)
			r.left = tree(root.left);
		if (root.right != null)
			r.right = tree(root.right);
		return r;
	}

	private void dfs(Node root) {
		if (root == null)
			return;
		if (root.left != null)
			dfs(root.left);
		if (root.right != null)
			dfs(root.right);
		if (root.right == null && root.left != null) {
			root.robValue = root.left.norobValue + root.val;
			root.norobValue = Math.max(root.left.robValue, root.left.norobValue);
		} else if (root.left == null && root.right != null) {
			root.robValue = root.right.norobValue + root.val;
			root.norobValue = Math.max(root.right.robValue, root.right.norobValue);
		} else if (root.left != null && root.right != null) {
			root.robValue = root.right.norobValue + root.val + root.left.norobValue;
			int max = Math.max(root.right.robValue + root.left.robValue, root.right.norobValue + root.left.norobValue);
			max = Math.max(max, root.right.robValue + root.left.norobValue);
			root.norobValue = Math.max(max, root.left.robValue + root.right.norobValue);
		} else {
			root.robValue = root.val;
			root.norobValue = 0;
		}
	}
}
