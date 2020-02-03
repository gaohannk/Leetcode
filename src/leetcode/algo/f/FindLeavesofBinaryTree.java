package leetcode.algo.f;

import leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class FindLeavesofBinaryTree {

    public static List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> list;
        if (root == null) {
            return res;
        }
        while (root.left != null || root.right != null) {
            list = new LinkedList<>();
            helper(list, root, null, false);
            res.add(list);
        }
        list = new LinkedList<>();
        list.add(root.val);
        res.add(list);

        return res;
    }

    private static void helper(List<Integer> list, TreeNode root, TreeNode parent, boolean isLeft) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            list.add(root.val);
            if (isLeft && parent != null) {
                parent.left = null;
            } else if (!isLeft && parent != null) {
                parent.right = null;
            }
            return;
        }

        helper(list, root.left, root, true);
        helper(list, root.right, root, false);

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(findLeaves(root));
    }
}
