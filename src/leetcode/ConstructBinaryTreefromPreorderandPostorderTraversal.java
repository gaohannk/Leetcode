package leetcode;

import java.util.Arrays;

/**
 * Leetcode: 889
 * Time Complexity: O(N^2) where N is the number of nodes.
 * Space Complexity: O(N^2)
 */
public class ConstructBinaryTreefromPreorderandPostorderTraversal {
    public static TreeNode constructFromPrePost(int[] pre, int[] post) {
        if (pre.length == 0)
            return null;
        if (pre.length == 1)
            return new TreeNode(pre[0]);

        TreeNode root = new TreeNode(pre[0]);
        int leftNum = getIndexofLeftRoot(post, pre[1]) + 1;
        TreeNode leftRoot = constructFromPrePost(Arrays.copyOfRange(pre, 1, 1 + leftNum),
                Arrays.copyOfRange(post, 0, leftNum));
        TreeNode rightRoot = constructFromPrePost(Arrays.copyOfRange(pre, 1 + leftNum, pre.length),
                Arrays.copyOfRange(post, leftNum, post.length - 1));
        root.left = leftRoot;
        root.right = rightRoot;
        return root;
    }

    private static int getIndexofLeftRoot(int[] post, int leftRoot) {
        for (int i = 0; i < post.length; i++) {
            if (post[i] == leftRoot)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] pre = new int[]{1, 2, 4, 5, 3, 6, 7};
        int[] post = new int[]{4, 5, 2, 6, 7, 3, 1};
        constructFromPrePost(pre, post);
    }
}
