package leetcode;

import java.util.ArrayList;

/* The n-queens puzzle is the problem of placing n queens on an n×n chess board such that no two queens attack each other.
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' 
 * both indicate a queen and an empty space respectively.
 * There exist two distinct solutions to the 4-queens puzzle:
 */
public class NQueens2 {
	public ArrayList<String[]> solveNQueens(int n) {
		ArrayList<String[]> res = new ArrayList<String[]>();
		helper(n, 0, new int[n][n], res);
		return res;
	}

	private void helper(int n, int row, int[][] columnForRow, ArrayList<String[]> res) {
		if (row == n) {
			String[] item = new String[n];
			for (int i = 0; i < n; i++) {
				StringBuilder strRow = new StringBuilder();
				for (int j = 0; j < n; j++) {
					if (columnForRow[i][j] == 1)
						strRow.append('Q');
					else
						strRow.append('.');
				}
				item[i] = strRow.toString();
			}
			res.add(item);
			return;
		}
		for (int i = 0; i < n; i++) {
			columnForRow[row][i] = 1;
			if (check(row, i, columnForRow))
				helper(n, row + 1, columnForRow, res);
		}
	}

	private boolean check(int row, int col, int[][] columnForRow) {
		for (int i = 0; i < row; i++)
			if (columnForRow[i][col] == 1)
				return false;
		// 右对角线(只需要判断对角线上半部分，因为后面的行还没有开始放置)
		for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
			if (columnForRow[i][j] == 1)
				return false;
		// 左对角线(只需要判断对角线上半部分，因为后面的行还没有开始放置)
		for (int i = row - 1, j = col + 1; i >= 0 && j < columnForRow.length; i--, j++)
			if (columnForRow[i][j] == 1)
				return false;
		return true;
	}
}
