package leetcode.algo.p;

import leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class PrintBinaryTree {

    public List<List<String>> printTree(TreeNode root) {
        int depth = getDepth(root);
        List<List<String>> res = new LinkedList<>();
        for (int i = 0; i < depth; i++) {
            res.add(new LinkedList<>());
            for (int j = 0; j < Math.pow(2, depth) - 1; j++) {
                res.get(i).add("");
            }
        }
        int maxStep = (int) Math.pow(2, depth - 2);
        helper(root, (int) (Math.pow(2, depth) - 1) / 2, 0, maxStep, res);
        return res;
    }

    private void helper(TreeNode root, int col, int row, int step, List<List<String>> res) {
        if (root == null) {
            return;
        }
        res.get(row).remove(col);
        res.get(row).add(col, String.valueOf(root.val));
        helper(root.left, col - step, row + 1, step / 2, res);
        helper(root.right, col + step, row + 1, step / 2, res);
    }

    private int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
    }
}
