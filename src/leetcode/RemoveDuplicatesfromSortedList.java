package leetcode;

/* Given a sorted linked list, delete all duplicates such that each element appear only once.
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 */
/* define two pointers prev and p; p is ahead of prev by 1; if prev.val == p.val, delete p
 */
public class RemoveDuplicatesfromSortedList {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode prev = head;
		ListNode p = head.next;
		while (p != null) {
			if (p.val == prev.val) {
				prev.next = p.next;
				p = p.next;
				// no change prev ####very important####
			} else {
				prev = p;
				p = p.next;
			}
		}
		return head;
	}
}
