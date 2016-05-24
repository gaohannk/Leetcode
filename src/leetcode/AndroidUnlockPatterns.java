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
OOE
Same thing goes with 4, 6, 7, 8, 9 keys. Count the total possible pattern. The order of keys used matters.
Rules:
At-least 4 and at-max 9 dots must be connected.
There can be no jumps
Once a dot is crossed, you can jump over it.
*/
public class AndroidUnlockPatterns {
	public static int numberOfPatterns() {
		boolean board[] = new boolean[10];
		int res[] = { 0 };
		for (int i = 1; i < 10; i++) {
			board[i] = true;
			int count = 1;
			dfs(board, count, i, res);
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
		if (last == 2 || last == 4 || last == 5 || last == 6 || last == 8)
			return true;
		if (i == 1 && ((board[2] == true && last == 3) || (board[4] == true && last == 7)
				|| (board[5] == true && last == 9)))
			return true;
		if (i == 3 && ((board[2] == true && last == 1) || (board[6] == true && last == 9)
				|| (board[5] == true && last == 7)))
			return true;
		if (i == 7 && ((board[4] == true && last == 1) || (board[5] == true && last == 3)
				|| (board[8] == true && last == 9)))
			return true;
		if (i == 9 && ((board[6] == true && last == 3) || (board[5] == true && last == 1)
				|| (board[8] == true && last == 7)))
			return true;
		return false;
	}

	public static void main(String[] args) {
		System.out.println(numberOfPatterns());
	}
}
