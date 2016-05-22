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
	 public int rob(TreeNode root) {
	     dfs(root);
	     return root.val;
	  }

	private void dfs(TreeNode root) {
		if(root==null)
			return;
		if(root.left!=null)
			dfs(root.left);
		if(root.right!=null);
			dfs(root.right);
		if(root.right==null&&root.left!=null)
			root.val=Math.max(root.left.val, root.val);
		else if(root.left==null&&root.right!=null)
			root.val=Math.max(root.right.val, root.val);
		else if(root.left!=null && root.right!=null)
			root.val=Math.max(root.left.val+root.right.val, root.val);
	}
}
