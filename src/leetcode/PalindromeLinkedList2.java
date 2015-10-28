package leetcode;

public class PalindromeLinkedList2 {
	public boolean isPalindrome(ListNode head) {
		if (head == null)
			return true;
		ListNode p = head;
		int count = 0;
		while (p != null) {
			count++;
			p = p.next;
		}
		int nums[] = new int[count];
		p = head;
		int i = 0;
		while (p != null) {
			nums[i++] = p.val;
		}
		for (int j = 0; j < count; j++) {
			if (nums[j] != nums[count - j - 1])
				return false;
		}
		return true;
	}
}
