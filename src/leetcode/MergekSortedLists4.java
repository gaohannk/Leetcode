package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
/* Merge k sorted linked lists and return it as one sorted list.
 */
/* use queue instead of recusion
 */
public class MergekSortedLists4 {
	public ListNode mergeKLists(ArrayList<ListNode> lists) {
		if (lists == null || lists.size() == 0)
			return null;
		Queue<ListNode> queue = new LinkedList<ListNode>();
		for (ListNode node : lists) 
			queue.add(node);
		while (queue.size() != 1) {
			ListNode h1=queue.poll();
			ListNode h2=queue.poll();
			queue.add(mergeTwoLists(h1,h2));
		}
		return queue.poll();
	}
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode newhead = new ListNode(0);
		ListNode p = newhead;
		while (l1 != null && l2 != null) {
			if (l1.val > l2.val) {
				p.next = l2;
				l2 = l2.next;
			} else {
				p.next = l1;
				l1 = l1.next;
			}
			p = p.next;
		}
		if (l1 == null)
			p.next = l2;
		else
			p.next = l1;
		return newhead.next;
	}
}