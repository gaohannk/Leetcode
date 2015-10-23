package leetcode;

/* Two elements of a binary search tree (BST) are swapped by mistake.
 * Recover the tree without changing its structure.
 */
/* Morries中序遍历步骤：
 * 1. 如果当前节点的左孩子为空，则输出当前节点并将其右孩子作为当前节点。
 * 2. 如果当前节点的左孩子不为空，在当前节点的左子树中找到当前节点在中序遍历下的前驱节点。
 * a) 如果前驱节点的右孩子为空，将它的右孩子设置为当前节点。当前节点更新为当前节点的左孩子。
 * b) 如果前驱节点的右孩子为当前节点，将它的右孩子重新设为空（恢复树的形状）。输出当前节点。当前节点更新为当前节点的右孩子。
 * 3. 重复以上1、2直到当前节点为空。
 */
public class RecoverBinarySearchTree2 {
	public void recoverTree(TreeNode root) {
		if (root == null)
			return;
		TreeNode f1 = null, f2 = null;
		TreeNode parent = null;
		boolean found = false;
		TreeNode cur = root, prev = null;
		while (cur != null) {
			if (cur.left == null) {
				// record f1 and f2
				if (parent != null && parent.val > cur.val) {
					if (!found) {
						f1 = parent;
						found = true;
					}
					f2 = cur;
				}
				parent = cur;
				cur = cur.right;
			} else {
				// find predecessor
				prev = cur.left;
				while (prev.right != null && prev.right != cur)
					prev = prev.right;
				if (prev.right == null) {
					prev.right = cur;
					cur = cur.left;
				} else {
					// record f1 and f2
					if (parent.val > cur.val) {
						if (!found) {
							f1 = parent;
							found = true;
						}
						f2 = cur;
					}
				}
			}
		}
		if (f1 != null && f2 != null) {
			int temp = f1.val;
			f1.val = f2.val;
			f2.val = temp;
		}
	}
}
