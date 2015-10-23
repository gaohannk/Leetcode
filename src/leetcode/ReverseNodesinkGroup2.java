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
/* keep 3个pointer：
 * prevStart：要reverse的section的前一个节点
 * start：section第一个
 * end：section最后一个
 * 然后就每次reverse好了section，和prevStart连上就行了，然后prevStart 越过k个，接着做。
 */
public class ReverseNodesinkGroup2 {
	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode prevStart = dummy;
		while (prevStart != null) {
			ListNode start = prevStart.next;
			ListNode end = prevStart;
			for (int i = 0; i < k; i++) {
				end = end.next;
				if (end == null)
					return dummy.next;
			}
			prevStart.next = reverse(start, end);
			for (int i = 0; i < k; i++) {
				prevStart = prevStart.next;
			}
		}
		return dummy.next;
	}

	private ListNode reverse(ListNode start, ListNode end) {
		ListNode prev = start;
		ListNode curr = start.next;// want to make curr point to prev
		ListNode afterEnd = end.next;
		while (curr != afterEnd) {
			ListNode next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		start.next = afterEnd;
		return end;
	}
}
