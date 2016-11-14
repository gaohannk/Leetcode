package leetcode;

import java.util.List;

/**
 * You are given two linked lists representing two non-negative numbers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Follow up:
 * What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
 * <p>
 * Example:
 * <p>
 * Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 8 -> 0 -> 7
 */
public class AddTwoNumbersII {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode r1 = reverseList(l1);
        ListNode r2 = reverseList(l2);
        print(r1);
        print(r2);
        ListNode res = new ListNode(0);
        ListNode head =res;
        int count = 0;
        while (r1 != null || r2 != null) {
            int val = r1.val + r2.val + count;
            if (val >= 10) {
                val -= 10;
                count = 1;
            }
            res.next = new ListNode(val);
            res = res.next;
            r1 = r1.next;
            r2 = r2.next;
        }
        while (r1 != null) {
            int val = r1.val + count;
            if (val >= 10) {
                val -= 10;
                count = 1;
            }
            res.next = new ListNode(val);
            res = res.next;
            r1 = r1.next;
        }
        while (r2 != null) {
            int val = r2.val + count;
            if (val >= 10) {
                val -= 10;
                count = 1;
            }
            res.next = new ListNode(val);
            res = res.next;
            r2 = r2.next;
        }
        if (count == 1)
            res = new ListNode(1);
        return reverseList(head.next);
    }

    private static int getSize(ListNode head) {
        ListNode cur =head;
        int count = 0;
        while (cur != null) {
            cur = cur.next;
            count++;
        }
        return count;
    }

    private static ListNode reverseList(ListNode head) {
        if (head == null)
            return head;
        ListNode iter = head;
        ListNode front = head.next;
        while (front != null) {
            ListNode temp = front.next;
            front.next = iter;
            iter = front;
            front = temp;
        }
        return iter;
    }

    public static void print(ListNode head){
        ListNode cur =head;
        while (cur != null) {
            cur = cur.next;
            System.out.print(cur.val+",");
        }
    }

    public static  void main(String[] args){
        ListNode l1 = new ListNode(7);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        System.out.print(addTwoNumbers(l1,l2));
    }

}
