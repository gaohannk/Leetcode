package company.offerup.phone;

import leetcode.common.ListNode;

import java.util.HashSet;
import java.util.Set;

public class IntersectionofTwoLinkedLists2 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        ListNode tempA = headA;
        while (tempA.next != null) {
            tempA = tempA.next;
        }
        tempA.next = headB;
        ListNode fast = headA, slow = headA;

        if (fast == null || fast.next == null) {
            tempA.next = null;   // recover original structure
            return null;
        }
        while (fast != slow) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                ListNode start = headA;
                while (start != fast) {
                    fast = fast.next;
                    start = start.next;
                }
                tempA.next = null;      // recover original structure
                return fast;
            }
        }
        return null;
    }
}
