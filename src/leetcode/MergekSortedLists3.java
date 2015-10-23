package leetcode;

import java.util.ArrayList;

/* Merge k sorted linked lists and return it as one sorted list.
 */
public class MergekSortedLists3 {
	//TLE
	public ListNode mergeKLists(ArrayList<ListNode> lists) {
		if (lists == null || lists.size() == 0)
			return null;
		if (lists.size() == 1)
			return lists.get(0);
		int min = 0;
		int count = 0;
		ListNode head = new ListNode(0);
		ListNode curr = new ListNode(0);
		while (count != lists.size()) {
			count=0;
			int index=0;
			for (int i=0;i<lists.size();i++) {
				ListNode node= lists.get(index);
				if (node != null && min > node.val) {
					min = node.val;
					index=i;
					curr = node;
				}
			}
			head.next = new ListNode(min);
			lists.remove(index);
			lists.add(index,curr.next);
			for (ListNode node : lists) {
				if (node == null)
					count++;
				else
					break;
			}
		}
		return head.next;
	}
}
