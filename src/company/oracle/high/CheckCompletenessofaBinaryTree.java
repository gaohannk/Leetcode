package company.oracle.high;

import leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class CheckCompletenessofaBinaryTree {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean flag = false;
        while (!queue.isEmpty()) {
            Queue<TreeNode> nextLayer = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeNode cur = queue.poll();
                if (cur != null) {
                    if (cur.left == null || cur.right == null) {
                        flag = true;
                    }
                    nextLayer.offer(cur.left);
                    nextLayer.offer(cur.right);
                } else {
                    flag = true;
                }
            }
            // has null in current layer check next layer
            if (flag && notAllNull(nextLayer)) {
                return false;
            }
            if (hasValueAfterNull(nextLayer)) {
                return false;
            }
            queue = nextLayer;
        }
        return true;
    }

    private boolean notAllNull(Queue<TreeNode> nextLayer) {
        Queue<TreeNode> copy = new LinkedList<>(nextLayer);
        for (TreeNode node : copy) {
            if (node != null) {
                return true;
            }
        }
        return false;
    }

    private boolean hasValueAfterNull(Queue<TreeNode> queue) {
        if (queue.size() == 0) {
            return false;
        }
        Queue<TreeNode> copy = new LinkedList<>(queue);
        boolean flag = false;
        for (TreeNode node : copy) {
            if (flag && node != null) {
                return true;
            }
            if (node == null) {
                flag = true;
            }
        }
        return false;
    }
}
