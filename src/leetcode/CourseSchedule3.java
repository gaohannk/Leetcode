package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/* There are a total of n courses you have to take, labeled from 0 to n - 1.
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, 
 * which is expressed as a pair: [0,1]
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 * For example:
 * 2, [[1,0]]
 * There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.
 * 2, [[1,0],[0,1]]
 * There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 * Note:
 * The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
 */
// BFS
public class CourseSchedule3 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null)
            return false;
        if (numCourses == 0 || prerequisites.length == 0)
            return true;
        int degree[] = new int[numCourses];
        // Store the course with input degree equals 0
        Queue<Integer> queue = new LinkedList();
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
        return count == numCourses;
    }
}
