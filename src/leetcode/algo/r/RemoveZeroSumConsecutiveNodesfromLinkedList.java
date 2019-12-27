package leetcode.algo.r;

import leetcode.common.ListNode;

import java.util.Stack;

public class RemoveZeroSumConsecutiveNodesfromLinkedList {
    public ListNode removeZeroSumSublists(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        stack.add(head.val);
        while (head.next != null) {
            int val = head.val;
            if (val == 0) {
                head = head.next;
                continue;
            }
            Stack<Integer> temp = new Stack<>();
            int sum = val;
            boolean flag = false;
            while (!stack.isEmpty()) {
                sum += stack.peek();
                if (sum == 0) {
                    stack.pop();
                    temp.clear();
                    head = head.next;
                    flag = true;
                    break;
                } else {
                    temp.add(stack.pop());
                }
            }
            if (!flag) {
                while (!temp.isEmpty()) {
                    stack.push(temp.pop());
                }
                stack.push(val);
                head = head.next;
            }
        }
        Stack<Integer> temp = new Stack<>();
        while (!stack.isEmpty()) {
            temp.push(stack.pop());
        }
        ListNode res = new ListNode(0);
        ListNode iter = res;
        while (!temp.isEmpty()) {
            iter.next = new ListNode(temp.pop());
            iter = iter.next;
        }
        return res.next;
    }
}
