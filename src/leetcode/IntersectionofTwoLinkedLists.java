package leetcode;
/* Write a program to find the node at which the intersection of two singly linked lists begins.
 * For example, the following two linked lists:
 * A:       a1 → a2
 *                 ↘
 *                  c1 → c2 → c3
 *                ↗            
 * B: b1 → b2 → b3
 * begin to intersect at node c1.
 * Notes:
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 */
/* Connect the end of A with the head of B
 * Find the begining of the circle
 */
public class IntersectionofTwoLinkedLists {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null)
			return null;
		ListNode tempA = headA;
		while (tempA.next != null) {
			tempA = tempA.next;
		}
		tempA.next = headB;
		ListNode fast = headA;
		ListNode slow = headA;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow)
				break;
		}

		if (fast == null || fast.next == null) {
			tempA.next = null;   // recover original structure
			return null;
		}
		ListNode start = headA;
		while (start != fast) {
			fast = fast.next;
			start = start.next;
		}
		tempA.next = null;      // recover original structure
		return fast;
	}
}
