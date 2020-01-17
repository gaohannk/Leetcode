package leetcode.algo.c;

import java.util.*;

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
//DFS using white gray black set
public class CourseSchedule4 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Set<Integer> white = new HashSet<>();
        Set<Integer> gray = new HashSet<>();
        Set<Integer> black = new HashSet<>();

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < prerequisites.length; i++) {
            if (!map.containsKey(prerequisites[i][1])) {
                map.put(prerequisites[i][1], new LinkedList<>());
            }
            map.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        for (int i = 0; i < numCourses; i++) {
            white.add(i);
        }

        while (!white.isEmpty()) {
            int course = white.iterator().next();
            if (dfs(map, course, white, gray, black)) {
                return false; // has cycle can't finish
            }
        }
        return true;
    }

    private boolean dfs(Map<Integer, List<Integer>> map, int course, Set<Integer> white, Set<Integer> gray, Set<Integer> black) {
        white.remove(course);
        gray.add(course);
        if (map.get(course) != null) {

            for (Integer neibour : map.get(course)) {
                if (gray.contains(neibour)) {
                    return true; // has cycle
                }
                if (black.contains(neibour)) {
                    continue;
                }
                if (dfs(map, neibour, white, gray, black)) {
                    return true;
                }

            }
        }
        gray.remove(course);
        black.add(course);
        return false;
    }
}
