package leetcode;

/* Find the total number of patterns of the Android lock screen. The number of key used has to be at least 4, and max 9.
 * Example:
 * use 5 keys:
 * OAB
 * OOC
 * OED
 * 
 * OAB
 * OCD
 * OOE
 * Same thing goes with 4, 6, 7, 8, 9 keys. Count the total possible pattern. The order of keys used matters。
 * Rules:
 * At-least 4 and at-max 9 dots must be connected.
 * There can be no jumps
 * Once a dot is crossed, you can jump over it.
 */
public class AndroidUnlockPatterns {
	static int res = 0;

	public static int numberOfPatterns() {
		boolean board[] = new boolean[10];
		int res[] = { 0 };
		for (int i = 1; i < 10; i++) {
			board[i] = true;
			dfs(board, 1, i, res);
			board[i] = false;
		}
		return res[0];
	}

	private static void dfs(boolean[] board, int count, int last, int[] res) {
		if (count == 10)
			return;
		for (int i = 1; i < 10; i++) {
			if (isValid(i, board, last)) {
				board[i] = true;
				if (count >= 4)
					res[0]++;
				dfs(board, count + 1, i, res);
				board[i] = false;
			}
		}
	}

	private static boolean isValid(int i, boolean[] board, int last) {
		// TODO Auto-generated method stub
		if (board[i] == true)
			return false;
		if (i == 2 && board[5] == false && last == 8)
			return false;
		if (i == 4 && board[5] == false && last == 6)
			return false;
		if (i == 6 && board[5] == false && last == 4)
			return false;
		if (i == 8 && board[5] == false && last == 2)
			return false;
		if (i == 1 && ((board[2] == false && last == 3) || (board[4] == false && last == 7)
				|| (board[5] == false && last == 9)))
			return false;
		if (i == 3 && ((board[2] == false && last == 1) || (board[6] == false && last == 9)
				|| (board[5] == false && last == 7)))
			return false;
		if (i == 7 && ((board[4] == false && last == 1) || (board[5] == false && last == 3)
				|| (board[8] == false && last == 9)))
			return false;
		if (i == 9 && ((board[6] == false && last == 3) || (board[5] == false && last == 1)
				|| (board[8] == false && last == 7)))
			return false;
		return true;
	}

	public static int numberOfPatterns(int m, int n) {
		boolean[][] keyboard = new boolean[3][3];
		int ret = 0;
		for (int p = m; p <= n; p++) {
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 2; j++) {
					if (j == 0 && i == 1)
						continue;
					keyboard[i][j] = true;
					helper(keyboard, p - 1, i, j);
					keyboard[i][j] = false;
					ret += (i == 1 && j == 1) ? res : 4 * res;
					res = 0;
				}
			}
		}
		return ret;
	}

	private static void helper(boolean[][] keyboard, int left, int x, int y) {
		if (left == 0) {
			res++;
			return;
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (keyboard[i][j] || (x == i && Math.abs(y - j) > 1) && !keyboard[x][1]
						|| (y == j && Math.abs(x - i) > 1) && !keyboard[1][y]
						|| (x + y == i + j) && Math.abs(x - i) > 1 && !keyboard[1][1]
						|| (x - y == i - j) && Math.abs(x - i) > 1 && !keyboard[1][1] || (x == i && y == j)) {
					continue;
				} else {
					keyboard[i][j] = true;
					helper(keyboard, left - 1, i, j);
					keyboard[i][j] = false;
				}
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(numberOfPatterns(4, 9));
	}
}
