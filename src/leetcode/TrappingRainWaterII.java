package leetcode;

import java.util.LinkedHashSet;
import java.util.PriorityQueue;

/*Given an m x n matrix of positive integers representing the height of each unit cell in a 2D elevation map, compute the volume of water it is able to trap after raining.

Note:
Both m and n are less than 110. The height of each unit cell is greater than 0 and is less than 20,000.

Example:

Given the following 3x6 height map:
[
  [1,4,3,1,3,2],
  [3,2,1,3,2,4],
  [2,3,3,2,3,1]
]

Return 4.
*/
public class TrappingRainWaterII {
	class Cell {
		int x;
		int y;
		int h;

		Cell(int x, int y, int height) {
			this.x = x;
			this.y = y;
			this.h = height;
		}
	}

	public int trapRainWater(int[][] heightMap) {
		if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) {
			return 0;
		}

		int m = heightMap.length;
		int n = heightMap[0].length;
		PriorityQueue<Cell> pq = new PriorityQueue<>((v1, v2) -> v1.h - v2.h);
		boolean[][] visited = new boolean[m][n];
		for (int i = 0; i < n; i++) {
			visited[0][i] = true;
			visited[m - 1][i] = true;
			pq.offer(new Cell(0, i, heightMap[0][i]));
			pq.offer(new Cell(m - 1, i, heightMap[m - 1][i]));
		}
		for (int i = 1; i < m - 1; i++) {
			visited[i][0] = true;
			visited[i][n - 1] = true;
			pq.offer(new Cell(i, 0, heightMap[i][0]));
			pq.offer(new Cell(i, n - 1, heightMap[i][n - 1]));
		}
		int[] xs = { 0, 0, 1, -1 };
		int[] ys = { 1, -1, 0, 0 };
		int sum = 0;
		while (!pq.isEmpty()) {
			Cell cell = pq.poll();
			for (int i = 0; i < 4; i++) {
				int nx = cell.x + xs[i];
				int ny = cell.y + ys[i];
				if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny]) {
					visited[nx][ny] = true;
					sum += Math.max(0, cell.h - heightMap[nx][ny]);
					pq.offer(new Cell(nx, ny, Math.max(heightMap[nx][ny], cell.h)));
				}
			}
		}
		return sum;
	}
}
