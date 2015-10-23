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

public class ReverseNodesinKGroup {
	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null)
			return null;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode pre = dummy;
		ListNode cur = head;
		while (cur != null) {
			ListNode pilot = pre.next;
			int remaining = k;
			while (pilot != null && remaining > 0) {
				remaining--;
				pilot = pilot.next;
			}
			if (remaining > 0) 
				break;
			while (cur.next != pilot) {
				ListNode tmp = cur.next.next;
				cur.next.next = pre.next;
				pre.next = cur.next;
				cur.next = tmp;
			}
			pre = cur;
			cur = cur.next;
		}
		return dummy.next;
	}
}
