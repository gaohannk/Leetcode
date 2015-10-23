package leetcode;
/* A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right 
 * corner of the grid (marked 'Finish' in the diagram below).
 * How many possible unique paths are there?
 */
//TLE
public class UniquePaths2 {
	public int uniquePaths(int m, int n) {
		return backtrack(0, 0, m, n);
	}
	public int backtrack(int r, int c, int m, int n) {
		if (r == m - 1 && c == n - 1)
			return 1;
		if (r > m - 1 || c > n - 1)
			return 0;
		return backtrack(r + 1, c, m, n) + backtrack(r, c + 1, m, n);
	}
}
