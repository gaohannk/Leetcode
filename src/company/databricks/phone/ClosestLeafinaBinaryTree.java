package company.databricks.phone;

import leetcode.common.TreeNode;

import java.util.*;
// DFS + BFS
public class ClosestLeafinaBinaryTree {
    public int findClosestLeaf(TreeNode root, int k) {
        Map<TreeNode, List<TreeNode>> graph = new HashMap();
        dfs(graph, root, null);

        Queue<TreeNode> queue = new LinkedList();
        Set<TreeNode> seen = new HashSet();

        for (TreeNode node: graph.keySet()) {
            if (node != null && node.val == k) {
                queue.add(node);
                seen.add(node);
            }
        }

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                // child node
                if (graph.get(node).size() <= 1)
                    return node.val;
                for (TreeNode neibour: graph.get(node)) {
                    if (!seen.contains(neibour)) {
                        seen.add(neibour);
                        queue.add(neibour);
                    }
                }
            }
        }
        throw null;
    }

    public void dfs(Map<TreeNode, List<TreeNode>> graph, TreeNode node, TreeNode parent) {
        if (node != null) {
            if (!graph.containsKey(node))
                graph.put(node, new LinkedList<>());
            if (!graph.containsKey(parent))
                graph.put(parent, new LinkedList<>());
            graph.get(node).add(parent);
            graph.get(parent).add(node);
            dfs(graph, node.left, node);
            dfs(graph, node.right, node);
        }
    }
}
