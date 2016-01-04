package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/* You are given a m x n 2D grid initialized with these three possible values.
 * -1 - A wall or an obstacle.
 * 0 - A gate.
 * INF - Infinity means an empty room. 
 * We use the value 2^31 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than2147483647.
 * Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.
 * For example, given the 2D grid:
 * INF  -1  0  INF
 * INF INF INF  -1
 * INF  -1 INF  -1
 * 0  -1 INF INF
 * After running your function, the 2D grid should be:
 * 3  -1   0   1
 * 2   2   1  -1
 * 1  -1   2  -1
 * 0  -1   3   4
 */
/*
 * DFS recursive
 */
public class WallsandGates3 {

	public void wallsAndGates(int[][] rooms) {
		if (rooms.length == 0)
			return;
		int row = rooms.length;
		int col = rooms[0].length;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				int dist = 0;
				boolean[][] visit = new boolean[row][col];
				if (rooms[i][j] == 0)
					dfs(rooms, i, j, dist, visit);
			}
		}
	}

	private void dfs(int[][] rooms, int i, int j, int dist, boolean[][] visit) {
		if (i > 0 && i < rooms.length && j > 0 && j < rooms[0].length && !visit[i][j] && rooms[i][j] > 0) {
			rooms[i][j]=dist;
			dfs(rooms, i - 1, j, dist + 1, visit);
			dfs(rooms, i + 1, j, dist + 1, visit);
			dfs(rooms, i, j - 1, dist + 1, visit);
			dfs(rooms, i, j + 1, dist + 1, visit);
		}
	}
}
