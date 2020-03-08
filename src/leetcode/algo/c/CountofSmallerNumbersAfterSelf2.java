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
public class CountofSmallerNumbersAfterSelf2 {
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

    private class BST { // without optimisations of AVL rotations
        Node root;

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

        void insert(int val, int[] lesserCount) {
            root = insert(root, val, lesserCount);
        }

    }

    public List<Integer> countSmaller(int[] nums) {
        BST bst = new BST();
        List<Integer> res = new ArrayList<>();

        int[] ans = new int[1]; // pass by reference
        for (int i = nums.length - 1; i >= 0; i--) {
            ans[0] = 0;
            bst.insert(nums[i], ans);
            res.add(ans[0]);
        }
        Collections.reverse(res);
        return res;
    }
}
