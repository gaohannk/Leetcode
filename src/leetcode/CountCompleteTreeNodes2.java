package leetcode;

/**
 * Given a complete binary tree, count the number of nodes.
 * <p>
 * Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly the last, is completely filled,
 * and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
 */

public class CountCompleteTreeNodes2 {

    public int countNodes(TreeNode root) {
        int left = getLeftHeight(root);
        int right = getRightHeight(root);
        if (left == right) {
            return (1 << left) - 1;  // Don't forget () && Use Math.pow() will cause TLE
        } else
            return countNodes(root.left) + countNodes(root.right) + 1;

    }

    private int getLeftHeight(TreeNode root) {
        int height = 0;
        while (root != null) {
            root = root.left;
            height++;
        }
        return height;
    }

    private int getRightHeight(TreeNode root) {
        int height = 0;
        while (root != null) {
            root = root.right;
            height++;
        }
        return height;
    }
}
