package leetcode.p;

/**
 * In a gold mine grid of size m * n, each cell in this mine has an integer representing the amount of gold in that cell, 0 if it is empty.
 * <p>
 * Return the maximum amount of gold you can collect under the conditions:
 * <p>
 * Every time you are located in a cell you will collect all the gold in that cell.
 * From your position you can walk one step to the left, right, up or down.
 * You can't visit the same cell more than once.
 * Never visit a cell with 0 gold.
 * You can start and stop collecting gold from any position in the grid that has some gold.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: grid = [[0,6,0],[5,8,7],[0,9,0]]
 * Output: 24
 * Explanation:
 * [[0,6,0],
 * [5,8,7],
 * [0,9,0]]
 * Path to get the maximum gold, 9 -> 8 -> 7.
 * Example 2:
 * <p>
 * Input: grid = [[1,0,7],[2,0,6],[3,4,5],[0,3,0],[9,0,20]]
 * Output: 28
 * Explanation:
 * [[1,0,7],
 * [2,0,6],
 * [3,4,5],
 * [0,3,0],
 * [9,0,20]]
 * Path to get the maximum gold, 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= grid.length, grid[i].length <= 15
 * 0 <= grid[i][j] <= 100
 * There are at most 25 cells containing gold.
 */
public class PathwithMaximumGold {
    int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int getMaximumGold(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int max = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] != 0) {
                    int cur = dfs(grid, i, j, new boolean[r][c]);
                    max = Math.max(max, cur);
                }
            }
        }
        return max;
    }

    int dfs(int[][] grid, int x, int y, boolean[][] visit) {
        int res = grid[x][y];
        visit[x][y] = true;
        for (int[] dir : dirs) {
            int xx = x + dir[0];
            int yy = y + dir[1];
            if (xx >= 0 && xx < grid.length && yy >= 0 && yy < grid[0].length
                    && !visit[xx][yy] && grid[xx][yy] != 0) {
                int cur = grid[x][y] + dfs(grid, xx, yy, visit);
                res = Math.max(res, cur);
            }
        }
        visit[x][y] = false;
        return res;
    }
}
