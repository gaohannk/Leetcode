package company.offerup.phone;

import leetcode.common.TreeNode;

import java.util.*;

/**
 * 题目：
 * input1: 给一个数字n，从0到n-1表示n个节点（题目表示以任意节点都可以作为根节点组成树）;
 * input2: 给一个数组edges，例如 [0，1]，[1，2]，表示两个节点有相连的关系
 * 求output：在所有可能根节点情况下的最小树height, 树的height是root到叶子节点最大的距离
 */
public class MinimumHeight {

    public static int findMinimumHeight(int n, int[][] edges) {
        Map<Integer, List<Integer>> edgeList = new HashMap<>();

        for (int[] edge : edges) {
            if (edgeList.get(edge[0]) == null) {
                List<Integer> adg = new LinkedList<>();
                adg.add(edge[1]);
                edgeList.put(edge[0], adg);
            } else {
                edgeList.get(edge[0]).add(edge[1]);
            }
        }
        int height = Integer.MAX_VALUE;
        for (Integer root : edgeList.keySet()) {
            height = Math.min(helper(edgeList, root), height);
        }
        return height;
    }

    private static int helper(Map<Integer, List<Integer>> edgeList, Integer root) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()) {
            Queue<Integer> nextLayer = new LinkedList<>();
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                if (edgeList.get(cur) == null) {
                    continue;
                }
                nextLayer.addAll(edgeList.get(cur));
            }
            queue = nextLayer;
            level++;
        }
        return level;
    }

    public static void main(String[] args) {
        int[][] edges = {{0,1},{1,2},{2,3},{3,4}};
        System.out.println(findMinimumHeight(5, edges));
    }
}
