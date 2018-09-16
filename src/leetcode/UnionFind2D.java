package leetcode;

/**
 * Created by gaohan on 8/4/18.
 */
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
