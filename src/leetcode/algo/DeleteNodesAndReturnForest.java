package leetcode.algo;

import leetcode.common.TreeNode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class DeleteNodesAndReturnForest {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> set = new HashSet<>();
        for (int del : to_delete) {
            set.add(del);
        }
        Set<TreeNode> res = new HashSet<>();
        res.add(root);
        helper(root, set, res);
        LinkedList list = new LinkedList();
        list.addAll(set);
        return list;
    }

    private void helper(TreeNode root, Set<Integer> set, Set<TreeNode> res) {
        if (root == null) {
            return;
        }
        if (set.contains(root.val)) {
            if (root.left != null) {
                res.add(root.left);
            }
            if (root.right != null) {
                res.add(root.right);
            }
            res.remove(root);
        }

        helper(root.left, set, res);
        helper(root.right, set, res);

        if (root.left != null && set.contains(root.left.val)) {
            if (root.left.left != null) {
                res.add(root.left.left);
            }
            if (root.left.right != null) {
                res.add(root.left.right);
            }
            root.left = null;
        }

        if (root.right != null && set.contains(root.right.val)) {
            if (root.right.left != null) {
                res.add(root.right.left);
            }
            if (root.right.right != null) {
                res.add(root.right.right);
            }
            root.right = null;
        }
    }
}
