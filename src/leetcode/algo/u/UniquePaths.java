package leetcode.algo.u;
/* A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right 
 * corner of the grid (marked 'Finish' in the diagram below).
 * How many possible unique paths are there?
 */
public class UniquePaths {
	// TLE
	public int uniquePaths(int m, int n) {
		if (m == 1 || n == 1)
			return 1;
		return uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
	}
}
