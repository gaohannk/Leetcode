package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/* Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
 *     3
 *    / \
 *   9  20
 *  /  \
 * 15   7
 * return its level order traversal as:
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 */
/* Using null to seperate each layer
 * 
 */
public class BinaryTreeLevelOrderTraversa2 {
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if(root==null)
			return res;
		ArrayList<Integer> currlayer = new ArrayList<Integer>();
		queue.add(root);
		queue.add(null);
		currlayer.add(root.val);
		res.add(currlayer);
		// null is used for seperate each level
		while (queue.isEmpty() != false) {
			TreeNode node = queue.poll();
			if (node != null) {
				currlayer.add(node.val);
				if (node.left != null)
					queue.add(node.left);
				if (node.right != null)
					queue.add(node.right);
			} else {
				if (queue.isEmpty())
					break;
				res.add(currlayer);
				currlayer = new ArrayList<Integer>();
				queue.add(null);
			}
		}
		return res;
	}
}
