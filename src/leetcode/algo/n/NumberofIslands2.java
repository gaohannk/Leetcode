package leetcode.algo.n;
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

public class NumberofIslands2 {
    static int res = 0;
    static boolean[][] visited;
    static int[] deltax = new int[]{0, 1, -1, 0};
    static int[] deltay = new int[]{1, 0, 0, -1};

    public static int numIslands(char[][] grid) {
        if (grid.length == 0)
            return 0;
        int row = grid.length;
        int col = grid[0].length;
        visited = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] != '0' && visited[i][j] == false) {
                    helper(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    private static void helper(char[][] matrix, int i, int j) {
        int row = matrix.length;
        int col = matrix[0].length;
        if (visited[i][j] == true || matrix[i][j] == '0')
            return;
        visited[i][j] = true;
        for (int k = 0; k < 4; k++) {
            if (i + deltax[k] >= 0 && i + deltax[k] < row && j + deltay[k] >= 0 && j + deltay[k] < col && matrix[i + deltax[k]][j + deltay[k]] == '1') {
                helper(matrix, i + deltax[k], j + deltay[k]);
            }
        }
    }

    public static void main(String[] args) {
        char[][] matrix = {{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};
        int res = numIslands(matrix);
        System.out.print(res);
    }
}
