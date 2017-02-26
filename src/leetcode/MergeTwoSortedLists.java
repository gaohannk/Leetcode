package leetcode;

/* Merge two sorted linked lists and return it as a new list. 
 * The new list should be made by splicing together the nodes of the first two lists.
 */
/* 1 The key to solve the problem is defining a fake head. Then compare the first elements from each list. 
 * 2 Add the smaller one to the merged list. 
 * 3 Finally, when one of them is empty, simply append it to the merged list, since it is already sorted.
 */
public class MergeTwoSortedLists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null)
			return null;
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;

		ListNode newhead = new ListNode(0);
		ListNode cur = newhead;
		while (l1 != null && l2 != null) {
			if (l1.val > l2.val) {
				cur.next = l2;
				l2 = l2.next;
			} else {
				cur.next = l1;
				l1 = l1.next;
			}
			cur = cur.next;
		}
		if (l1 == null)
			cur.next = l2;
		else
			cur.next = l1;
		return newhead.next;
	}
}