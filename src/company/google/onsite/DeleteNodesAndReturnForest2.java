package company.google.onsite;

import leetcode.common.TreeNode;

import java.util.*;

public class DeleteNodesAndReturnForest2 {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<TreeNode> res = new HashSet<>();
        res.add(root);
        Set<Integer> valueToBeDeleted = new HashSet<>();
        for (int i : to_delete) {
            valueToBeDeleted.add(i);
        }

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode dummy = new TreeNode(-1);
        dummy.left = root;
        queue.add(dummy);

        while (!valueToBeDeleted.isEmpty()) {
            TreeNode curr = queue.poll();
            processNode(queue, curr, curr.left, res, valueToBeDeleted, 0);
            processNode(queue, curr, curr.right, res, valueToBeDeleted, 1);
        }

        return new ArrayList<>(res);
    }

    private void processNode(Queue<TreeNode> queue, TreeNode curr, TreeNode child,
                             Set<TreeNode> res, Set<Integer> remains, int leftOrRight) {
        if (child == null) {
            return;
        }

        if (remains.remove(child.val)) {
            res.remove(child);

            if (child.left != null) {
                res.add(child.left);
            }
            if (child.right != null) {
                res.add(child.right);
            }
            if (leftOrRight == 0) {
                curr.left = null;
            } else {
                curr.right = null;
            }
        }

        queue.add(child);
    }
}
