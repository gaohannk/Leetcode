package leetcode;

import java.util.ArrayList;

/* The n-queens puzzle is the problem of placing n queens on an n×n chess board such that 
 * no two queens attack each other.
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' 
 * both indicate a queen and an empty space respectively.
 * There exist two distinct solutions to the 4-queens puzzle:
 */
/* 判断列是否冲突，只需要看state数组中state[0…k-1] 是否有和state[k]相等；
 * 判断对角线是否冲突：如果两个皇后在同一对角线，那么|row1-row2|=|column1-column2|，
 * 其中（row1，column1），（row2，column2）分别为冲突的两个皇后的位置
 */
public class NQueens {
	public ArrayList<String[]> solveNQueens(int n) {
		ArrayList<String[]> res = new ArrayList<String[]>();
		helper(n, 0, new int[n], res);
		return res;
	}
	private void helper(int n, int row, int[] columnForRow, ArrayList<String[]> res) {
		if (row == n) {
			String[] item = new String[n];
			for (int i = 0; i < n; i++) {
				StringBuilder strRow = new StringBuilder();
				for (int j = 0; j < n; j++) {
					if (columnForRow[i] == j)
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
			columnForRow[row] = i;
			if (check(row, columnForRow)) 
				helper(n, row + 1, columnForRow, res);
		}
	}
	
	private boolean check(int row, int[] columnForRow) {
		for (int i = 0; i < row; i++) {
			if (columnForRow[row] == columnForRow[i] || Math.abs(columnForRow[row] - columnForRow[i]) == row - i)
				return false;
		}
		return true;
	}
}
