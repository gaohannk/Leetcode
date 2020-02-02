package leetcode.algo.a;


import leetcode.common.TreeNode;

import java.util.*;

public class AllNodesDistanceKinBinaryTree2 {
    List<Integer> ans;
    TreeNode target;
    int K;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        ans = new LinkedList();
        this.target = target;
        this.K = K;
        dfs(root);
        return ans;
    }

    // Return vertex distance from node to target if exists, else -1
    // Vertex distance: the number of vertices on the path from node to target
    public int dfs(TreeNode node) {
        if (node == null)
            return -1;
        else if (node == target) {
            searchSubTree(node, 0);
            return 1;
        } else {
            int L = dfs(node.left), R = dfs(node.right);
            if (L != -1) {
                if (L == K) {
                    ans.add(node.val);
                } else {
                    searchSubTree(node.right, L + 1);
                }
                return L + 1;
            } else if (R != -1) {
                if (R == K) {
                    ans.add(node.val);
                } else {
                    searchSubTree(node.left, R + 1);
                }
                return R + 1;
            } else {
                return -1;
            }
        }
    }

    // Add all nodes 'K - dist' from the node to answer.
    public void searchSubTree(TreeNode node, int dist) {
        if (node == null)
            return;
        if (dist == K)
            ans.add(node.val);
        else {
            searchSubTree(node.left, dist + 1);
            searchSubTree(node.right, dist + 1);
        }
    }
}
