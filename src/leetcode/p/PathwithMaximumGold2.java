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
public class PathwithMaximumGold2 {

    int max = 0;

    public int getMaximumGold(int[][] grid) {
        int visited[][] = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                dfs(i, j, grid, visited, 0);
            }
        }
        return max;
    }

    private void dfs(int i, int j, int[][] grid, int visited[][], int sum) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length)
            return;
        if (grid[i][j] == 0)
            return;
        if (visited[i][j] == 1)
            return;

        sum += grid[i][j];
        max = Math.max(max, sum);
        // update
        visited[i][j] = 1;
        dfs(i, j - 1, grid, visited, sum);
        dfs(i, j + 1, grid, visited, sum);
        dfs(i - 1, j, grid, visited, sum);
        dfs(i + 1, j, grid, visited, sum);
        visited[i][j] = 0;

    }
}
