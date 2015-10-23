package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/* Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * For example, this binary tree is symmetric:
 * 
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * But the following is not:
 *    1
 *   / \
 *  2   2
 *   \   \
 *   3    3
 * Note:
 * Bonus points if you could solve it both recursively and iteratively.
 */
/* 非递归解法：
 * 按层遍历，每一层检查一下是否对称。
 * 使用队列存储两个子树
 * 注意：
 * 区分两个子结点是否为空的四种情况
 */

public class SymmetricTree {
	public boolean isSymmetric(TreeNode root) {
		if (root == null)
			return true;
		Queue<TreeNode> left = new LinkedList<TreeNode>();
		Queue<TreeNode> right = new LinkedList<TreeNode>();

		left.add(root.left);
		right.add(root.right);
		while (!left.isEmpty() && !right.isEmpty()) {
			TreeNode t1 = left.poll();
			TreeNode t2 = right.poll();
			if (t1 != null && t2 != null) {
				if (t1.val != t2.val)
					return false;
				left.add(t1.left);
				left.add(t1.right);
				right.add(t2.right);
				right.add(t2.left);
			} else if (t1 != null && t2 == null || t1 == null && t2 != null) // 不要忘记
				return false;
		}
		return true;
	}
}
