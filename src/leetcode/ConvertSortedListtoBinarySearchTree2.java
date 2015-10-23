package leetcode;

/* Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST. 
 */
public class ConvertSortedListtoBinarySearchTree2 {
	public TreeNode sortedListToBST(ListNode head) {
		if (head == null)
			return null;
		int len = getLength(head);
		return sortedListToBST(head, 0, len - 1);
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
	public TreeNode sortedListToBST(ListNode head, int start, int end) {
		if (start > end)
			return null;
		// mid
		int mid = (start + end) / 2;
		ListNode p = head;
		@SuppressWarnings("unused")
		ListNode prev = head,fast=head;
		while (fast!=null&&fast.next!=null) {
			prev = p;
			fast=fast.next.next;
			p = p.next;
		}
		prev = null;
		TreeNode root = new TreeNode(p.val);
		TreeNode left = sortedListToBST(head, start, mid - 1);
		TreeNode right = sortedListToBST(p.next, mid + 1, end);
		root.left = left;
		root.right = right;
		return root;
	}
}
