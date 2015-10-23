package leetcode;

public class RemoveDuplicatesfromSortedListII3 {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode dummy = new ListNode(0);
		dummy.next = head;
		head = dummy;

		while (head.next != null && head.next.next != null) {
			if (head.next.val == head.next.next.val) {
				int val = head.next.val;
				while (head.next != null && head.next.val == val) {
					head.next = head.next.next;
				}
			} else {
				head = head.next;
			}
		}

		return dummy.next;
	}
}
