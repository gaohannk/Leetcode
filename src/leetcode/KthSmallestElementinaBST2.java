package leetcode;

import java.util.ArrayList;

/* Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 * Note: 
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 * Follow up:
 * What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?
 * Hint:
 * Try to utilize the property of a BST.
 * What if you could modify the BST node's structure?
 * The optimal runtime complexity is O(height of BST).
 */
// wrong answer need fix
public final class KthSmallestElementinaBST2 {
	public int kthSmallest(TreeNode root, int k) {
		int res = 0;
		TreeNode knode = new TreeNode(0);
		helper(root, res, k, knode);
		return knode.val;
	}

	public int helper(TreeNode root, int res, int k, TreeNode knode) {
		if (root != null) {
			res = helper(root.left, res, k, knode);
			res++;
			if (res == k){
				knode = root;
				return res;
			}
			res = helper(root.right, res, k, knode);
		}
		return res;
	}
}
