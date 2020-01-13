package company.hardforme;

import java.util.LinkedList;
import java.util.Queue;

/**
 * L ← Empty list that will contain the sorted elements
 * S ← Set of all nodes with no incoming edge
 *
 * while S is non-empty do
 *     remove a node n from S
 *     add n to tail of L
 *     for each node m with an edge e from n to m do
 *         remove edge e from the graph
 *         if m has no other incoming edges then
 *             insert m into S
 *
 * if graph has edges then
 *     return error   (graph has at least one cycle)
 * else
 *     return L   (a topologically sorted order)
 */
public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        boolean[] hasPrequesite = new boolean[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            hasPrequesite[prerequisites[i][0]] = true;
        }
        for (int i = 0; i < hasPrequesite.length; i++) {
            if (hasPrequesite[i] == false) {
                queue.offer(i);
            }
        }
        int id = 0;
        boolean[] visited = new boolean[prerequisites.length];

        while (!queue.isEmpty()) {
            res[id] = queue.poll();
            for (int i = 0; i < prerequisites.length; i++) {
                if (visited[i] == true) {
                    continue;
                }
                if (prerequisites[i][1] == res[id]) {
                    visited[i] = true;
                    if (noOtherIncome(prerequisites, prerequisites[i][0], visited, i)) {
                        queue.offer(prerequisites[i][0]);
                    }
                }
            }
            id++;
        }
        for (boolean visit : visited) {
            if (visit == false) {
                return new int[]{};
            }
        }
        return res;
    }

    private boolean noOtherIncome(int[][] prerequisites, int node, boolean[] visited, int cur) {
        for (int i = 0; i < prerequisites.length; i++) {
            if (visited[i] || i == cur) {
                continue;
            }
            if (prerequisites[i][0] == node) {
                return false;
            }
        }
        return true;
    }
}