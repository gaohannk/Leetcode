package company.databricks.phone;

import leetcode.common.TreeNode;

import java.util.*;

public class ClosestLeafinaBinaryTree2 {
    public int findClosestLeaf(TreeNode root, int k) {
        List<TreeNode> path = new ArrayList();
        Map<TreeNode, LeafResult> annotation = new HashMap();

        dfs(root, k, path);

        int distanceFromTarget = path.size() - 1;
        int dist = Integer.MAX_VALUE;
        TreeNode leaf = null;

        for (TreeNode node : path) {
            LeafResult lr = closestLeaf(node, annotation);
            if (lr.dist + distanceFromTarget < dist) {
                dist = lr.dist + distanceFromTarget;
                leaf = lr.node;
            }
            distanceFromTarget--;
        }
        return leaf.val;
    }

    public boolean dfs(TreeNode node, int k, List<TreeNode> path) {
        if (node == null) {
            return false;
        } else if (node.val == k) {
            path.add(node);
            return true;
        } else {
            path.add(node);
            boolean ans = dfs(node.left, k, path);
            if (ans)
                return true;
            ans = dfs(node.right, k, path);
            if (ans)
                return true;
            path.remove(path.size() - 1);
            return false;
        }
    }

    public LeafResult closestLeaf(TreeNode root, Map<TreeNode, LeafResult> annotation) {
        if (root == null) {
            return new LeafResult(null, Integer.MAX_VALUE);
        } else if (root.left == null && root.right == null) {
            return new LeafResult(root, 0);
        } else if (annotation.containsKey(root)) {
            return annotation.get(root);
        } else {
            LeafResult r1 = closestLeaf(root.left, annotation);
            LeafResult r2 = closestLeaf(root.right, annotation);
            LeafResult ans = new LeafResult(r1.dist < r2.dist ? r1.node : r2.node,
                    Math.min(r1.dist, r2.dist) + 1);
            annotation.put(root, ans);
            return ans;
        }
    }

    class LeafResult {
        TreeNode node;
        int dist;

        LeafResult(TreeNode n, int d) {
            node = n;
            dist = d;
        }
    }
}


