package leetcode.algo.p;

import leetcode.common.ImmutableListNode;

public class PrintImmutableLinkedListinReverse {
    /**
     * // This is the ImmutableListNode's API interface.
     * // You should not implement it, or speculate about its implementation.
     * interface ImmutableListNode {
     * public void printValue(); // print the value of this node.
     * public ImmutableListNode getNext(); // return the next node.
     * };
     */

    public void printLinkedListInReverse(ImmutableListNode head) {
        if (head == null)
            return;
        else {
            printLinkedListInReverse(head.getNext());
            head.printValue();
        }
    }
}
