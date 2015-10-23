package leetcode;

import java.util.ArrayList;
import java.util.List;

public class MergekSortedLists5 {
	public ListNode mergeKLists(List<ListNode> lists) {
		/*
		 * CAUTION: use a loop to remove throws an error
		 * http://stackoverflow.com
		 * /questions/8189466/java-util-concurrentmodificationexception
		 */
		// if(lists.size() > 300) return null;

		for (int i = lists.size() - 1; i >= 0; i--) {
			if (lists.get(i) == null) {
				lists.remove(i);
			}
		}

		ListNode tail = null, list = null;
		while (!lists.isEmpty()) {
			ListNode p = lists.get(0);
			ArrayList<Integer> rm = new ArrayList<Integer>();
			for (int i = 0; i < lists.size(); i++) {
				ListNode node = lists.get(i);
				if (node.val < p.val) {
					p = node;
				}
			}

			for (int i = lists.size() - 1; i >= 0; i--) {
				if (lists.get(i).val == p.val) {
					rm.add(Integer.valueOf(i));
				}
			}

			for (int j = 0; j < rm.size(); j++) {
				int index = rm.get(j).intValue();
				ListNode q = lists.get(index);
				if (list == null) {
					list = q;
				} else {
					tail.next = q;
				}
				tail = q;
				q = q.next;
				if (q == null) {
					lists.remove(index);
				} else {
					lists.remove(index);
					lists.add(q);
				}
			}

		}
		return list;
	}
}
