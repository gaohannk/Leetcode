package leetcode;

/* Given a linked list, swap every two adjacent nodes and return its head.
 * For example,Given 1->2->3->4, you should return the list as 2->1->4->3.
 * Your algorithm should use only constant space. You may not modify the 
 * values in the list, only nodes itself can be changed.
 */
public class SwapNodesInPairs4 {
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null)
			return head;
		// none recursive solution
		ListNode handler = head.next;

		ListNode p = head;
		// CAUTION: prev is a must
		ListNode prev = new ListNode(0);

		while (p != null && p.next != null) {
			prev.next = p.next;
			ListNode q = p.next;
			p.next = q.next;
			q.next = p;
			prev = p;
			p = p.next;
		}
		return handler;
	}
}
