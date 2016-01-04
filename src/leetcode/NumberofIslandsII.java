package leetcode;

import java.util.ArrayList;
import java.util.List;

/* A 2d grid map of m rows and n columns is initially filled with water. 
 * We may perform an addLand operation which turns the water at position (row, col) into a land. 
 * Given a list of positions to operate, count the number of islands after each addLand operation. 
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
 * You may assume all four edges of the grid are all surrounded by water.
 * Example:
 * Given m = 3, n = 3, positions = [[0,0], [0,1], [1,2], [2,1]].
 * Initially, the 2d grid grid is filled with water. (Assume 0 represents water and 1 represents land).
 * 0 0 0
 * 0 0 0
 * 0 0 0
 * Operation #1: addLand(0, 0) turns the water at grid[0][0] into a land.
 * 1 0 0
 * 0 0 0   Number of islands = 1
 * 0 0 0
 * Operation #2: addLand(0, 1) turns the water at grid[0][1] into a land.
 * 1 1 0
 * 0 0 0   Number of islands = 1
 * 0 0 0
 * Operation #3: addLand(1, 2) turns the water at grid[1][2] into a land.
 * 1 1 0
 * 0 0 1   Number of islands = 2
 * 0 0 0
 * Operation #4: addLand(2, 1) turns the water at grid[2][1] into a land.
 * 1 1 0
 * 0 0 1   Number of islands = 3
 * 0 1 0
 * We return the result as an array: [1, 1, 2, 3]
 */
public class NumberofIslandsII {

	private int[][] dir = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };

	public List<Integer> numIslands2(int m, int n, int[][] positions) {
		UnionFind2D islands = new UnionFind2D(m, n);
		List<Integer> res = new ArrayList<>();
		for (int[] position : positions) {
			int x = position[0], y = position[1];
			int p = islands.add(x, y);
			for (int[] d : dir) {
				int q = islands.getID(x + d[0], y + d[1]);
				if (q > 0 && !islands.find(p, q))
					islands.unite(p, q);
			}
			res.add(islands.size());
		}
		return res;
	}
}

class UnionFind2D {
	private int[] id;
	private int[] sz;
	private int row, col, count;

	public UnionFind2D(int m, int n) {
		this.count = 0;
		this.col = n;
		this.row = m;
		this.id = new int[m * n + 1];
		this.sz = new int[m * n + 1];
	}

	public int index(int x, int y) {
		return x * col + y + 1;
	}

	public int size() {
		return this.count;
	}

	public int getID(int x, int y) {
		if (0 <= x && x < row && 0 <= y && y < col)
			return id[index(x, y)];
		return 0;
	}

	public int add(int x, int y) {
		int i = index(x, y);
		id[i] = i;
		sz[i] = 1;
		count++;
		return i;
	}

	public boolean find(int p, int q) {
		return root(p) == root(q);
	}

	public void unite(int p, int q) {
		int i = root(p), j = root(q);
		if (sz[i] < sz[j]) { // weighted quick union
			id[i] = j;
			sz[j] += sz[i];
		} else {
			id[j] = i;
			sz[i] += sz[j];
		}
		count--;
	}

	private int root(int i) {
		for (; i != id[i]; i = id[i])
			id[i] = id[id[i]]; // path compression
		return i;
	}
}
