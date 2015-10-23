package leetcode;

/* Given a 2D board and a word, find if the word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 * For example,
 * Given board =
 * [
 *   ["ABCE"],
 *   ["SFCS"],
 *   ["ADEE"]
 * ]
 * word = "ABCCED", -> returns true,
 * word = "SEE", -> returns true,
 * word = "ABCB", -> returns false.
 */
public class WordSearch {
	public boolean exist(char[][] board, String word) {
		if (board == null || board.length == 0 || word == null || word.length() == 0)
			return false;
		boolean[][] checker = new boolean[board.length][board[0].length];

		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[0].length; col++) {
				if (isFind(checker, board, word, 0, row, col)) {
					return true;
				}
			}

		}
		return false;
	}

	private boolean isFind(boolean[][] checker, char[][] board, String word, int i, int row, int col) {
		if (board[row][col] != word.charAt(i) || checker[row][col])
			return false;

		checker[row][col] = true;
		if (i == word.length() - 1)
			return true;
		if (row - 1 >= 0 && isFind(checker, board, word, i + 1, row - 1, col))
			return true;
		if (row + 1 < board.length && isFind(checker, board, word, i + 1, row + 1, col))
			return true;
		if (col - 1 >= 0 && isFind(checker, board, word, i + 1, row, col - 1))
			return true;
		if (col + 1 < board[0].length && isFind(checker, board, word, i + 1, row, col + 1))
			return true;
		checker[row][col] = false;
		return false;
	}
}
