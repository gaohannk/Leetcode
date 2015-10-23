package leetcode;
/* Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 * For example,
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3.
 */
/* recursion solution
 * In every sub problem, we just find the head of the linked list.
 */
public class RemoveDuplicatesfromSortedListII2 {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null)
			return null;
		// 1. find the beginning of the returned list
		ListNode p = head, q = head.next;
		while (q != null && p.val == q.val) 
			q = q.next;

		if (p.next == q) {
			head = p;
		} else {
			head = q;
		}

		// 2. manipulate the new head
		if (head == null)
			return head;
		// CAUTION: head == p and head == q are two different cases
		else if (head == p) {
			p.next = deleteDuplicates(q);
			return p;
		} else {// head == q
			return deleteDuplicates(q);
		}
	}
}
