package leetcode;

import java.util.HashSet;

/* Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * Follow up:
 * Can you solve it without using extra space?
 */
/* step 1: move fast and slow pointers as in Cycle I
 * step 2: move fast to the head and let the two pointers move at the same speed and they meet where the cycle starts
 */
public class LinkedListCycleII2 {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) //check if the linklist is null or just 1 element
            return null;
        HashSet lookup = new HashSet<>();
        //add all nodes to the hashset and to find the first repeated node.
        while (head != null) {
            if (lookup.contains(head))
                return head;
            else
                lookup.add(head);
            head = head.next;
        }
        return null;
    }
}
