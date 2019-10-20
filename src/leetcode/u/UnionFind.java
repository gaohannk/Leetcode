package leetcode.u;

public class UnionFind {
    int[] parent;

    public UnionFind(int n) {
        parent = new int[n];
        for (int i = 0; i < n; ++i) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        while (x != parent[x]) {
            x = parent[x];
        }
        return x;
    }

    public void union(int x, int y) {
        parent[find(x)] = find(y);
    }

    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }

    public int getCount() {
        return parent.length;
    }
}