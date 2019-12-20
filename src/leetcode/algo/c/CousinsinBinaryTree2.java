package leetcode.algo.c;

import leetcode.common.TreeNode;

public class CousinsinBinaryTree2 {
    private Integer xDepth = 0;
    private Integer yDepth = 0;
    private TreeNode xPre = null;
    private TreeNode yPre = null;

    public boolean isCousins(TreeNode root, int x, int y) {
        help(root, null, x, y, 0);
        if (xDepth == yDepth && xPre != yPre) {
            return true;
        }
        return false;

    }

    private void help(TreeNode curr, TreeNode parent, int x, int y, int h) {

        if (curr == null) {
            return;
        }

        if (curr.val == x) {
            xDepth = h;
            xPre = parent;
        }
        if (curr.val == y) {
            yDepth = h;
            yPre = parent;
        }
        parent = curr;
        help(curr.left, parent, x, y, h + 1);
        help(curr.right, parent, x, y, h + 1);
    }
}
