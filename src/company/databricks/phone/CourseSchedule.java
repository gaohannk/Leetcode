package company.databricks.phone;

import java.util.*;

public class CourseSchedule {
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
