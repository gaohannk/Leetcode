package leetcode;

import java.util.*;

/* Given a binary tree, return the postorder traversal of its nodes' values.
 * For example:
 * Given binary tree {1,#,2,3},
 * 1
 *   \
 *     2
 *   /
 * 3
 * return [3,2,1].
 * Note: Recursive solution is trivial, could you do it iteratively?
 */
/* 1.维护一个栈 stack、当前节点 n 和一个标记数组 flag。将根节点的左儿子链上的所有节点压入 stack 中，并将标记数组对因为值置为 0.
 * 2.将当前节点赋值为栈顶的节点。如果节点有右儿子，且没有被处理过（通过标记数组判定），则将右子树的根节点及其左儿子全部压入栈中。
 * 3.将当前节点赋值为栈顶的节点，访问它，并将该节点从栈中 pop 出。
 * 4.循环 2，3 两步，直到栈为空。
 * 在非递归方法中用栈模拟程序调用栈，碰到的最大的问题就是模拟递归方法所处的状态。编码维护的栈能记录节点，但无法记录在如何处理该节点。
 * 这里使用了一个flag数组来记录节点的右子树是否被访问过，对每个节点进行访问的时候，都保证已经处理完了左右子树
 *（通过先压入左边儿子链为主线，处理栈中的每个节点时，再压入右边儿子来实现）。
 */
public class BinaryTreePostorderTraversal {
	public List<Integer> postorderTraversal(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode node = root;
		int[] flag = new int[Integer.MAX_VALUE];
		
		while (node != null) {
			stack.push(node);
			flag[stack.size()] = 0;
			node = node.left;
		}
		while (!stack.isEmpty()) {
			node = stack.peek();
			while (flag[stack.size()] == 0 && node.right != null) {
				node=node.right;
				flag[stack.size()]=1;
				while (node != null) {
					stack.push(node);
					flag[stack.size()] = 0;
					node = node.left;
				}
				node=stack.peek();
			}
			node = stack.pop();
			list.add(node.val);
		}
		return list;
	}
}
