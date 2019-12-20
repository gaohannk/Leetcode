package leetcode.algo;

// DFS TLE
public class DeleteTreeNodes {
    public int deleteTreeNodes(int nodes, int[] parent, int[] value) {
        for (int i = nodes; i >=0; i--) {
            if (getSum(parent, value, i, value[i]) == 0) {
                remove(parent, value, i);
            }
        }
        int count = 0;
        for (int i = 0; i < nodes; i++) {
            if (parent[i] != -1) {
                count++;
            }
        }
        return count + 1;
    }

    private void remove(int[] parent, int[] value, int cur) {
        parent[cur] = -1;
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == cur) {
                parent[i] = -1; // mark -1 as remove
                remove(parent, value, i);
            }
        }
    }

    private int getSum(int[] parent, int[] value, int cur, int sum) {
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == cur) { // child node
                sum += getSum(parent, value, i, value[i]);
            }
        }
        return sum;
    }
}
