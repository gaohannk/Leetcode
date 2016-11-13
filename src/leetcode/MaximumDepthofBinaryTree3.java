package leetcode;

/* Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */
public class MaximumDepthofBinaryTree3 {
    public static int maxDepth(TreeNode root) {
        int curDep = 1;
        int res[] = new int[1];
        helper(root, curDep, res);
        return res[0];
    }

    private static void helper(TreeNode root, int curDep, int[] res) {
        if (root == null) {
            res[0] = res[0] > curDep ? res[0] : curDep;
            return;
        }
        helper(root.left, curDep + 1, res);
        helper(root.right, curDep + 1, res);
    }
}
