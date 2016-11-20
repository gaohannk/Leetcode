package leetcode;

import java.util.Stack;

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> s1 = new Stack<>();
        Stack<ListNode> s2 = new Stack<>();
        Stack<ListNode> s3 = new Stack<>();

        while (l1 != null) {
            s1.push(l1);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2);
            l2 = l2.next;
        }

        int carry = 0;
        while (!s1.isEmpty() || !s2.isEmpty()) {
            int val1 = s1.isEmpty() ? 0 : s1.pop().val;
            int val2 = s2.isEmpty() ? 0 : s2.pop().val;

            int val = val1 + val2 + carry;
            ListNode node = new ListNode(val % 10);
            carry = val / 10;
            s3.push(node);
        }
        if (carry == 1)
            s3.push(new ListNode(1));
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        while (!s3.isEmpty()) {
            node.next = s3.pop();
            node = node.next;
        }

        return dummy.next;
    }
}
