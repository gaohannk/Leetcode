package leetcode;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.
 * <p>
 * Assume a BST is defined as follows:
 * <p>
 * The left subtree of a node contains only nodes with keys less than or equal to the node's key.
 * The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * For example:
 * Given BST [1,null,2,2],
 * 1
 * \
 * 2
 * /
 * 2
 * return [2].
 * <p>
 * Note: If a tree has more than one mode, you can return them in any order.
 * <p>
 * Follow up: Could you do that without using any extra space? (Assume that the implicit stack space incurred due to recursion does not count).
 */
public class FindModeinBinarySearchTree {
    public int[] findMode(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<>();
        helper(root, map);
        LinkedList<Integer> list = new LinkedList<>();
        int max = 0;
        for (int key : map.keySet()) {
            if (map.get(key) > max) {
                list.clear();
                list.add(key);
                max = map.get(key);
            } else if (map.get(key) == max) {
                list.add(key);
            }

        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private void helper(TreeNode root, HashMap<Integer, Integer> map) {
        if (root == null)
            return;
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        helper(root.left, map);
        helper(root.right, map);
    }
}
