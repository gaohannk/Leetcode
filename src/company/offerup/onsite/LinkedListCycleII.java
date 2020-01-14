package company.offerup.onsite;
/* Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * Follow up:
 * Can you solve it without using extra space?
 */
/* step 1: move fast and slow pointers as in Cycle I
 * step 2: move fast to the head and let the two pointers move at the same speed and they meet where the cycle starts
 */

import leetcode.common.ListNode;

/**
 * Cycle = length of the cycle, if exists.
 * C is the beginning of Cycle, S is the distance of slow pointer from C when slow pointer meets fast pointer.
 * <p>
 * Distance(slow) = C + S, Distance(fast) = 2 * Distance(slow) = 2 * (C + S). To let slow pointer meets fast pointer, only if fast pointer run 1 cycle more than slow pointer. Distance(fast) - Distance(slow) = Cycle
 * => 2 * (C + S) - (C + S)	= Cycle
 * =>	C + S = Cycle
 * =>	C = Cycle - S
 * => This means if slow pointer runs (Cycle - S) more, it will reaches C. So at this time, if there's another point2 running from head
 * => After C distance, point2 will meet slow pointer at C, where is the beginning of the cycle.
 */
public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        //special case
        if (fast == null || fast.next == null)
            return null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                while (head != slow) {
                    head = head.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }
}
