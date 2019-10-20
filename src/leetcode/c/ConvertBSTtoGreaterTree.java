package leetcode.c;

import leetcode.t.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.
 * <p>
 * Example:
 * <p>
 * Input: The root of a Binary Search Tree like this:
 * 5
 * /   \
 * 2     13
 * <p>
 * Output: The root of a Greater Tree like this:
 * 18
 * /   \
 * 20     13
 */
public class ConvertBSTtoGreaterTree {
    public List<Integer> list = new LinkedList<>();

    public TreeNode convertBST(TreeNode root) {
        // inorder
        traverse(root);
        int[] greaterSum = new int[list.size()];
        int s = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            s += list.get(i);
            greaterSum[i] = s;
        }
        int count[] = new int[1];
        update(root, greaterSum, count);
        return root;
    }

    private void update(TreeNode root, int[] sum, int[] count) {
        if (root == null)
            return;
        update(root.left, sum, count);
        root.val = sum[count[0]];
        count[0]++;
        update(root.right, sum, count);
    }

    private void traverse(TreeNode root) {
        if (root == null)
            return;
        traverse(root.left);
        list.add(root.val);
        traverse(root.right);
    }
}
