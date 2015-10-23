package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/* Given a binary tree, return the preorder traversal of its nodes' values.
 * For example:
 * Given binary tree {1,#,2,3},
 *  1
 *   \
 *    2
 *   /
 *  3
 * return [1,2,3].
 * Note: Recursive solution is trivial, could you do it iteratively?
 */
/* 分析：
 * 这个栈的递归策略不具备很好的扩展性，其他的遍历方式无法使用这种策略。实际上，它并不是对程序调用栈的模拟，而是针对先序遍历的特殊实现.
 * 先序遍历先对当前节点做出访问后，然后递归的调用对儿子节点的遍历，不需要在对儿子节点遍历结束后再回过头来处理当前节点。
 * 于是模拟的递归中也不需要存储之前的调用栈信息，只需要类似的生成一个未来的儿子节点的访问计划即可。
 */
public class BinaryTreePreorderTraversal {
	public List<Integer> preorderTraversal(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (root == null)
			return null;

		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.add(root);
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			list.add(node.val);
			if (node.right != null)
				stack.add(node.right);
			if (node.left != null) {
				stack.add(node.left);
			}
		}
		return list;
	}
}
