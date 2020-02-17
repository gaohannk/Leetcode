package company.amazon.oa;

import java.util.*;

/**
 * You are given an undirected connected graph. An articulation point (or cut vertex) is defined as a vertex which, when removed along with associated edges, makes the graph disconnected (or more precisely, increases the number of connected components in the graph). The task is to find all articulation points in the given graph.
 *
 * Input:
 * The input to the function/method consists of three arguments:
 *
 * numNodes, an integer representing the number of nodes in the graph.
 * numEdges, an integer representing the number of edges in the graph.
 * edges, the list of pair of integers - A, B representing an edge between the nodes A and B.
 * Output:
 * Return a list of integers representing the critical nodes.
 *
 * Example:
 *
 * Input: numNodes = 7, numEdges = 7, edges = [[0, 1], [0, 2], [1, 3], [2, 3], [2, 5], [5, 6], [3, 4]]
 *
 *
 * Output: [2, 3, 5]
 */
public class CriticalRoutes {
    static int time = 0;

    private static List<Integer> getCriticalNodes(int[][] links, int numLinks, int numRouters) {
        time = 0;
        Map<Integer, Set<Integer>> map = buildGraph(links, numRouters);

        Set<Integer> res = new HashSet<>();
        int[] low = new int[numRouters];
        int[] discovery = new int[numRouters];
        int parent[] = new int[numRouters];
        Arrays.fill(discovery, -1);
        Arrays.fill(parent, -1);
        for (int i = 0; i < numRouters; i++) {
            if (discovery[i] == -1)
                dfs(map, low, discovery, parent, i, res);
        }
        List<Integer> ret = new ArrayList<>(res);
        Collections.sort(ret);
        return ret;
    }

    private static Map<Integer, Set<Integer>> buildGraph(int[][] links, int numRouters) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < numRouters; i++) {
            map.put(i, new HashSet<>());
        }
        for (int[] link : links) {
            map.get(link[0]).add(link[1]);
            map.get(link[1]).add(link[0]);
        }
        return map;
    }


    private static void dfs(Map<Integer, Set<Integer>> map, int[] low, int[] discovery, int[] parent, int cur, Set<Integer> res) {
        int children = 0;
        discovery[cur] = low[cur] = ++time;
        for (int nei : map.get(cur)) {
            if (nei == parent[cur]) {
                continue;
            }
            if (discovery[nei] == -1) {
                children++;
                parent[nei] = cur;
                dfs(map, low, discovery, parent, nei, res);
                low[cur] = Math.min(low[cur], low[nei]);
                if ((parent[cur] == -1 && children > 1) || (parent[cur] != -1 && low[nei] >= discovery[cur])) {
                    res.add(cur);
                }
            } else {
                low[cur] = Math.min(low[cur], discovery[nei]);
            }
        }
    }

    public static void main(String[] args) {
        int numRouters1 = 7;
        int numLinks1 = 7;
        int[][] links1 = {{0, 1}, {0, 2}, {1, 3}, {2, 3}, {2, 5}, {5, 6}, {3, 4}};
        System.out.println(getCriticalNodes(links1, numLinks1, numRouters1));
    }
}
