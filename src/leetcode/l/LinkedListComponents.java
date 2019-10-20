package leetcode.l;

import java.util.HashSet;
import java.util.Set;

/**
 * 817. Linked List Components
 */
public class LinkedListComponents {
    public int numComponents(ListNode head, int[] G) {
        Set<Integer> Gset = new HashSet();
        for (int x : G) {
            Gset.add(x);
        }

        ListNode cur = head;
        int ans = 0;

        while (cur != null) {
            if (Gset.contains(cur.val) &&
                    (cur.next == null || !Gset.contains(cur.next.val)))
                ans++;
            cur = cur.next;
        }

        return ans;
    }
}
