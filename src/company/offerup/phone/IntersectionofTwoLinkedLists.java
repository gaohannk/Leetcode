package company.offerup.phone;

import leetcode.common.ListNode;

import java.util.HashSet;
import java.util.Set;

public class IntersectionofTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> map = new HashSet<>();
        ListNode cur = headA;
        while (cur != null) {
            map.add(cur);
            cur = cur.next;
        }

        cur = headB;
        while (cur != null) {
            if (map.contains(cur)) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }
}
