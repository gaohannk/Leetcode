package leetcode;

/**
 * Given a complete binary tree, count the number of nodes.
 * <p>
 * Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly the last, is completely filled,
 * and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
 */

// LTE
public class CountCompleteTreeNodes {
    int count = 0;

    public int countNodes(TreeNode root) {
        int height = 0;
        TreeNode rootCopy = root;
        while (root != null) {
            root = root.left;
            height++;
        }
        helper(rootCopy, height - 1, 0);
        return (int) (Math.pow(2, height) - 1 + count);
    }


    private void helper(TreeNode root, int height, int curHeight) {
        if (root == null)
            return;
        if (root.left == null && root.right == null)
            if (height == curHeight)
                count++;
            else
                return;
        helper(root.left, height, curHeight + 1);
        helper(root.right, height, curHeight + 1);
    }
}
