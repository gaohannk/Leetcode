package leetcode;

import java.util.Iterator;
import java.util.Stack;

/* Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
 * Calling next() will return the next smallest number in the BST.
 * Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 */
public class BinarySearchTreeIterator implements Iterator<Integer> {
	public Stack<TreeNode> stack = new Stack<TreeNode>();

	public BinarySearchTreeIterator(TreeNode root) {
		pushAll(root);
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return !stack.isEmpty();
	}

	/** @return the next smallest number */
	public Integer next() {
		TreeNode temp = stack.pop();
		pushAll(temp.right);
		return temp.val;
	}

	public void pushAll(TreeNode root) {
		while (root != null) {
			stack.push(root);
			root = root.left;
		}
	}
}
