package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 * <p>
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 * <p>
 * Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.
 * <p>
 * There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.
 * <p>
 * For example:
 * <p>
 * 2, [[1,0]]
 * <p>
 * There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1]
 * <p>
 * 4, [[1,0],[2,0],[3,1],[3,2]]
 * <p>
 * There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. So one correct course order is [0,1,2,3]. Another correct ordering is[0,2,1,3].
 * <p>
 * Note:
 * The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
 * <p>
 * click to show more hints.
 * <p>
 * Hints:
 * <p>
 * This problem is equivalent to finding the topological order in a directed graph. If a cycle exists, no topological ordering exists and therefore it will be impossible to take all courses.
 * Topological Sort via DFS - A great video tutorial (21 minutes) on Coursera explaining the basic concepts of Topological Sort.
 * Topological sort could also be done via BFS.
 */
public class CourseScheduleII2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (prerequisites == null)
            return null;

        // Edge case No prerequisites e.g. 2,[]
        if (prerequisites.length == 0) {
            int[] res = new int[numCourses];
            for (int i = 0; i < res.length; i++) {
                res[i] = i;
            }
            return res;
        }

        int degree[] = new int[numCourses];
        // Store the course with input degree equals 0
        Queue<Integer> queue = new LinkedList();
        int[] res = new int[numCourses];
        int index = 0;
        for (int edge[] : prerequisites) {
            degree[edge[0]]++;
        }
        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0)
                queue.add(i);
        }
        int count = queue.size();
        while (!queue.isEmpty()) {
            int p = queue.poll();
            res[index++] = p;
            for (int edge[] : prerequisites) {
                if (edge[1] == p) {
                    degree[edge[0]]--;
                    if (degree[edge[0]] == 0) {
                        count++;
                        queue.add(edge[0]);
                    }
                }
            }

        }
        // Cycle exist
        if (count != numCourses)
            return new int[]{};
        return res;
    }
}
