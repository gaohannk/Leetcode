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
/* BFS iterative
 * 
 */
public class WallsandGates {

	public void wallsAndGates(int[][] rooms) {
		if (rooms.length == 0)
			return;
		int row = rooms.length;
		int col = rooms[0].length;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				// 如果遇到一个门，从门开始广度优先搜索，标记连通的节点到自己的距离
				if (rooms[i][j] == 0)
					bfs(rooms, i, j);
			}
		}
	}

	public void bfs(int[][] rooms, int i, int j) {
		Queue<Integer> queuex = new LinkedList<Integer>();
		Queue<Integer> queuey = new LinkedList<Integer>();
		queuex.offer(i);
		queuey.offer(j);
		int dist = 0;
		int row = rooms.length;
		int col = rooms[0].length;
		boolean[][] visit = new boolean[row][col];
		visit[i][j]=true;
		while (!queuex.isEmpty() && !queuey.isEmpty()) {
			for (int id = 0; id < queuex.size(); id++) {
				int x = queuex.poll();
				int y = queuey.poll();
				rooms[x][y] = Math.min(rooms[x][y], dist);
				if (x > 1 && rooms[x - 1][y] > 0 && !visit[x - 1][y]) {
					queuex.offer(x - 1);
					queuey.offer(y);
					visit[x - 1][y] = true;
				}
				if (y > 1 && rooms[x][y - 1] > 0 && !visit[x][y - 1]) {
					queuex.offer(x);
					queuey.offer(y - 1);
					visit[x][y - 1] = true;

				}
				if (x + 1 < row && rooms[x + 1][y] > 0 && !visit[x + 1][y]) {
					queuex.offer(x + 1);
					queuey.offer(y);
					visit[x + 1][y] = true;

				}
				if (y + 1 < col && rooms[x][y + 1] > 0 && !visit[x][y + 1]) {
					queuex.offer(x);
					queuey.offer(y + 1);
					visit[x][y + 1] = true;
				}
			}
			dist++;
		}
	}
}
