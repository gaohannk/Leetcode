package leetcode.algo.d;

import leetcode.common.TreeNode;

/**
 * Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.
 * <p>
 * Basically, the deletion can be divided into two stages:
 * <p>
 * Search for a node to remove.
 * If the node is found, delete the node.
 * Note: Time complexity should be O(height of tree).
 * <p>
 * Example:
 * <p>
 * root = [5,3,6,2,4,null,7]
 * key = 3
 * <p>
 * 5
 * / \
 * 3   6
 * / \   \
 * 2   4   7
 * <p>
 * Given key to delete is 3. So we find the node with value 3 and delete it.
 * <p>
 * One valid answer is [5,4,6,2,null,null,7], shown in the following BST.
 * <p>
 * 5
 * / \
 * 4   6
 * /     \
 * 2       7
 * <p>
 * Another valid answer is [5,2,6,null,4,null,7].
 * <p>
 * 5
 * / \
 * 2   6
 * \   \
 * 4   7
 */
public class DeleteNodeinaBST2 {
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
}
