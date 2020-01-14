package company.oracle;

import leetcode.common.ListNode;

public class MergekSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummyRoot = new ListNode(-1);
        ListNode res = dummyRoot;
        while (true) {
            boolean flag = false;
            int minIndex = -1;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] == null)
                    continue;
                if (lists[i].val < min) {
                    min = lists[i].val;
                    dummyRoot.next = lists[i];
                    minIndex = i;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
            dummyRoot = dummyRoot.next;
            lists[minIndex] = lists[minIndex].next;
        }
        return res.next;
    }
}
