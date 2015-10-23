package leetcode;
/* Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * Follow up:
 * Can you solve it without using extra space?
 */
/* step 1: move fast and slow pointers as in Cycle I
 * step 2: move fast to the head and let the two pointers move at the same speed and they meet where the cycle starts
 */
public class LinkedListCycleII {
	public ListNode detectCycle(ListNode head) {
		ListNode fast = head, slow = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow)
				break;
		}
		//special case
		if (fast == null || fast.next == null) 
			return null;
	
		fast = head;
		while (fast != slow) {
			fast = fast.next;
			slow = slow.next;
		}
		return fast;
	}
}
