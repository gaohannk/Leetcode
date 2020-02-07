package leetcode.algo.n;

import java.util.*;
// TLE
public class NumberofIslandsII {
    void dfs(char[][] grid, int r, int c, boolean[][] visited) {
        int row = grid.length;
        int col = grid[0].length;

        if (r < 0 || c < 0 || r >= row || c >= col || grid[r][c] == '0' || visited[r][c]) {
            return;
        }

        visited[r][c] = true;
        dfs(grid, r - 1, c, visited);
        dfs(grid, r + 1, c, visited);
        dfs(grid, r, c - 1, visited);
        dfs(grid, r, c + 1, visited);
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        for (boolean[] line : visited) {
            Arrays.fill(line, false);
        }
        int count = 0;
        for (int r = 0; r < row; ++r) {
            for (int c = 0; c < col; ++c) {
                if (grid[r][c] == '1' && !visited[r][c]) {
                    count++;
                    dfs(grid, r, c, visited);
                }
            }
        }

        return count;
    }

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> ans = new ArrayList<>();
        char[][] grid = new char[m][n];
        for (char[] row : grid) {
            Arrays.fill(row, '0');
        }
        for (int[] pos : positions) {
            grid[pos[0]][pos[1]] = '1';
            ans.add(numIslands(grid));
        }
        return ans;
    }
}
