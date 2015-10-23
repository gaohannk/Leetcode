package leetcode;

/* A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 * Return a deep copy of the list.
 */
/* _________
 * |       |
 * A-->B-->C-->D-->E
 *             |   |
 *             ----- 
 * original.next = copy;
 * ---------   -----
 * |       |   |   |
 * A   B   C   D   E
 * | / | / | / | / |
 * A'  B'  C'  D'  E'
 * copy.random = original.random.next; 
 * ---------   -----
 * |       |   |   |
 * A   B   C   D   E
 * | / | / | / | / |
 * A'  B'  C'  D'  E'
 * |       |   |   |
 * ---------   -----
 * original.next = original.next.next;
 * copy.next = copy.next.next;
 * ---------           --------
 * |       |           |       |
 * A-->B-->C-->D-->E   A'->B'->C'->D'->E'
 *             |   |               |   |
 *             -----               ----- 
 */
public class CopyListwithRandomPointer {
	public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null)
			return null;

		// step 1: copy the next pointers
		RandomListNode p = head;
		while (p != null) {
			RandomListNode q = p.next;
			RandomListNode copy = new RandomListNode(p.label);
			p.next = copy;
			copy.next = q;
			p = q;
		}

		p = head;
		// step 2: copy the random pointers
		while (p != null) {
			RandomListNode copy = p.next;// q is the new node
			copy.random = p.random == null ? null : p.random.next;
			p = p.next.next;
		}

		// step 3: separate the new list and the old list
		RandomListNode copy = head.next;
		p = head;
		while (p != null) {
			RandomListNode q = p.next;
			p.next = q.next;
			if (q.next != null) {
				q.next = q.next.next;
			}
			p = p.next;
		}
		return copy;
	}
}
