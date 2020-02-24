package company.oracle.high;

import leetcode.common.TreeNode;
/**
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 * <p>
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”
 * <p>
 * _______3______
 * /              \
 * ___5__          ___1__
 * /      \        /      \
 * 6      _2       0       8
 * /  \
 * 7   4
 * For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. Another example is LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
 */
// O((logn)^2)
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
