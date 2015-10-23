package leetcode;

/* Merge two sorted linked lists and return it as a new list. 
 * The new list should be made by splicing together the nodes of the first two lists.
 */
/* recursion solution
 */
public class MergeTwoSortedLists2 {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null)
			return null;
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;

		ListNode p = new ListNode(0);
		if (l1.val < l2.val) {
			p.next = l1;
			l1.next = mergeTwoLists(l1.next, l2);
		} else {
			p.next = l2;
			l2.next = mergeTwoLists(l1, l2.next);
		}
		return p.next;
	}
}
