package leetcode;

import java.util.ArrayList;
import java.util.Stack;

public class PathSumII2 {
	public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (root == null)
			return res;
		Stack<Integer> curr = new Stack<Integer>();
		helper(root, sum, curr, res);
		return res;
	}

	private void helper(TreeNode node, int sum, Stack<Integer> current, ArrayList<ArrayList<Integer>> result) {
		if (node == null)
			return;
		
		current.push(node.val);
		if (node.left == null && node.right == null) {
			if (sum == node.val) {
				ArrayList<Integer> temp = new ArrayList<Integer>(current);
				result.add(temp);
			}
		}

		helper(node.left, sum - node.val, current, result);
		helper(node.right, sum - node.val, current, result);
		current.pop();
	}
}
