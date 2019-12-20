package leetcode.algo.m;

import leetcode.common.TreeNode;

public class MinimumAbsoluteDifferenceinBST {
    int min = Integer.MAX_VALUE;
    Integer prev = null;

    public int getMinimumDifference(TreeNode root) {
        if (root == null)
            return -1;
        getMinimumDifference(root.left);
        if (prev != null)
            min = Math.min(min, root.val - prev);
        prev = root.val;
        getMinimumDifference(root.right);

        return min;
    }
}
