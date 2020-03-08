package leetcode.algo.l;

import leetcode.common.ListNode;
import leetcode.common.TreeNode;

/**
 * Given a binary tree root and a linked list with head as the first node.
 *
 * Return True if all the elements in the linked list starting from the head correspond to some downward path connected in the binary tree otherwise return False.
 *
 * In this context downward path means a path that starts at some node and goes downwards.
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: head = [4,2,8], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]
 * Output: true
 * Explanation: Nodes in blue form a subpath in the binary Tree.
 * Example 2:
 *
 *
 *
 * Input: head = [1,4,2,6], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]
 * Output: true
 * Example 3:
 *
 * Input: head = [1,4,2,6,8], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]
 * Output: false
 * Explanation: There is no path in the binary tree that contains all the elements of the linked list from head.
 *
 *
 * Constraints:
 *
 * 1 <= node.val <= 100 for each node in the linked list and binary tree.
 * The given linked list will contain between 1 and 100 nodes.
 * The given binary tree will contain between 1 and 2500 nodes.
 */
public class LinkedListinBinaryTree3 {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        if (n > m) {
            return -1;
        }
        if (n == 0) {
            return 0;
        }

        int[] lps = getLPS(needle);
        for (int i = 0; i < n; i++) {
            System.out.println(lps[i]);
        }

        int i = 0, j = 0;
        while (i < m) {
            System.out.println(i + "   " + j);
            if (haystack.charAt(i) == needle.charAt(j)) {
                if (j == n - 1) {
                    return i - n + 1;
                }
                i++;
                j++;
            } else if (j > 0) {
                j = lps[j-1];
            } else {
                i++;
            }
        }

        return -1;
    }

    private int[] getLPS(String needle) {
        int n = needle.length();
        char[] chars = needle.toCharArray();
        int[] res = new int[n];
        int i = 0, j = 1;
        while (j < n) {
            if (chars[i] == chars[j]) {
                res[j++] = ++i;
            } else if (i > 0) {
                i = res[i-1];
            } else {
                res[j++] = i;
            }
        }
        return res;
    }
}
