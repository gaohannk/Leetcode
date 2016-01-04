package leetcode;

/* Q1:
 * 8   9   0
 * 1   8   7
 * 11  2   6
 * 6   2   77
 * set(int x, int y, int value)
 * int sum(int x, int y)
 * Sum(1,1) = 8 + 9 + 1 + 8
 * Part I: Basic algorithm
 * Part II: Suppose set() is called infrequently, while sum() is called frequently
 * Suppose each pair(x,y) we have sum saved in sum[][] 
 * Part III: Suppose set() and sum() are called evenly
 * Hint: do have to cache all the sum?
 * Answer: cache diagonal sum


Q2: 
Palindrome: 





}
*/
public class SetandSum {
	int[][] mtx;
	int[][] sum;

	public void set(int x, int y, int value) {
		if (mtx == null)
			return;
		if (x >= mtx.length || x < 0)
			return;
		if (y >= mtx[0].length || y < 0)
			return;
		mtx[x][y] = value;
	}

	public int sum(int x, int y) {
		int sum = 0;
		if (mtx == null)
			return 0;
		if (x >= mtx.length || x < 0)
			return 0;
		if (y >= mtx[0].length || y < 0)
			return 0;
		for (int i = 0; i <= x; i++) {
			for (int j = 0; j <= y; j++) {
				sum += mtx[i][j];
			}
		}
		return sum;
	}

	public int sum2(int x, int y) {
		if (mtx == null)
			return 0;
		if (x >= mtx.length || x < 0)
			return 0;
		if (y >= mtx[0].length || y < 0)
			return 0;

		return sum[x][y];
	}

	public void set2(int x, int y, int value) {
		if (mtx == null)
			return;
		if (x >= mtx.length || x < 0)
			return;
		if (y >= mtx[0].length || y < 0)
			return;
		for (int i = x; i < sum.length; i++) {
			for (int j = y; j < sum[0].length; j++) {
				sum[i][j] -= mtx[i][j];
				sum[i][j] += value;
			}
		}
		mtx[x][y] = value;
	}
}
