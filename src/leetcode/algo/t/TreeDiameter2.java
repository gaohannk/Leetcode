package leetcode.algo.t;

import java.util.*;

public class TreeDiameter2 {

    private static class Node {
        int value;
        int distance;

        public Node(int node, int distance) {
            this.value = node;
            this.distance = distance;
        }
    }

    public static int treeDiameter(int[][] edges) {
        int n = edges.length + 1;

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            map.put(i, new LinkedList<>());
        }

        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        Node start = bfs(0, n, map);
        return bfs(start.value, n, map).distance;

    }

    private static Node bfs(int u, int n, Map<Integer, List<Integer>> map) {
        int[] distance = new int[n];
        Arrays.fill(distance, -1);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(u);
        distance[u] = 0;
        while (!queue.isEmpty()) {
            int poll = queue.poll();
            for (int i = 0; i < map.get(poll).size(); ++i) {
                int v = map.get(poll).get(i);
                if (distance[v] == -1) {
                    queue.add(v);
                    distance[v] = distance[poll] + 1;
                }
            }
        }

        int maxDistance = 0;
        int val = 0;
        for (int i = 0; i < n; ++i) {
            if (distance[i] > maxDistance) {
                maxDistance = distance[i];
                val = i;
            }
        }
        // return node which contains val and distance
        return new Node(val, maxDistance);
    }

    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {0, 2}};
        System.out.println(treeDiameter(edges));
    }
}
