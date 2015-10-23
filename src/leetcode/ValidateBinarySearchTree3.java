package leetcode;

import java.util.ArrayList;
import java.util.Stack;

public class ValidateBinarySearchTree3 {
	public boolean isValidBST(TreeNode root) {
		if (root == null)
			return true;
		ArrayList<Integer> list = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode node = root;
		while (!stack.isEmpty() || node != null) {
			while (node != null) {
				stack.push(node);
				node = node.left;
			}
			node = stack.pop();
			list.add(node.val);
			node = node.right;
		}
		for (int i = 1; i < list.size(); i++) {
			if (list.get(i) <= list.get(i - 1))
				return false;
		}
		return true;
	}
}
