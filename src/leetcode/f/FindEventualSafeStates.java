package leetcode.f;

import java.util.*;

/**
 * In a directed graph, we start at some node and every turn, walk along a directed edge of the graph.  If we reach a node that is terminal (that is, it has no outgoing directed edges), we stop.
 * <p>
 * Now, say our starting node is eventually safe if and only if we must eventually walk to a terminal node.  More specifically, there exists a natural number K so that for any choice of where to walk, we must have stopped at a terminal node in less than K steps.
 * <p>
 * Which nodes are eventually safe?  Return them as an array in sorted order.
 * <p>
 * The directed graph has N nodes with labels 0, 1, ..., N-1, where N is the length of graph.  The graph is given in the following form: graph[i] is a list of labels j such that (i, j) is a directed edge of the graph.
 * <p>
 * Example:
 * Input: graph = [[1,2],[2,3],[5],[0],[5],[],[]]
 * Output: [2,4,5,6]
 * Here is a diagram of the above graph.
 * <p>
 * Illustration of graph
 * <p>
 * Note:
 * <p>
 * graph will have length at most 10000.
 * The number of edges in the graph will not exceed 32000.
 * Each graph[i] will be a sorted list of different integers, chosen within the range [0, graph.length - 1].
 */

/**
 * visit[i] =0 not visit
 * visit[i] =1 not safe
 * visit[i] =2 safe
 */
public class FindEventualSafeStates {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> res = new LinkedList<>();
        int[] visit = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (dfs(graph, i, visit))
                res.add(i);
        }
        return res;
    }

    public List<Integer> eventualSafeNodes2(int[][] graph) {
        List<Integer> res = new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            // Long time
            int[] visit = new int[graph.length];
            if (dfs(graph, i, visit))
                res.add(i);
        }
        return res;
    }

    private boolean dfs(int[][] graph, int cur, int[] visit) {
        if (visit[cur] != 0)
            //prune
            return visit[cur] == 2;
        for (int i = 0; i < graph[cur].length; i++) {
            visit[cur] = 1;
            if (!dfs(graph, graph[cur][i], visit))
                return false;
        }
        visit[cur] = 2;
        return true;
    }
}
