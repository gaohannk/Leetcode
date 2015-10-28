package leetcode;

/*
 * Given a singly linked list, determine if it is a palindrome.
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 */
public class PalindromeLinkedList {
	public boolean isPalindrome(ListNode head) {
		if (head == null)
			return true;
		ListNode p = head;
		ListNode q = head;
		int count = 0;

		while (q.next != null && q.next.next != null) {
			p = p.next;
			q = q.next.next;
			count++;
		}
		if (q.next != null)
			p = p.next;
		int right[] = new int[count + 1];
		int i = 0;
		while (p != null) {
			right[i] = p.val;
			p = p.next;
			i++;
		}
		while (count >= 0) {
			if (head.val != right[count])
				return false;
			count--;
			head = head.next;
		}
		return true;
	}
}
