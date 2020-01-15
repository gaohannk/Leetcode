package company.oracle.phone;

import leetcode.common.ListNode;

public class MiddleoftheLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode fast = head, slow = head;

        while(fast != null && fast.next != null ){
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }
}
