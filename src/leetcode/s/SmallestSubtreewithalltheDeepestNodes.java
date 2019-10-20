package leetcode.s;

import java.util.HashMap;

/**
 * Given a binary tree rooted at root, the depth of each node is the shortest distance to the root.
 * <p>
 * A node is deepest if it has the largest depth possible among any node in the entire tree.
 * <p>
 * The subtree of a node is that node, plus the set of all descendants of that node.
 * <p>
 * Return the node with the largest depth such that it contains all the deepest nodes in its subtree.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [3,5,1,6,2,0,8,null,null,7,4]
 * Output: [2,7,4]
 * Explanation:
 * <p>
 * <p>
 * <p>
 * We return the node with value 2, colored in yellow in the diagram.
 * The nodes colored in blue are the deepest nodes of the tree.
 * The input "[3, 5, 1, 6, 2, 0, 8, null, null, 7, 4]" is a serialization of the given tree.
 * The output "[2, 7, 4]" is a serialization of the subtree rooted at the node with value 2.
 * Both the input and output have TreeNode type.
 */
public class SmallestSubtreewithalltheDeepestNodes {
    HashMap<TreeNode, Integer> map = new HashMap<>();

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        dfs(root, 1);
        int maxDepth = 0;
        for (int depth : map.values()) {
            maxDepth = Math.max(depth, maxDepth);
        }

        return rootOfSubtreewithAllDeepestNode(root, maxDepth);
    }

    private TreeNode rootOfSubtreewithAllDeepestNode(TreeNode root, int maxDepth) {
        if (root == null)
            return null;
        if (root != null && map.get(root) == maxDepth)
            return root;
        TreeNode leftChild = rootOfSubtreewithAllDeepestNode(root.left, maxDepth);
        TreeNode rightChild = rootOfSubtreewithAllDeepestNode(root.right, maxDepth);
        if (leftChild != null && rightChild != null) {
            return root;
        } else if (leftChild != null)
            return leftChild;
        else if (rightChild != null)
            return rightChild;

        return null;
    }

    private void dfs(TreeNode root, int depth) {
        if (root != null) {
            map.put(root, depth);
            dfs(root.left, depth + 1);
            dfs(root.right, depth + 1);
        }
    }
}
