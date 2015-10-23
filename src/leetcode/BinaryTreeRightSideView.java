package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 * For example:
 * Given the following binary tree,
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 * You should return [1, 3, 4].
 */
public class BinaryTreeRightSideView {
	public List<Integer> rightSideView(TreeNode root) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (root == null)
			return res;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		queue.add(null);
		int cur = 0;
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if (node != null) {
				cur = node.val;
				if (node.left != null) 
					queue.add(node.left);
				if (node.right != null) 
					queue.add(node.right);
			} else {
				res.add(cur);
				if (queue.isEmpty())
					break;
				queue.add(null);
			}
		}
		return res;
	}
}
