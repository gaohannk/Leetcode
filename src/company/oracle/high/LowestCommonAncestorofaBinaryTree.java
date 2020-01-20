package company.oracle.high;

import leetcode.common.TreeNode;

public class LowestCommonAncestorofaBinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q) {
            return root;
        }
        if (inOrderSearch(root.left, p) && inOrderSearch(root.right, q)
                || inOrderSearch(root.left, q) && inOrderSearch(root.right, p)) {
            return root;
        } else if (inOrderSearch(root.left, p) && inOrderSearch(root.left, q)) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (inOrderSearch(root.right, p) && inOrderSearch(root.right, q)) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return null;
    }

    private boolean inOrderSearch(TreeNode root, TreeNode target) {
        if (root == null) {
            return false;
        }
        if (root == target) {
            return true;
        }
        return inOrderSearch(root.left, target) || inOrderSearch(root.right, target);
    }
}
