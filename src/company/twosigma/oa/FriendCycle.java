package company.twosigma.oa;
// Leetcode 547
public class FriendCycle {
    public int findCircleNum(int[][] M) {
        boolean[] visited = new boolean[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if(!visited[i]) {
                dfs(visited, M, i);
                count++;
            }
        }
        return count;
    }

    private void dfs(boolean[] visited, int[][] M, int cur) {
        if (visited[cur]) {
            return;
        }
        visited[cur] = true;
        for (int i = 0; i < M.length; i++) {
            if (M[cur][i] == 1 && !visited[i]) {
                dfs(visited, M, i);
            }
        }
    }
}
