package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Given an n-ary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * <p>
 * For example, given a 3-ary tree:
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * We should return its level order traversal:
 * <p>
 * [
 * [1],
 * [3,2,4],
 * [5,6]
 * ]
 */
public class NaryTreeLevelOrderTraversal {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<List<Integer>> levelOrder(Node root) {

        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> currentList = new ArrayList<>();
            while (size > 0) {
                Node node = queue.poll();
                currentList.add(node.val);
                if (node.children != null) {
                    queue.addAll(node.children);
                }
                size--;
            }
            res.add(currentList);
        }
        return res;
    }
}
