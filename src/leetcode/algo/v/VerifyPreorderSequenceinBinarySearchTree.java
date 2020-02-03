package leetcode.algo.v;

import java.util.Stack;

/**
 * Given an array of numbers, verify whether it is the correct preorder traversal sequence of a binary search tree.
 *
 * You may assume each number in the sequence is unique.
 *
 * Consider the following binary search tree:
 *
 * 5
 * / \
 * 2   6
 * / \
 * 1   3
 * Example 1:
 *
 * Input: [5,2,6,1,3]
 * Output: false
 * Example 2:
 *
 * Input: [5,2,1,3,6]
 * Output: true
 * Follow up:
 * Could you do it using only constant space complexity?
 */

// Stack O(n)
public class VerifyPreorderSequenceinBinarySearchTree {
    public boolean verifyPreorder(int[] preorder) {
        if (preorder == null) return false;
        Stack<Integer> st = new Stack<>();
        int lowerBound = Integer.MIN_VALUE;

        for (int num : preorder) {
            if (num < lowerBound) return false;
            while (!st.isEmpty() && num > st.peek()) {
                lowerBound = st.pop();
            }
            st.push(num);
        }
        return true;
    }
}
