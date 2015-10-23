package leetcode;
/* Given a linked list, swap every two adjacent nodes and return its head.
 * For example,Given 1->2->3->4, you should return the list as 2->1->4->3.
 * Your algorithm should use only constant space. You may not modify the 
 * values in the list, only nodes itself can be changed.
 */
/* recursion solution
 */
public class SwapNodesInPairs3 {
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode p = head, q = head.next;
		p.next = swapPairs(q.next);
		head = q;
		q.next = p;
		return head;
	}
}
