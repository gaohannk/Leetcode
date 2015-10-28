package leetcode;

import java.util.Stack;

public class ClosestBinarySearchTreeValue2 {
	public int closestValue(TreeNode root, double target) {
		Stack<TreeNode> stk = new Stack<TreeNode>();
		TreeNode cur = root;
		TreeNode pre = null;
		while (!stk.isEmpty() || cur != null) {
			if (cur != null) {
				stk.push(cur);
				cur = cur.left;
			} else {
				TreeNode node = stk.pop();
				if (target < node.val) {
					return pre != null && Math.abs(node.val - target) > Math.abs(pre.val - target) ? pre.val : node.val;
				}
				pre = node;
				cur = node.right;
			}
		}
		return pre.val;
	}
}
