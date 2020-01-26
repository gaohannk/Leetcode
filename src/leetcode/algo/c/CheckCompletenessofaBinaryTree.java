package leetcode.algo.c;

import leetcode.common.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class CheckCompletenessofaBinaryTree {
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean stop = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left == null) {
                    stop = true;
                } else {
                    if (stop) {
                        return false;
                    } else {
                        queue.offer(node.left);
                    }
                }
                if (node.right == null) {
                    stop = true;
                } else {
                    if (stop) {
                        return false;
                    } else {
                        queue.offer(node.right);
                    }
                }
            }
        }
        return true;
    }
}
