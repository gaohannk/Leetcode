package leetcode;

import java.util.ArrayList;

/* Given a binary tree, return the in-order traversal of its nodes' values.
 * For example:
 * Given binary tree {1,#,2,3},
 *    1
 *      \
 *        2
 *      /
 *    3
 * return [1,3,2].
 * Note: Recursive solution is trivial, could you do it iteratively?
 * OJ's Binary Tree Serialization:
 * The serialization of a binary tree follows a level order traversal, where '#' signifies a path terminator
 * where no node exists below.
 * Here's an example:
 *   1
 *  / \
 * 2   3
 *    /
 *   4
 *    \
 *     5
 * The above binary tree is serialized as "{1,2,3,#,#,4,#,#,5}".
 */
public class BinaryTreeInorderTraversal {
	public ArrayList<Integer> inorderTraversal(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (root == null)
			return list;
		helper(root, list);
		return list;
	}

	public void helper(TreeNode root, ArrayList<Integer> list) {
		if (root != null) {
			helper(root.left, list);
			list.add(root.val);
			helper(root.right, list);
		}
	}
}
