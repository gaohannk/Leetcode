package leetcode;

/* Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST. 
 */
public class ConvertSortedListtoBinarySearchTree {
	static ListNode h;

	public TreeNode sortedListToBST(ListNode head) {
		if (head == null)
			return null;
		h = head;
		int len = getLength(head);
		return sortedListToBST(0, len - 1);
	}

	// get list length
	public int getLength(ListNode head) {
		int len = 0;
		ListNode p = head;
		while (p != null) {
			len++;
			p = p.next;
		}
		return len;
	}

	// build tree bottom-up
	public TreeNode sortedListToBST(int start, int end) {
		if (start > end)
			return null;
		// mid
		int mid = (start + end) / 2;
		TreeNode left = sortedListToBST(start, mid - 1);
		TreeNode root = new TreeNode(h.val);
		h = h.next;
		TreeNode right = sortedListToBST(mid + 1, end);
		root.left = left;
		root.right = right;
		return root;
	}
}
