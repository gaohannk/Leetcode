package company.offerup.phone;

import leetcode.common.TreeNode;
// Non recursive
public class DeleteANodeinBST {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        TreeNode dNode = root;
        TreeNode parentNode = null;
        while (dNode != null && key != dNode.val) {
            parentNode = dNode;
            if (key > dNode.val) {
                dNode = dNode.right;
            } else {
                dNode = dNode.left;
            }
        }
        if (dNode == null)
            return root;
        if (dNode.left == null && dNode.right == null) {
            if (dNode == root)
                return null;
            if (parentNode.left == dNode)
                parentNode.left = null;
            else
                parentNode.right = null;
        } else if (dNode.left != null && dNode.right != null) {
            TreeNode tmp = dNode.right; //find the leftmost node of the right subtree
            parentNode = null;
            while (tmp.left != null) {
                parentNode = tmp;
                tmp = tmp.left;
            }
            if (dNode.right == tmp) {
                dNode.val = tmp.val;
                dNode.right = tmp.right;
                tmp.right = null;
            } else {
                parentNode.left = tmp.right;
                dNode.val = tmp.val;
                tmp.right = null;
            }
        } else { // one child is null
            if (dNode.left != null) {
                TreeNode tmp = dNode.left;
                dNode.val = tmp.val;
                dNode.left = tmp.left;
                dNode.right = tmp.right;
            } else {
                TreeNode tmp = dNode.right;
                dNode.val = tmp.val;
                dNode.left = tmp.left;
                dNode.right = tmp.right;
            }
        }
        return root;
    }

    public static void main(String[] args) {

    }
}
