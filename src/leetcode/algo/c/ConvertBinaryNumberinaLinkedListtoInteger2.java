package leetcode.algo.c;

import leetcode.common.ListNode;

public class ConvertBinaryNumberinaLinkedListtoInteger2 {
    public int getDecimalValue(ListNode head) {
        ListNode curr = head;
        int result = 0;
        while (curr != null) {
            result *= 2;
            if (curr.val == 1)
                result++;
            curr = curr.next;
        }
        return result;
    }
}
