package leetcode;

/** We have a 2D grid. Each cell is either a wall, an enemy or empty.
 * For example (0-empty, X-enemy, Y-wall):
 * 0 X 0 0
 * X 0 Y X
 * 0 X 0 0
 * You have one bomb and you want to kill as many as possible enemies with it. The bomb will kill all the enemies in the same row and columnfrom the planted point until it hits the wall since the wall is too strong to be destroyed.
 * Given such a grid, return the maximum enemies you can kill with one bomb.
 * Note that you can only put the bomb at empty cell.
 * In the example, if you put a bomb at (1,1) you will kill 3 enemies which is the best you can get. You can not kill the guy behind the wall at (1,3).
 * */
public class BombEnemy {
	public int maxKilledEnemies(char[][] grid) {
		if (grid == null)
			return 0;
		int row = grid.length;
		int col = grid[0].length;
		int[][] left = new int[row][col];
		int[][] right = new int[row][col];
		int[][] up = new int[row][col];
		int[][] down = new int[row][col];
		int res = 0;
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (j == 0 || grid[i][j] == 'Y')
					left[i][j] = 0;
				else if (grid[i][j] == '0')
					left[i][j] = left[i][j - 1];
				else if (grid[i][j] == 'E')
					left[i][j] = left[i][j - 1] + 1;
			}
			for (int j = col - 1; j > 0; j--) {
				if (j == col - 1 || grid[i][j] == 'Y')
					right[i][j] = 0;
				else if (grid[i][j] == '0')
					right[i][j] = right[i][j + 1];
				else if (grid[i][j] == 'E')
					right[i][j] = right[i][j + 1] + 1;
			}
		}
		for (int j = 0; j < col; j++) {
			for (int i = 0; i < row; i++) {
				if (i == 0 || grid[i][j] == 'Y')
					up[i][j] = 0;
				else if (grid[i][j] == '0')
					up[i][j] = up[i - 1][j];
				else if (grid[i][j] == 'E')
					up[i][j] = up[i - 1][j] + 1;
			}
			for (int i = row - 1; i >= 0; i--) {
				if (i == row - 1 || grid[i][j] == 'Y')
					down[i][j] = 0;
				else if (grid[i][j] == '0')
					down[i][j] = down[i + 1][j];
				else if (grid[i][j] == 'E')
					down[i][j] = down[i + 1][j] + 1;
			}
		}
		for (int i = 0; i < row; ++i) {
			for (int j = 0; j < col; ++j) {
				if (grid[i][j] == '0') {
					res = Math.max(res, left[i][j] + right[i][j] + up[i][j] + down[i][j]);
				}
			}
		}
		return res;
	}
}
