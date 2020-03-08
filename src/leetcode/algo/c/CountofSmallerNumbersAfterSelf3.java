package leetcode.algo.c;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * You are given an integer array nums and you have to return a new counts array. The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].
 *
 * Example:
 *
 * Input: [5,2,6,1]
 * Output: [2,1,1,0]
 * Explanation:
 * To the right of 5 there are 2 smaller elements (2 and 1).
 * To the right of 2 there is only 1 smaller element (1).
 * To the right of 6 there is 1 smaller element (1).
 * To the right of 1 there is 0 smaller element.
 */
public class CountofSmallerNumbersAfterSelf3 {
    private class Node {
        int val;
        Node left;
        Node right;
        int lSize;
        int rSize;

        Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    private Node insert(Node node, int val, int[] lesserCount) {
        if (node == null) {
            return new Node(val, null, null); // leaf
        }
        if (val <= node.val) {
            node.lSize++;
            node.left = insert(node.left, val, lesserCount);
        } else {
            lesserCount[0] += node.lSize + 1;
            node.rSize++;
            node.right = insert(node.right, val, lesserCount);
        }
        return node;
    }

    public List<Integer> countSmaller(int[] nums) {

        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        int[] ans = new int[1]; // pass by reference
        Node root = new Node(nums[nums.length - 1], null, null);
        res.add(0);
        for (int i = nums.length - 1; i >= 0; i--) {
            ans[0] = 0;
            root = insert(root, nums[i], ans);
            res.add(ans[0]);
        }
        Collections.reverse(res);
        return res;
    }
}
