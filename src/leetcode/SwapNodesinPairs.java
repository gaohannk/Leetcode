package leetcode;

/* Given a linked list, swap every two adjacent nodes and return its head.
 * For example,Given 1->2->3->4, you should return the list as 2->1->4->3.
 * Your algorithm should use only constant space. You may not modify the 
 * values in the list, only nodes itself can be changed.
 */
public class SwapNodesinPairs {
	public class Solution {
		public ListNode swapPairs(ListNode head) {
			if (head == null)
				return null;
			if (head.next == null)
				return head;
			ListNode cur = head;
			//head change with next is a special case, so we deal with it first
			ListNode temp = cur.next;
			cur.next = temp.next;
			temp.next = cur;
			head = temp;
			// handle other cases
			while (cur.next != null && cur.next.next != null) {
				swapNode(cur, cur.next, cur.next.next);
				cur = cur.next.next;
			}
			return head;
		}

		public void swapNode(ListNode cur, ListNode next1, ListNode next2) {
			cur.next = next2;
			next1.next = next2.next;
			next2.next = next1;
		}
	}
}
