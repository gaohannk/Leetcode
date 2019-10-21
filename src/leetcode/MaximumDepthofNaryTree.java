package leetcode;

import java.util.List;

/**
 * Given a n-ary tree, find its maximum depth.
 * <p>
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * <p>
 * For example, given a 3-ary tree:
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * We should return its max depth, which is 3.
 * <p>
 * <p>
 * <p>
 * Note:
 * <p>
 * The depth of the tree is at most 1000.
 * The total number of nodes is at most 5000.
 */
public class MaximumDepthofNaryTree {
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

    public int maxDepth(Node root) {
        if (root == null)
            return 0;
        if (root.children == null || root.children.size() == 0) {
            return 1;
        }
        int max = 0;
        List<Node> childer = root.children;

        for (int i = 0; i < childer.size(); i++) {
            max = Math.max(max, maxDepth(childer.get(i)) + 1);
        }
        return max;
    }
}
