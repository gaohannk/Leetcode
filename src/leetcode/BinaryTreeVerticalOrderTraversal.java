package leetcode;

import java.util.ArrayList;
import java.util.HashMap;

/* Given a binary tree, print it vertically. The following example illustrates vertical order traversal.

           1
        /    \
       2      3
      / \    / \
     4   5  6   7
             \   \
              8   9

The output of print this tree vertically will be:
4
2
1 5 6
3 8
7
9
*/
/* 这里垂直访问的意思是，每一列给它一个列号，左孩子比父节点的列号减1，右孩子比父节点的加1.列号相同的打印在同一行。
 * 
 */
public class BinaryTreeVerticalOrderTraversal {

	public void printVerticalOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		int leftlen = 0;
		while (root != null) {
			root = root.left;
			leftlen++;
		}
		helper(list, root, 0, leftlen);
		for (int i = 0; i < list.size(); i++) {
			ArrayList<Integer> l = list.get(i);
			for (int j = 0; j < l.size(); j++) {
				System.out.print(l.get(j) + " ");
			}
			System.out.println();
		}
	}

	private void helper(ArrayList<ArrayList<Integer>> list, TreeNode root, int index, int leftlen) {
		if (root == null)
			return;
		if (list.get(index + leftlen) != null) {
			list.get(index + leftlen).add(root.val);
		} else {
			list.add(new ArrayList<>(root.val));
		}
		helper(list, root.left, index - 1, leftlen);
		helper(list, root.right, index + 1, leftlen);
	}

}
