package leetcode;

/* Follow up for N-Queens problem.
 * Now, instead outputting board configurations, return the total number of distinct solutions.
 */
public class NQueensII {
	public int totalNQueens(int n) {
		int[] res = new int[1];
		helper(n, 0, new int[n], res);
		return res[0];
	}

	private void helper(int n, int row, int[] columnForRow, int[] res) {
		if (row == n) {
			res[0]++;
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
