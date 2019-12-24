package leetcode.algo.c;

import leetcode.common.ListNode;

public class ConvertBinaryNumberinaLinkedListtoInteger {

    public int count = 0;

    public int getDecimalValue(ListNode head) {
        if (head.next == null) {
            count++;
            return head.val;
        } else {
            count++;
            return getDecimalValue(head.next) + head.val == 1 ? (int) Math.pow(2, count) : 0;
        }
    }
}
