package leetcode;

/*Merge k sorted linked lists and return it as one sorted list.
 */
import java.util.*;

import leetcode.ListNode;
//两个合并，合并k-1次， 递归
public class MergekSortedLists2 {
	public ListNode mergeKLists(ArrayList<ListNode> lists) {
		if (lists == null || lists.size() == 0)
			return null;
		return helper(lists, 0, lists.size() - 1);
	}

	private ListNode helper(ArrayList<ListNode> lists, int l, int r) {
		if (l < r) {
			int m = (l + r) / 2;
			return mergeTwoLists(helper(lists, l, m), helper(lists, m + 1, r));
		}
		return lists.get(l);
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
