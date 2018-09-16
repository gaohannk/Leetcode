package leetcode;

/**
 * Created by gaohan on 7/30/18.
 */
public class OddEvenLinkedList3 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null)
            return null;
        ListNode odd = head, even = head.next, evenHead = even;
        while (even != null && even.next != null) {
            odd.next= even.next;
            even.next = odd.next.next;
            even = odd.next.next;
            odd = odd.next;
            even = odd.next;
        }
        odd.next = evenHead;
        return head;
    }
}
