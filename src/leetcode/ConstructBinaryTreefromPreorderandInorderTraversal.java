package leetcode;

import java.util.Arrays;

/* Given preorder and inorder traversal of a tree, construct the binary tree.
 * Note:
 * You may assume that duplicates do not exist in the tree.
 */
public class ConstructBinaryTreefromPreorderandInorderTraversal {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder.length == 0 && inorder.length == 0)
			return null;
		int index = 0;
		for (int i = 0; i < inorder.length; i++) {
			if (inorder[i] == preorder[0]) {
				index = i;
				break;
			}
		}
		TreeNode root = new TreeNode(inorder[index]);
		int[] inorder1 = Arrays.copyOfRange(inorder, 0, index);
		int[] inorder2 = Arrays.copyOfRange(inorder, index + 1, inorder.length);
		int[] preorder1 = Arrays.copyOfRange(preorder, 1, index + 1);
		int[] preorder2 = Arrays.copyOfRange(preorder, index + 1, inorder.length);
		root.left = buildTree(preorder1, inorder1);
		root.right = buildTree(preorder2, inorder2);
		return root;
	}
}
