package leetcode;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;

/**
 * Given the root of a tree, you are asked to find the most frequent subtree sum. The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself). So what is the most frequent subtree sum value? If there is a tie, return all the values with the highest frequency in any order.
 * <p>
 * Examples 1
 * Input:
 * <p>
 * 5
 * /  \
 * 2   -3
 * return [2, -3, 4], since all the values happen only once, return all of them in any order.
 * Examples 2
 * Input:
 * <p>
 * 5
 * /  \
 * 2   -5
 * return [2], since 2 happens twice, however -5 only occur once.
 * Note: You may assume the sum of values in any subtree is in the range of 32-bit signed integer.
 */
public class MostFrequentSubtreeSum {
    public int[] findFrequentTreeSum(TreeNode root) {
        int sum = 0;
        if (root == null)
            return new int[0];
        HashMap<Integer, Integer> map = new HashMap<>();
        helper(root, map);
        int max = 0;
        for (int key : map.keySet()) {
            max = max > map.get(key) ? max : map.get(key);
        }
        LinkedList<Integer> res = new LinkedList<>();
        for (int key : map.keySet()) {
            if (map.get(key) == max)
                res.add(key);
        }
        return res.stream().mapToInt(i -> i).toArray();
    }

    private int helper(TreeNode root, HashMap<Integer, Integer> map) {
        if (root == null)
            return 0;
        int sum = 0;
        sum += helper(root.left, map);
        sum += helper(root.right, map);
        sum += root.val;
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        return sum;
    }
}
