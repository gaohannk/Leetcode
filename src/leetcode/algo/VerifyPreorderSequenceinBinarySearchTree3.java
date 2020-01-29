package leetcode.algo;

import leetcode.common.TreeNode;

import java.util.Arrays;
import java.util.HashMap;

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
public class VerifyPreorderSequenceinBinarySearchTree3 {
    int[] preorder, inorder;
    int preidx;
    boolean rlt;
    HashMap<Integer, Integer> map = new HashMap<>();

    public boolean verifyPreorder(int[] preorder) {
        inorder = preorder.clone();
        Arrays.sort(inorder);
        preidx = 0;
        rlt = true;
        int idx = 0;
        for (Integer i : inorder) {
            map.put(i, idx++);
        }

        helper(0, inorder.length);
        return rlt;
    }

    public TreeNode helper(int start, int end) {
        if (start >= end) return null;
        if (preidx >= preorder.length) {
            rlt = false;
            return null;
        }
        //System.out.println(preidx);
        int val = preorder[preidx++];
        //System.out.println(val);
        TreeNode root = new TreeNode(val);
        int mid = map.get(val);

        root.left = helper(start, mid);
        root.right = helper(mid + 1, end);
        //rlt=rlt&&(root.left==null||root.left.val<root.val)&&(root.right==null||root.right.val>root.val);
        return root;
    }
}
