package leetcode.algo.c;

import leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class CousinsinBinaryTree3 {
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null || root.val == x || root.val == y) {
            return false;
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        int level = 0, xLevel = 0, yLevel = 0;
        TreeNode xParent = null, yParent = null;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if (curr.left != null) {
                    q.offer(curr.left);
                    if (curr.left.val == x) {
                        xLevel = level;
                        xParent = curr;
                    }
                    if (curr.left.val == y) {
                        yLevel = level;
                        yParent = curr;
                    }
                }
                if (curr.right != null) {
                    q.offer(curr.right);
                    if (curr.right.val == x) {
                        xLevel = level;
                        xParent = curr;
                    }
                    if (curr.right.val == y) {
                        yLevel = level;
                        yParent = curr;
                    }
                }
            }
            level++;
        }
        return (xLevel == yLevel) && (xParent != yParent);
    }
}
