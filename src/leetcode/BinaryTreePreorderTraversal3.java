package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/* 过程：
 * 1.维护一个栈stack和一个当前节点node。初始时将node赋值为根节点。
 * 2.逐个访问当前节点node的左子链上的节点，并推入栈中，直到没有左儿子。
 * 3.取出栈顶的节点，将node赋值为该节点的右儿子。
 * 4.不断执行 2,3,直到栈为空且当前节点也为空
 * 该方法模拟了递归的前序遍历中程序调用栈的行为过程：在调用栈中，会不断的递归进入左儿子链中，直到没有左儿子，再进入对右儿子的处理中。
 * 与递归方法的调用栈的不同之处在于，内层 while 循环将递归方法中针对左儿子链上所有节点的递归过程集中到了一起。
 */
public class BinaryTreePreorderTraversal3 {
	public List<Integer> preorderTraversal(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode node = root;
		while (!stack.isEmpty() || node != null) {
			while (node != null) {
				list.add(node.val);
				stack.push(node);
				node = node.left;
			}
			node = stack.pop();
			node = node.right;
		}
		return list;
	}
}
