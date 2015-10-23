package leetcode;

public class RemoveLinkedListElements2 {
	 public ListNode removeElements(ListNode head, int val) {
	        if (head == null) return null;
	        head.next = removeElements(head.next, val);
	        return head.val == val ? head.next : head;
	}
}
