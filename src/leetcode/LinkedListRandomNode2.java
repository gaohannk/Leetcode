package leetcode;

import java.util.Random;

/*Given a singly linked list, return a random node's value from the linked list. Each node must have the same probability of being chosen.

Follow up:
What if the linked list is extremely large and its length is unknown to you? Could you solve this efficiently without using extra space?

Example:

// Init a singly linked list [1,2,3].
ListNode head = new ListNode(1);
head.next = new ListNode(2);
head.next.next = new ListNode(3);
Solution solution = new Solution(head);

// getRandom() should return either 1, 2, or 3 randomly. Each element should have equal probability of returning.
solution.getRandom();

*/
public class LinkedListRandomNode2 {
	public class Solution {

		/**
		 * @param head
		 *            The linked list's head. Note that the head is guanranteed
		 *            to be not null, so it contains at least one node.
		 */
		ListNode head = null;
		Random rand = null;

		public Solution(ListNode head) {
			this.head = head;
			this.rand = new Random();
		}

		/** Returns a random node's value. */
		public int getRandom() {
			ListNode result = null;
			ListNode current = head;

			for (int n = 1; current != null; n++) {
				if (rand.nextInt(n) == 0) 
					result = current;
				current = current.next;
			}
			return result.val;
		}
	}
}
