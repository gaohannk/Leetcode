package leetcode.algo.r;

import leetcode.common.ListNode;

import java.util.LinkedList;
//TLE
public class RemoveZeroSumConsecutiveNodesfromLinkedList {
    public ListNode removeZeroSumSublists(ListNode head) {
        LinkedList<Integer> list = new LinkedList<>();
        while (head != null) {
            if(head.val!=0) {
                list.add(head.val);
            }
            head = head.next;
        }


        while (true) {
            int maxLen = -1;
            boolean flag = false;
            int left = -1, right =-1;
            for (int i = 0; i < list.size(); i++) {
                int sum = 0;
                for (int j = i; j < list.size(); j++) {
                    sum += list.get(j);
                    if (sum == 0 && j - i > maxLen) {
                        flag = true;
                        left = i;
                        right = j;
                        maxLen = right - left;

                    }
                }
            }
            if (flag) {
                int len = right - left + 1;
                while (len > 1) {
                    len--;
                    list.remove(left);
                }
            } else {
                break;
            }
        }
        ListNode newHead = new ListNode(0);
        ListNode iter = newHead;
        for (int val : list) {
            iter.next = new ListNode(val);
            iter = iter.next;
        }
        return newHead.next;
    }
}
