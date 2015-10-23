package leetcode;

/* Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * You should preserve the original relative order of the nodes in each of the two partitions.For example,
 * Given 1->4->3->2->5->2 and x = 3,
 * return 1->2->2->4->3->5.
 */
/* 创建两个链表，分别存比x小的链表和比x大的链表，最后将两个链表链接起来。
 */
public class PartitionList {
	public ListNode partition(ListNode head, int x) {
		ListNode head1 = new ListNode(0);
		ListNode head2 = new ListNode(0);
		ListNode p1 = head1;
		ListNode p2 = head2;
		while (head != null) {
			if (head.val < x) {
				p1.next = new ListNode(head.val);
				p1 = p1.next;
			} else {
				p2.next = new ListNode(head.val);
				p2 = p2.next;
			}
			head = head.next;
		}
		if (head2.next != null)
			p1.next = head2.next;
		return head1.next;
	}
}
