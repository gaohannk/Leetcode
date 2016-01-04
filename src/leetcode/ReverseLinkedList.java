package leetcode;

/* Reverse a singly linked list.
 */
public class ReverseLinkedList {

	public ListNode reverseList(ListNode head) {
		if (head == null)
			return head;
		ListNode p = head;
		ListNode curr = head.next;
		head.next = null;
		while (curr != null) {
			ListNode next = curr.next;
			curr.next = p;
			p = curr;
			curr = next;
		}
		return p;
	}
}
