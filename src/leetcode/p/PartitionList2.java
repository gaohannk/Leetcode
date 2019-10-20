package leetcode.p;

import leetcode.l.ListNode;

/* Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * You should preserve the original relative order of the nodes in each of the two partitions.For example,
 * Given 1->4->3->2->5->2 and x = 3,
 * return 1->2->2->4->3->5.
 */
public class PartitionList2 {
	public ListNode partition(ListNode head, int x) {
		ListNode head1 = new ListNode(0);
		ListNode head2 = new ListNode(0);
		ListNode p1 = head1;
		ListNode p2 = head2;
		while (head != null) {
			if (head.val < x) {
				p1.next = head;
				p1 = p1.next;
			} else {
				p2.next = head;
				p2 = p2.next;
			}
			head.next = null;
	
		}
		    p2.next=null;
			p1.next = head2.next;
		return head1.next;
	}
}
