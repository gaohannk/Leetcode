package leetcode.s;

/**
 * Created by gaohan on 8/4/18.
 */

import leetcode.t.TreeNode;

/**
 * Time Complexity: O(N)O(N), where NN is the number of nodes in the tree.
 * Space Complexity: O(N)O(N).
 */
public class SmallestSubtreewithalltheDeepestNodes2 {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return dfs(root).node;
    }

    // Return the result of the subtree at this node.
    public TreeNodeWithDist dfs(TreeNode node) {
        if (node == null) {
            return new TreeNodeWithDist(null, 0);
        }
        TreeNodeWithDist L = dfs(node.left),
                R = dfs(node.right);
        if (L.dist > R.dist)
            return new TreeNodeWithDist(L.node, L.dist + 1);
        if (L.dist < R.dist)
            return new TreeNodeWithDist(R.node, R.dist + 1);
        return new TreeNodeWithDist(node, L.dist + 1);
    }
}

/**
 * The result of a subtree is:
 * TreeNodeWithDist.node: the largest depth node that is equal to or
 * an ancestor of all the deepest nodes of this subtree.
 * TreeNodeWithDist.dist: the number of nodes in the path from the root
 * of this subtree, to the deepest node in this subtree.
 */
class TreeNodeWithDist {
    TreeNode node;
    int dist;

    TreeNodeWithDist(TreeNode n, int d) {
        node = n;
        dist = d;
    }
}

