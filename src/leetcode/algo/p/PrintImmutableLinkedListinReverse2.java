package leetcode.algo.p;

import leetcode.common.ImmutableListNode;

import java.util.Stack;

public class PrintImmutableLinkedListinReverse2 {
    /**
     * // This is the ImmutableListNode's API interface.
     * // You should not implement it, or speculate about its implementation.
     * interface ImmutableListNode {
     *     public void printValue(); // print the value of this node.
     *     public ImmutableListNode getNext(); // return the next node.
     * };
     */

    public void printLinkedListInReverse(ImmutableListNode head) {
        Stack<ImmutableListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.getNext();
        }
        while (!stack.isEmpty()) {
            stack.pop().printValue();
        }
    }
}
