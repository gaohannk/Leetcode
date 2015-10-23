package leetcode;

/* Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * For example:
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * return 1->4->3->2->5->NULL.
 * Note:
 * Given m, n satisfy the following condition:
 * 1 ≤ m ≤ n ≤ length of list.
 */
/* 比如反转b->c->d：a->b->c->d->e => a->d->c->b->e
 * 三个variable
 * prevM：指向反转部分的前一个元素。
 * prev：指向已经反转成功的最后一个元素，反转前的第一个元素prevM.next，不需要改动。
 * curr：指向要插入prevM后面的那个元素。
 * 算法：每次拿出右边的新元素，往prevM后面插，最后curr==不需要反转的section的第一个节点时退出
 */
public class ReverseLinkedListII {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode prevM = dummy, prev = dummy, curr = dummy;
		for (int i = 1; i <= n; i++) {
			if (i < m) {
				prevM = prevM.next;
			} else if (i == m) {
				prev = prevM.next;
				curr = prev.next;
			} else {
				prev.next = curr.next;
				curr.next = prevM.next;
				prevM.next = curr;
				curr = prev.next;
			}
		}
		return dummy.next;
	}
}
