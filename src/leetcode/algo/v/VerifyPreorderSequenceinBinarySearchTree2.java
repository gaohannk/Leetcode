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
// Constant O(1)
public class VerifyPreorderSequenceinBinarySearchTree2 {
    public boolean verifyPreorder(int[] preorder) {
        int low = Integer.MIN_VALUE, i = -1;
        for (int num : preorder) {
            if (num < low)
                return false;
            while (i >= 0 && num > preorder[i])
                low = preorder[i--];
            preorder[++i] = num;
        }
        return true;
    }
}
