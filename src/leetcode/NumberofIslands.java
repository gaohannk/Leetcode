package leetcode;
/* Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. 
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
 * You may assume all four edges of the grid are all surrounded by water.
 * Example 1:
 * 11110
 * 11010
 * 11000
 * 00000
 * Answer: 1
 * Example 2:
 * 11000
 * 11000
 * 00100
 * 00011
 * Answer: 3
 */

public class NumberofIslands {
    public int numIslands(char[][] grid) {
        if (grid.length == 0)
            return 0;
        int row = grid.length;
        int col = grid[0].length;

        boolean[][] checker = new boolean[row][col];
        int res = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] != '0' && checker[i][j] == false) {
                    helper(grid, checker, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    private static void helper(char[][] matrix, boolean[][] checker, int i, int j) {
        int row = matrix.length;
        int col = matrix[0].length;
        if (checker[i][j] == true || matrix[i][j] == '0')
            return;
        checker[i][j] = true;
        if (j + 1 < col && matrix[i][j + 1] == '1')
            helper(matrix, checker, i, j + 1);
        if (j - 1 >= 0 && matrix[i][j - 1] == '1')
            helper(matrix, checker, i, j - 1);
        if (i + 1 < row && matrix[i + 1][j] == '1')
            helper(matrix, checker, i + 1, j);
        if (i - 1 >= 0 && matrix[i - 1][j] == '1')
            helper(matrix, checker, i - 1, j);
        return;
    }
}
