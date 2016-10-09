package leetcode;

import java.util.ArrayList;
import java.util.HashMap;

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
//DFS
public class CourseSchedule4 {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        // 参数检查
        if (prerequisites == null) {
            return false;
        }
        int len = prerequisites.length;
        if (numCourses <= 0 || len == 0) {
            return true;
        }
        int[] visit = new int[numCourses];
        // key：course；value：以该course为prerequisites的course
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        // 初始化map
        for (int[] p : prerequisites) {
            if (map.containsKey(p[1])) {
                map.get(p[1]).add(p[0]);
            } else {
                ArrayList<Integer> l = new ArrayList<Integer>();
                l.add(p[0]);
                map.put(p[1], l);
            }
        }
        // dfs
        for (int i = 0; i < numCourses; i++) {
            if (!canFinishDFS(map, visit, i)) {
                return false;
            }
        }
        return true;
    }

    private static boolean canFinishDFS(
            HashMap<Integer, ArrayList<Integer>> map, int[] visit, int i) {
        if (visit[i] == -1) {
            return false;
        }
        if (visit[i] == 1) {
            return true;
        }
        visit[i] = -1;
        // course i是某些course的prerequisites
        if (map.containsKey(i)) {
            for (int j : map.get(i)) {
                if (!canFinishDFS(map, visit, j)) {
                    return false;
                }
            }
        }
        visit[i] = 1;
        return true;
    }
}
