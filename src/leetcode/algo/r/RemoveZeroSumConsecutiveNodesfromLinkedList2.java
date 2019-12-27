package leetcode.algo.r;

import leetcode.common.ListNode;

import java.util.HashMap;
import java.util.Map;

public class RemoveZeroSumConsecutiveNodesfromLinkedList2 {
    public ListNode removeZeroSumSublists(ListNode head) {
        /*
         The observation here is that the sum from index 0 to index M will be
         equal to sum from index 0 to index N if sum from index (M+1) to index N is 0.
         Thus, here we track the sum from index 0 to each index, using a Map to indicate
         the farthest index N that we can remove from index M, then we shall be able to
         remove M+1 -> N and continue from N+1. This works since we don't have to optimize
         for the number of sequences to be removed
         Map from sum from index 0 to the farthest value that the sum stays unchanged.
        */

        Map<Integer, ListNode> sumToFarthestNodeMap = new HashMap<>();

        // Need the dummy node to track the new head if changed.
        ListNode preHead = new ListNode(0);
        preHead.next = head;

        // First iteration to compute the map.
        int sum = 0;
        for (ListNode p = preHead; p != null; p = p.next) {
            sum += p.val;
            sumToFarthestNodeMap.put(sum, p);
        }

        // Second iteration to re-connect the nodes to the farthest node where the sum stays unchanged
        sum = 0;
        for (ListNode p = preHead; p != null; p = p.next) {
            sum += p.val;
            p.next = sumToFarthestNodeMap.get(sum).next;
        }

        // Done, return the head from preHead
        return preHead.next;
    }
}
