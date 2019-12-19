package leetcode.algo.c;

import leetcode.common.TreeNode;

public class ConstructBinarySearchTreefromPreorderTraversal {
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 1; i < preorder.length; i++) {
            TreeNode cur = root;
            while (cur != null) {
                if (cur.val > preorder[i]) {
                    if (cur.left != null) {
                        cur = cur.left;
                    } else {
                        cur.left = new TreeNode(preorder[i]);
                        break;
                    }
                } else if (cur.val < preorder[i]) {
                    if (cur.right != null) {
                        cur = cur.right;
                    } else {
                        cur.right = new TreeNode(preorder[i]);
                        break;
                    }
                }
            }
        }
        return root;
    }
}
