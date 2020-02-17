package leetcode.algo.t;

import java.util.*;

public class TreeDiameter3 {

    int diameter = 0;

    public int treeDiameter(int[][] edges) {
        int n = edges.length + 1;
        LinkedList<Integer>[] adjacencyList = new LinkedList[n];
        for (int i = 0; i < n; ++i) adjacencyList[i] = new LinkedList<>();
        for (int[] edge : edges) {
            adjacencyList[edge[0]].add(edge[1]);
            adjacencyList[edge[1]].add(edge[0]);
        }
        diameter = 0;
        depth(0, -1, adjacencyList);
        return diameter;
    }

    private int depth(int root, int parent, LinkedList<Integer>[] adjacencyList) {
        int maxDepth1st = 0, maxDepth2nd = 0;
        for (int child : adjacencyList[root]) {
            if (child != parent) { // Only one way from root node to child node, don't allow child node go to root node again!
                int childDepth = depth(child, root, adjacencyList);
                if (childDepth > maxDepth1st) {
                    maxDepth2nd = maxDepth1st;
                    maxDepth1st = childDepth;
                } else if (childDepth > maxDepth2nd) {
                    maxDepth2nd = childDepth;
                }
            }
        }
        int longestPathThroughRoot = maxDepth1st + maxDepth2nd; // Sum of the top 2 highest depths is the longest path through this root
        diameter = Math.max(diameter, longestPathThroughRoot);
        return maxDepth1st + 1;
    }
}
