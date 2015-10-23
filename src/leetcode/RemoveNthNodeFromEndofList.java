package leetcode;

public class RemoveNthNodeFromEndofList {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode first = head;
		ListNode second = head;
		if (head.next == null)
			return null;
		while (n != 0) {
			first = first.next;
			n--;
		}
		if (first == null)
			return head.next;
		while (first.next != null) {
			first = first.next;
			second = second.next;
		}
		second.next = second.next.next;
		return head;
	}
}
