package leetcode.algo.a;


import leetcode.common.TreeNode;

import java.util.*;

public class AllNodesDistanceKinBinaryTree {
    Map<TreeNode, List<TreeNode>> map = new HashMap<>();
    List<Integer> res = new ArrayList<>();
    Set<TreeNode> set = new HashSet<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        dfs(root, root);
        helper(target, K);
        return res;
    }

    public void dfs(TreeNode node, TreeNode parent) {
        if (node == null)
            return;
        if (map.get(node) == null) {
            map.put(node, new LinkedList<>());
        }
        if (map.get(parent) == null) {
            map.put(parent, new LinkedList<>());
        }
        map.get(parent).add(node);
        map.get(node).add(parent);
        dfs(node.left, node);
        dfs(node.right, node);
    }

    public void helper(TreeNode node, int count) {
        if (node == null)
            return;
        if (count == 0) {
            res.add(node.val);
            return;
        }
        set.add(node);
        List<TreeNode> list = map.get(node);
        for (TreeNode neibour : map.get(node)) {
            if (!set.contains(neibour))
                helper(neibour, count - 1);
        }
    }
}
