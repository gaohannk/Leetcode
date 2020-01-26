package company.google.onsite;

import leetcode.common.TreeNode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        int count = 0;
        while (!queue.isEmpty()) {
            Queue<TreeNode> nextlayer = new LinkedList<>();
            List<Integer> curLayer = new LinkedList<>();

            while ((!queue.isEmpty())) {
                TreeNode cur = queue.poll();
                curLayer.add(cur.val);
                if (cur.left != null) {
                    nextlayer.add(cur.left);
                }
                if (cur.right != null) {
                    nextlayer.add(cur.right);
                }
            }
            if (count % 2 == 1) {
                Collections.reverse(curLayer);
            }
            res.add(curLayer);
            queue = nextlayer;
            count++;
        }
        return res;
    }
}
