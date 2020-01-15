package company.oracle.phone;

import leetcode.common.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergekSortedLists2 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode dummyRoot = new ListNode(-1);
        ListNode res = dummyRoot;
        Queue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }
        }
        while (!queue.isEmpty()) {
            ListNode cur = queue.poll();
            dummyRoot.next = cur;
            dummyRoot = dummyRoot.next;
            if (cur.next != null) {
                queue.offer(cur.next);
            }
        }
        return res.next;
    }
}
