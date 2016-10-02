package leetcode;

/*Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.

You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

Example:
Given 1->2->3->4->5->NULL,
return 1->3->5->2->4->NULL.

Note:
The relative order inside both the even and odd groups should remain as it was in the input. 
The first node is considered odd, the second node even and so on ...
step 1:
1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> NULL,
pre       
cur----->cur
put 3 before 2
step 2;
1 -> 3 -> 2 -> 4 -> 5 -> 6 -> 7 -> 8 -> NULL,
	pre
	cur----------->cur
put 5 before 2
step 3:
1 -> 3 -> 5 -> 2 -> 4 -> 6 -> 7 -> 8 -> NULL,
		 pre
		 cur---------------->cur
put 7 before 2
1 -> 3 -> 5 -> 7 -> 2 -> 4 -> 6 -> 8 -> NULL,
			  pre
			  cur---------------------> cur
1 -> 3 -> 5 -> 7 -> 9 -> 2 -> 4 -> 6 -> 8 -> NULL,
				   pre
				   cur-------------------------------->cur
			
*/

public class OddEvenLinkedList {
	public static ListNode oddEvenList(ListNode head) {
		ListNode pre = head, reshead = head, dummy = head;
		ListNode cur = head;
		int step = 2, count = 0;
		while (dummy != null) {
			dummy = dummy.next;
			count++;
		}
//		System.out.println(count);
		count = (count - 1) / 2;
		while (count-- > 0) {
//			ListNode printhead = head;
//			while (printhead != null) {
//				System.out.print(printhead.val + ",");
//				printhead = printhead.next;
//			}
//			System.out.println();
			
			int temp = step;
			while (temp > 0 && cur.next != null) {
				cur = cur.next;
				temp--;
			}
			
			ListNode tmp = cur.next;
			cur.next = pre.next;
			pre.next = cur;
			ListNode front = cur;

			temp = step - 1;
			while (temp > 0) {
				front = front.next;
				temp--;
			}
			front.next = tmp;

			pre = cur;
			step++;

		}
		return reshead;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		int num = 0;
		ListNode newhead = head;
		for (int i = 2; i < num; i++) {
			head.next = new ListNode(i);
			head = head.next;
		}
		ListNode newhead2 = newhead;
		while (newhead != null) {
			System.out.print(newhead.val + ",");
			newhead = newhead.next;
		}
		System.out.println();
		ListNode res = oddEvenList(newhead2);
		while (res != null) {
			System.out.print(res.val + ",");
			res = res.next;
		}
	}
}
