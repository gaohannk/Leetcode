package leetcode;

import java.util.*;
// TLE
public class TreeDiameter {

    public static int treeDiameter(int[][] edges) {
        if (edges == null) {
            return 0;
        }

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int[] edge : edges) {
            if (map.get(edge[0]) == null) {
                map.put(edge[0], new LinkedList<>());
            }
            map.get(edge[0]).add(edge[1]);

            if (map.get(edge[1]) == null) {
                map.put(edge[1], new LinkedList<>());
            }
            map.get(edge[1]).add(edge[0]);
        }

        int max = 0;
        for (int cur : map.keySet()) {
            boolean[] visited = new boolean[map.keySet().size()];
            // BFS on each node (TLE)
            int depth = bfs(map, cur, visited);
            max = Math.max(max, depth);
        }

        return max;
    }

    public static int bfs(Map<Integer, List<Integer>> map, int root, boolean[] visited) {
        int depth = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(root);
        System.out.println(queue);
        while (!queue.isEmpty()) {
            Queue<Integer> nextLayer = new LinkedList<>();
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                visited[cur] = true;
                for (int i = 0; i < map.get(cur).size(); i++) {
                    if (!visited[map.get(cur).get(i)]) {
                        nextLayer.add(map.get(cur).get(i));
                    }
                }
            }
            if(nextLayer.isEmpty()){
                break;
            }
            queue = nextLayer;
            depth++;
        }
        return depth;
    }

    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {0, 2}};
        System.out.println(treeDiameter(edges));
    }
}
