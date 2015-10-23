package leetcode;

/* Sort a linked list in O(n log n) time using constant space complexity.
 */
/* mergesort
 */
public class SortList {
	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		// why do we need prev? we need to cut off the Linked list in the middle
		ListNode fast = head, slow = head;
		ListNode prev = head;

		// step 1. divide
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			prev = slow;
			slow = slow.next;
		}
		prev.next = null;
		// step 2: recursion
		ListNode left = sortList(head);
		ListNode right = sortList(slow);
		// step 3: merge
		ListNode handler = null;
		if (left.val > right.val) {
			handler = right;
			right = right.next;
		} else {
			handler = left;
			left = left.next;
		}

		ListNode tail = handler;

		while (right != null && left != null) {
			if (right.val < left.val) {
				tail.next = right;
				tail = right;
				right = right.next;
			} else {
				tail.next = left;
				tail = left;
				left = left.next;
			}
		}

		if (left == null)
			tail.next = left;
		else
			tail.next = right;
		return handler;
	}
}
