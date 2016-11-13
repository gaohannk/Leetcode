package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * You are given a binary tree in which each node contains an integer value.
 * <p>
 * Find the number of paths that sum to a given value.
 * <p>
 * The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).
 * <p>
 * The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
 * <p>
 * Example:
 * <p>
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 * <p>
 * 10
 * /  \
 * 5   -3
 * / \    \
 * 3   2   11
 * / \   \
 * 3  -2   1
 * <p>
 * Return 3. The paths that sum to 8 are:
 * <p>
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3. -3 -> 11
 */
public class PathSumIII3 {
    public int pathSum(TreeNode root, int sum) {
        if (root == null)
            return 0;
        return helper(root, sum, false);
    }

    // Either the path has not started, or it has to go all the way to the end.
    private int helper(TreeNode root, int sum, boolean hasStarted) {
        if (root == null)
            return 0;
        // if the path has not started, we start now or not.
        if (!hasStarted) {
            return helper(root, sum, true) + helper(root.left, sum, false) + helper(root.right, sum, false);
        }
        // if the path has started
        sum -= root.val;
        return helper(root.left, sum, true) + helper(root.right, sum, true) + (sum == 0 ? 1 : 0);
    }
}



