package leetcode.s;

/*
On a N * N grid, we place some 1 * 1 * 1 cubes.

Each value v = grid[i][j] represents a tower of v cubes placed on top of grid cell (i, j).

Return the total surface area of the resulting shapes.



Example 1:

Input: [[2]]
Output: 10
Example 2:

Input: [[1,2],[3,4]]
Output: 34
Example 3:

Input: [[1,0],[0,2]]
Output: 16
Example 4:

Input: [[1,1,1],[1,0,1],[1,1,1]]
Output: 32
Example 5:

Input: [[2,2,2],[2,1,2],[2,2,2]]
Output: 46


Note:

1 <= N <= 50
0 <= grid[i][j] <= 50


 */
public class SurfaceAreaof3DShapes {
    public int surfaceArea(int[][] grid) {
        int[] dr = new int[]{0, 1, 0, -1};
        int[] dc = new int[]{1, 0, -1, 0};

        int row = grid.length, col = grid[0].length;
        int ans = 0;

        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++)
                if (grid[i][j] > 0) {
                    ans += 2;
                    for (int k = 0; k < 4; k++) {
                        int nr = i + dr[k];
                        int nc = j + dc[k];
                        int tall = 0;
                        if (0 <= nr && nr < row && 0 <= nc && nc < col)
                            tall = grid[nr][nc];

                        ans += Math.max(grid[i][j] - tall, 0);
                    }
                }

        return ans;
    }

    public int surfaceArea2(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        int top = 0, l = 0;
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                l += i == 0 ? grid[i][j] : Math.abs(grid[i][j] - grid[i - 1][j]);
                if (i == row - 1) {
                    l += grid[i][j];
                }
                l += j == 0 ? grid[i][j] : Math.abs(grid[i][j] - grid[i][j - 1]);
                if (j == col - 1) {
                    l += grid[i][j];
                }
                top += grid[i][j] > 0 ? 1 : 0;
            }
        }
        return 2 * (top) + l;
    }
}
