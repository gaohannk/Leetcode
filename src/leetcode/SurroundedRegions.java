package leetcode;

import java.util.Stack;

/* Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 * For example,
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * After running your function, the board should be:
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 */
public class SurroundedRegions {
	public void solve(char[][] board) {
		if (board.length == 0)
			return;
		Stack<Integer> xindex = new Stack<Integer>();
		Stack<Integer> yindex = new Stack<Integer>();
		int row = board.length;
		int column = board[0].length;
		for (int i = 0; i < row; i++) {
			if (board[i][0] == 'O') {
				xindex.push(i);
				yindex.push(0);
			}
			if (board[i][column - 1] == 'O') {
				xindex.push(i);
				yindex.push(column - 1);
			}
		}
		for (int i = 0; i < column; i++) {
			if (board[0][i] == 'O') {
				xindex.push(0);
				yindex.push(i);
			}
			if (board[row - 1][i] == 'O') {
				xindex.push(row - 1);
				yindex.push(i);
			}
		}

		while (!xindex.empty()) {
			int x = xindex.pop();
			int y = yindex.pop();
			board[x][y] = '#';
			if (x > 0 && board[x - 1][y] == 'O') {
				xindex.push(x - 1);
				yindex.push(y);
			}
			if (x < row - 1 && board[x + 1][y] == 'O') {
				xindex.push(x + 1);
				yindex.push(y);
			}
			if (y > 0 && board[x][y - 1] == 'O') {
				xindex.push(x);
				yindex.push(y - 1);
			}
			if (y < column - 1 && board[x][y + 1] == 'O') {
				xindex.push(x);
				yindex.push(y + 1);
			}
		}
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				if (board[i][j] == 'O')
					board[i][j] = 'X';
				if (board[i][j] == '#')
					board[i][j] = 'O';
			}
		}
	}
}
