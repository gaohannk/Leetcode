package leetcode.algo.d;

import java.util.ArrayList;
import java.util.List;

public class DeleteTreeNodes3 {
    public int deleteTreeNodes(int n, int[] parent, int[] value) {
        List<List<Integer>> graph = new ArrayList<>(n); // Create graph for the tree
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            if (parent[i] != -1) {
                graph.get(parent[i]).add(i);
            }
        }
        return dfs(graph, value, 0)[1];
    }

    private int[] dfs(List<List<Integer>> graph, int[] value, int root) {
        int sum = value[root];
        int cntRemainNodes = 1;
        for (int child : graph.get(root)) {
            int[] temp = dfs(graph, value, child);
            sum += temp[0];
            cntRemainNodes += temp[1];
        }
        if (sum == 0)
            cntRemainNodes = 0; // Don't count nodes of this subtree
        return new int[]{sum, cntRemainNodes};
    }
}
