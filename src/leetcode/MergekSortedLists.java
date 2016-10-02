package leetcode;

import java.util.*;

/* Merge k sorted linked lists and return it as one sorted list.
 */
// 两个合并，合并k-1次
public class MergekSortedLists {

	public ListNode mergeKLists(ArrayList<ListNode> lists) {
		ListNode result = new ListNode(0);
		if (lists == null || lists.size() == 0)
			return null;
		if (lists.size() == 1)
			return lists.get(0);
		result = mergeTwoLists(lists.get(0), lists.get(1));
		for (int i = 2; i < lists.size(); i++) {
			result = mergeTwoLists(result, lists.get(i));
		}
		return result;
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