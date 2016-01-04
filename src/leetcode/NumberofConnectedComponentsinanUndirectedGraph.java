package leetcode;

/* Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), 
 * write a function to find the number of connected components in an undirected graph.
 * Example 1:
     0          3
     |          |
     1 --- 2    4
 * Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], return 2.
 * Example 2:
     0           4
     |           |
     1 --- 2 --- 3
 * Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]], return 1.

Note:
You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
*/
public class NumberofConnectedComponentsinanUndirectedGraph {

	public int countComponents(int n, int[][] edges) {
		UnionFind uf = new UnionFind(n);
		for (int i = 0; i < edges[0].length; i++) {
			if (!uf.isConnected(edges[i][0], edges[i][1])) {
				uf.unite(edges[i][0], edges[i][1]);
			}
		}
		return uf.getCount();
	}

	class UnionFind {
		int[] id;
		int count;

		public UnionFind(int n) {
			this.id = new int[n];
			this.count = n;
			for (int i = 0; i < count; i++)
				id[i] = i;
		}

		public boolean isConnected(int i, int j) {
			return root(i) == root(j);
		}

		private int root(int i) {
			while (i != id[i]) {
				i = id[i];
			}
			return i;
		}

		public int getCount() {
			return count;
		}

		public void unite(int p, int q) {
			int i = root(p);
			int j = root(q);
			id[i] = j;
		}
	}

}
