package leetcode.algo.c;

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
//DFS using one set with different status
public class CourseSchedule {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		// 0 for white, unvisited
		// 1 for grey, in stack
		// 2 for black, fully explored
		int[] status = new int[numCourses];
		for (int i = 0; i < numCourses; i++) {
			if (status[i] == 0) {
				if (DFS(i, prerequisites, status)) {
					return false;
				}
			}
		}
		return true;
	}

	private boolean DFS(int curr, int[][] prerequisites, int[] status) {
		if (status[curr] == 1) {
			return true; // has cycle
		}
		status[curr] = 1;
		for (int[] p : prerequisites) {
			if (p[0] == curr && status[p[1]] != 2) {
				if (DFS(p[1], prerequisites, status)) {
					return true;
				}
			}
		}
		status[curr] = 2;
		return false;
	}

}
