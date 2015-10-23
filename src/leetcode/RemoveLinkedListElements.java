package leetcode;
/* Remove all elements from a linked list of integers that have value val.
 * Example
 * Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
 * Return: 1 --> 2 --> 3 --> 4 --> 5
 */
public class RemoveLinkedListElements {
	   public ListNode removeElements(ListNode head, int val) {
	        ListNode dummy = new ListNode(0);
	        dummy.next=head;
	        ListNode newHead= dummy;
	        while(dummy!=null&&dummy.next!=null){
	            ListNode p=dummy.next;
	            while(p!=null&&p.val==val)
	                p=p.next;
	            dummy.next=p;
	            dummy=dummy.next;
	        }
	        return newHead.next;
	    }
}
