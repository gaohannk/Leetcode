package leetcode.algo.m;

import leetcode.common.TreeNode;

public class MinimumAbsoluteDifferenceinBST2 {
    public int getMinimumDifference(TreeNode root) {
        if(root == null) {
            return Integer.MAX_VALUE;
        }
        int differenceWithLeftSubtree = Integer.MAX_VALUE;
        int differenceWithRightSubTree = Integer.MAX_VALUE;

        if(root.right != null) {
            differenceWithRightSubTree = greaterClosestValue(root.right) - root.val;
        }

        if(root.left != null) {
            differenceWithLeftSubtree = root.val - smallestClosestValue(root.left);

        }

        int minimum = Math.min(differenceWithRightSubTree, differenceWithLeftSubtree);

        return Math.min(Math.min(getMinimumDifference(root.left), getMinimumDifference(root.right)), minimum) ;
    }

    public int greaterClosestValue(TreeNode root) {
        if(root.left == null) {
            return root.val;
        }

        return greaterClosestValue(root.left);
    }

    public int smallestClosestValue(TreeNode root) {
        if(root.right == null) {
            return root.val;
        }

        return smallestClosestValue(root.right);
    }
}
