package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * Given a directed, acyclic graph of N nodes.  Find all possible paths from node 0 to node N-1, and return them in any order.
 * <p>
 * The graph is given as follows:  the nodes are 0, 1, ..., graph.length - 1.  graph[i] is a list of all nodes j for which the edge (i, j) exists.
 * <p>
 * Example:
 * Input: [[1,2], [3], [3], []]
 * Output: [[0,1,3],[0,2,3]]
 * Explanation: The graph looks like this:
 * 0--->1
 * |    |
 * v    v
 * 2--->3
 * There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
 * Note:
 * <p>
 * The number of nodes in the graph will be in the range [2, 15].
 * You can print different paths in any order, but you should keep the order of nodes inside one path.
 */
public class AllPathsFromSourcetoTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new LinkedList<>();
        int[] visit = new int[graph.length];
        List<Integer> subRes = new LinkedList<>();

        subRes.add(0);
        dfs(0, subRes, res, visit, graph);

        return res;

    }

    private void dfs(int cur, List<Integer> subRes, List<List<Integer>> res, int[] visit, int[][] graph) {
        if (graph[cur].length == 0) {
            res.add(new LinkedList<>(subRes));
            return;
        }
        if (visit[cur] == 1)
            return;

        for (int j = 0; j < graph[cur].length; j++) {
            subRes.add(graph[cur][j]);
            visit[cur] = 1;
            dfs(graph[cur][j], subRes, res, visit, graph);
            visit[cur] = 0;
            subRes.remove(subRes.size() - 1);
        }
    }
}
