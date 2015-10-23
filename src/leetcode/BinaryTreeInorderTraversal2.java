package leetcode;

import java.util.*;

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
/* Use a stack. Time:O(n) and space O(logn). 
 */
/* 过程：
 * 1.维护一个栈stack和一个当前结点node。初始时将node赋值为根节点。
 * 2.将当前节点node的左子链上的节点逐个推入栈中，直到没有左儿子。
 * 3.取出栈顶的节点，访问该节点，将当前节点node赋值为该节点的右儿子。
 * 4.不断执行 2，3，直到栈为空且当前节点也为空。
 * 跟前序遍历的非递归实现方法二很类似。唯一的不同是访问当前节点的时机：前序遍历在入栈前访问，而中序遍历在出栈后访问。
 */
public class BinaryTreeInorderTraversal2 {
	public ArrayList<Integer> inorderTraversal(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (root == null)
			return list;
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
		return list;
	}
}
