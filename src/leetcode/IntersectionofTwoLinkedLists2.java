package leetcode;

import java.util.HashSet;

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
/* Hashset solution (O(n+m) running time, O(n) or O(m) memory):
 * Traverse list A and store the address / reference to each node in a hash set.
 * Then check every node bi in list B: if bi appears in the hash set, then bi is the intersection node.
 */
public class IntersectionofTwoLinkedLists2 {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if(headA==null||headB==null)
			return null;
		ListNode tempA=headA;
		ListNode tempB=headB;
		HashSet<ListNode> set= new HashSet<ListNode>();
		while(tempA!=null){
			set.add(tempA);
			tempA=tempA.next;
		}
		while(tempB!=null){
			if(set.contains(tempB))
				return tempB;
			tempB=tempB.next;
		}
		return null;
	}
}
