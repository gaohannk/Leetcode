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
public class AndroidUnlockPatterns2 {
	static int count = 0;

	public static int numberOfPatterns(int m, int n) {
		int[][] matrix = new int[10][10];

		matrix[1][3] = matrix[3][1] = 2;
		matrix[4][6] = matrix[6][4] = 5;
		matrix[7][9] = matrix[9][7] = 8;
		matrix[1][7] = matrix[7][1] = 4;
		matrix[2][8] = matrix[8][2] = 5;
		matrix[3][9] = matrix[9][3] = 6;
		matrix[1][9] = matrix[9][1] = 5;
		matrix[3][7] = matrix[7][3] = 5;
		for (int i = 1; i <= 9; i++) {
			boolean[] visited = new boolean[10];
			visited[i] = true;
			numberOfPatterns(i, 1, m, n, visited, matrix);
		}
		return count;
	}

	private static void numberOfPatterns(int last, int cur, int m, int n, boolean[] visited, int[][] matrix) {
		if (cur >= m) {
			count++;
		}
		if (cur >= n) {
			return;
		}
		for (int i = 1; i <= 9; i++) {
			if (visited[i])
				continue;
			int crossNum = matrix[last][i];
			if (crossNum != 0 && !visited[crossNum])
				continue;
			visited[i] = true;
			numberOfPatterns(i, cur + 1, m, n, visited, matrix);
			visited[i] = false;
		}
	}

	public static void main(String[] args) {
		System.out.println(numberOfPatterns(4, 9));
	}
}
