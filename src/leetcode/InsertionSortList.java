package leetcode;

/* Sort a linked list using insertion sort.
 */
public class InsertionSortList {
	public ListNode insertionSortList(ListNode head) {
		if (head == null)
			return null;
		ListNode helper = new ListNode(0);
		ListNode pre = helper;
		ListNode cur = head;
		while (cur != null) {
			pre = helper;
			while (pre.next != null && pre.next.val <= cur.val) {
				pre = pre.next;
			}
			
			ListNode next = cur.next;
			cur.next = pre.next;
			pre.next = cur;
			cur = next;
		}
		return helper.next;
	}
}
