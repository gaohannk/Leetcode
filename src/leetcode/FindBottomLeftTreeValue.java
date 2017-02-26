package leetcode;

/**
 * Given a binary tree, find the leftmost value in the last row of the tree.
 * <p>
 * Example 1:
 * Input:
 * <p>
 * 2
 * / \
 * 1   3
 * <p>
 * Output:
 * 1
 * Example 2:
 * Input:
 * <p>
 * 1
 * / \
 * 2   3
 * /   / \
 * 4   5   6
 * /
 * 7
 * <p>
 * Output:
 * 7
 * Note: You may assume the tree (i.e., the given root node) is not NULL.
 */
public class FindBottomLeftTreeValue {
    int value = 0;
    int maxHeight = 0;

    public int findBottomLeftValue(TreeNode root) {
        int height = 0;
        helper(root, height);
        return value;
    }

    private void helper(TreeNode root, int height) {
        if (root == null) {
            maxHeight = maxHeight > height ? maxHeight : height;
            return;
        }
        helper(root.left, height + 1);
        helper(root.right, height + 1);
        if (root.left == null && root.right == null) {
            if (height > maxHeight)
                value = root.val;
        }
    }
}
