package leetcode;

import java.util.Arrays;

/* Given inorder and postorder traversal of a tree, construct the binary tree.
 * Note:
 * You may assume that duplicates do not exist in the tree.
 */
/*Algorithm: buildTree()
 1) Pick an element from Preorder. Increment a Preorder Index Variable (preIndex in below code) to pick next element in next recursive call.
 2) Create a new tree node tNode with the data as picked element.
 3) Find the picked element’s index in Inorder. Let the index be inIndex.
 4) Call buildTree for elements before inIndex and make the built tree as left subtree of tNode.
 5) Call buildTree for elements after inIndex and make the built tree as right subtree of tNode.
 6) return tNode.
 */
public class ConstructBinaryTreefromInorderandPostorderTraversal {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if (inorder.length == 0 && postorder.length == 0)
			return null;
		int index = 0;
		for (int i = 0; i < inorder.length; i++) {
			if (inorder[i] == postorder[postorder.length - 1]) {
				index = i;
				break;
			}
		}
		TreeNode root = new TreeNode(inorder[index]);
		int[] inorder1 = Arrays.copyOfRange(inorder, 0, index);
		int[] inorder2 = Arrays.copyOfRange(inorder, index + 1, inorder.length);
		int[] postorder1 = Arrays.copyOfRange(postorder, 0, index);
		int[] postorder2 = Arrays.copyOfRange(postorder, index, inorder.length - 1);
		root.left = buildTree(inorder1, postorder1);
		root.right = buildTree(inorder2, postorder2);
		return root;
	}
}
