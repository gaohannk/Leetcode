package leetcode;

/* Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * You may not alter the values in the nodes, only nods itself may be changed.
 * Only constant memory is allowed.
 * For example:
 * Given this linked list: 1->2->3->4->5
 * For k = 2, you should return: 2->1->4->3->5
 * For k = 3, you should return: 3->2->1->4->5
 */
public class ReverseNodesinkGroup3 {
	public ListNode reverseKGroup(ListNode head, int k) {
		// recursive:
		if (k <= 1)
			return head;

		ListNode p = head;
		for (int i = 1; i < k && p != null; i++)
			// go (k-1) steps
			p = p.next;
		if (p == null)
			return head;

		// CAUTION: think of how to invert a linked list
		ListNode q = head;
		while (q != p) {
			ListNode next = p.next, qnext = q.next;
			p.next = q;
			q.next = next;
			q = qnext;
		}
		head.next = reverseKGroup(head.next, k);
		return p;
	}
}
