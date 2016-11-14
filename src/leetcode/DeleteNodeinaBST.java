package leetcode;

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
public class DeleteNodeinaBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;
        if (root.val < key)
            root.right = deleteNode(root.right, key);
        else if (root.val > key)
            root.left = deleteNode(root.left, key);
        else if (root.val == key) {
            if (root.left == null && root.right == null)
                return null;
            else if (root.left != null && root.right == null) {
                return root.left;
            } else if (root.left == null && root.right != null)
                return root.right;
            else {
                // Not delete the node with key directly, but update the value of node with key and delete the node with updated value.
                int val = findMinmumNode(root.right);
                root.val = val;
                root.right = deleteNode(root.right, val);
            }
        }
        return root;
    }

    private int findMinmumNode(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root.val;
    }
}
