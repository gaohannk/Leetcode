package leetcode.algo.m;

import leetcode.common.TreeNode;

public class MaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int max = Integer.MIN_VALUE;
        int id = -1;
        for (int i = start; i <= end; i++) {
            if (max < nums[i]) {
                max = nums[i];
                id = i;
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = helper(nums, start, id - 1);
        root.right = helper(nums, id + 1, end);
        return root;
    }
}
