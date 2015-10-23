package leetcode;

/* Given a sorted linked list, delete all duplicates such that each element appear only once.
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 */
public class RemoveDuplicatesfromSortedList2 {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode p = head;
		while (p != null && p.next != null) {
			if (p.val == p.next.val) {
				p.next = p.next.next;
			} else {
				p = p.next;
			}
		}

		return head;
	}
}
