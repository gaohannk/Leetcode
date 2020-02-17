package company.amazon.oa;

import java.util.*;

/**
 * Given an underected connected graph with n nodes labeled 1..n. A bridge (cut edge) is defined as an edge which, when removed, makes the graph disconnected (or more precisely, increases the number of connected components in the graph). Equivalently, an edge is a bridge if and only if it is not contained in any cycle. The task is to find all bridges in the given graph. Output an empty list if there are no bridges.
 *
 * Input:
 *
 * n, an int representing the total number of nodes.
 * edges, a list of pairs of integers representing the nodes connected by an edge.
 * Example 1:
 *
 * Input: n = 5, edges = [[1, 2], [1, 3], [3, 4], [1, 4], [4, 5]]
 *
 *
 * Output: [[1, 2], [4, 5]]
 * Explanation:
 * There are 2 bridges:
 * 1. Between node 1 and 2
 * 2. Between node 4 and 5
 * If we remove these edges, then the graph will be disconnected.
 * If we remove any of the remaining edges, the graph will remain connected.
 * Example 2:
 *
 * Input: n = 6, edges = [[1, 2], [1, 3], [2, 3], [2, 4], [2, 5], [4, 6], [5, 6]]
 *
 *
 * Output: []
 * Explanation:
 * We can remove any edge, the graph will remain connected.
 * Example 3:
 *
 * Input: n = 9, edges = [[1, 2], [1, 3], [2, 3], [3, 4], [3, 6], [4, 5], [6, 7], [6, 9], [7, 8], [8, 9]]
 *
 *
 * Output: [[3, 4], [3, 6], [4, 5]]
 */
public class CriticalConnections {
    public static List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        if (connections.size() == 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> graph = buildGraph(n, connections);
        int[] low = new int[n + 1];
        int[] discovery = new int[n + 1];
        Integer time = 0;
        Arrays.fill(discovery, -1);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 1; i < n + 1; i++) {
            if (discovery[i] == -1) {
                dfs(graph, time, i, i, low, discovery, res);
            }
        }
        Collections.sort(res, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.get(0) - o2.get(0);
            }
        });
        return res;
    }

    private static void dfs(List<List<Integer>> graph, Integer time, int cur, int parent, int[] low, int[] discovery, List<List<Integer>> res) {
        discovery[cur] = low[cur] = time++;

        for (Integer to : graph.get(cur)) {
            if (to == parent) {
                continue;
            }
            // not visit before
            if (discovery[to] == -1) {
                dfs(graph, time, to, cur, low, discovery, res);
                low[cur] = Math.min(low[cur], low[to]);
                if (low[to] > discovery[cur]) {
                    List<Integer> edge = Arrays.asList(cur, to);
                    Collections.sort(edge);
                    res.add(edge);
                }
            } else {
                low[cur] = Math.min(low[cur], discovery[to]);
            }
        }
    }

    private static List<List<Integer>> buildGraph(int n, List<List<Integer>> connections) {
        List<List<Integer>> graph = new LinkedList<>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new LinkedList<>());
        }
        for (List<Integer> edge : connections) {
            graph.get(edge.get(0)).add(edge.get(1));
            graph.get(edge.get(1)).add(edge.get(0));
        }
        return graph;
    }

    public static void main(String[] args) {
        List<List<Integer>> connections = Arrays.asList(Arrays.asList(1, 2),
                Arrays.asList(1, 3),
                Arrays.asList(2, 3),
                Arrays.asList(3, 4),
                Arrays.asList(3, 6),
                Arrays.asList(4, 5),
                Arrays.asList(6, 7),
                Arrays.asList(6, 9),
                Arrays.asList(7, 8),
                Arrays.asList(8, 9));
        System.out.println(criticalConnections(9, connections));
    }
}
