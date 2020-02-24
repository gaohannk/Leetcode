package company.qualtric;

/**
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
 *
 * Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)
 *
 * Example 1:
 * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,1,1,0,1,0,0,0,0,0,0,0,0],
 *  [0,1,0,0,1,1,0,0,1,0,1,0,0],
 *  [0,1,0,0,1,1,0,0,1,1,1,0,0],
 *  [0,0,0,0,0,0,0,0,0,0,1,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * Given the above grid, return 6. Note the answer is not 11, because the island must be connected 4-directionally.
 * Example 2:
 * [[0,0,0,0,0,0,0,0]]
 * Given the above grid, return 0.
 * Note: The length of each dimension in the given grid does not exceed 50.
 */
public class MaxAreaofIsland2 {
    static int[][] dirs = new int[][]{{1, 0}, {0, 1}, {0, -1}, {-1, 0}};

    public static int largestIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int max = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    int[] size = new int[1];
                    size[0] = 1;
                    visited[i][j] = true;
                    dfs(grid, i, j, visited, size);
                    max = Math.max(max, size[0]);
                }
            }
        }
        return max;
    }

    private static void dfs(int[][] grid, int i, int j, boolean[][] visited, int[] size) {
        for (int k = 0; k < 4; k++) {
            int nx = i + dirs[k][0];
            int ny = j + dirs[k][1];
            if (nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length) {
                if (!visited[nx][ny] && grid[nx][ny] == 1) {
                    size[0]++;
                    visited[nx][ny] = true;
                    dfs(grid, nx, ny, visited, size);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1,1,0,0,0},
                {1,1,0,0,0},
                {0,0,1,0,0},
                {0,0,0,1,1},
        };
        System.out.println(largestIsland(grid));
    }
}
