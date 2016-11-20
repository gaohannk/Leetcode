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
//stack
public class AddTwoNumbersII2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int count1 = count(l1);
        int count2 = count(l2);
        Stack<Integer> stack = new Stack<>();
        if (count1 > count2) {
            for (int i = 0; i < count1 - count2; i++) {
                stack.push(l1.val);
                l1 = l1.next;
            }
        } else {
            for (int i = 0; i < count2 - count1; i++) {
                stack.push(l2.val);
                l2 = l2.next;
            }
        }

        while (l1 != null) {
            stack.push(l1.val + l2.val);
            l1 = l1.next;
            l2 = l2.next;
        }
        int carry = 0;
        ListNode curr = null;
        while (!stack.isEmpty()) {
            int top = stack.pop();
            ListNode node = new ListNode((top + carry) % 10);
            carry = (top + carry) / 10;
            node.next = curr;
            curr = node;
        }
        if (carry > 0) {
            ListNode node = new ListNode(carry);
            node.next = curr;
            curr = node;
        }
        return curr;
    }

    private int count(ListNode head) {
        ListNode curr = head;
        int count = 0;
        while (curr != null) {
            count ++;
            curr = curr.next;
        }
        return count;
    }
}
