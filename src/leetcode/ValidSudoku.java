package leetcode;

/* Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 * Note:A valid Sudoku board (partially filled) is not necessarily solvable. 
 * Only the filled cells need to be validated.
 */
import java.util.*;

public class ValidSudoku {
	public boolean isValidSudoku(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			HashSet<Character> set = new HashSet<Character>();
			for (int j = 0; j < board[i].length; j++) {
				if (!isValid(set, board[i][j]))
					return false;
			}
		}
		for (int i = 0; i < board.length; i++) {
			HashSet<Character> set = new HashSet<Character>();
			for (int j = 0; j < board[i].length; j++) {
				if (!isValid(set, board[j][i]))
					return false;
			}
		}
		for (int offset_y = 0; offset_y <= 6; offset_y += 3) {
			for (int offset_x = 0; offset_x <= 6; offset_x += 3) {
				HashSet<Character> set = new HashSet<Character>();
				for (int i = 0; i <= 2; i++) {
					for (int j = 0; j <= 2; j++) {
						if (!isValid(set, board[i + offset_x][j + offset_y]))
							return false;
					}
				}
			}
		}
		return true;
	}

	public boolean isValid(HashSet<Character> set, char c) {
		if (c != '.' && !set.contains(c))
			set.add(c);
		else if (c != '.' && set.contains(c))
			return false;
		return true;
	}
}
