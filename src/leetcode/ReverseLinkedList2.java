package leetcode;

import java.util.LinkedList;

/* Reverse a singly linked list.
 */
/* recursive solution 
 * 
 */
public class ReverseLinkedList2 {

	public  ListNode reverseList(ListNode head) {
		if (head == null)
			return head;
		if(head.next==null)
		    return head;
		ListNode newHead = reverseList(head.next);
		head.next.next=head;
		head.next=null;
		return newHead;
	}
}
