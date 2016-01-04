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
public final class KthSmallestElementinaBST2 {
	int idx = 0;
	int kthvalue = 0;

	public int kthSmallest(TreeNode root, int k) {
		TreeNode knode = new TreeNode(0);
		helper(root, k, knode);
		return kthvalue;
	}

	public void helper(TreeNode root, int k, TreeNode knode) {
		if (root != null) {
			helper(root.left, k, knode);
			idx++;
			if (idx == k) {
				kthvalue = root.val;
				return;
			}
			helper(root.right, k, knode);
		}
	}
}
