package leetcode;

/* Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 * For example,
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3.
 */
/* iterative solution
 * we use a helper header to handle the case like 1-1-1-2-3
 */
public class RemoveDuplicatesfromSortedListII {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null)
			return head;
		ListNode helper = new ListNode(0);
		helper.next = head;
		ListNode pre = helper;
		ListNode cur = head;
		while (cur != null) {
			while (cur.next != null && pre.next.val == cur.next.val) 
				cur = cur.next;
			if (pre.next == cur) {
				pre = pre.next;
			} else {
				pre.next = cur.next;
			}
			cur = cur.next;
		}
		return helper.next;
	}
}


