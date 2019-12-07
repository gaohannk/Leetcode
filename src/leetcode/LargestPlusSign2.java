package leetcode;

import java.util.Arrays;

/**
 * In a 2D grid from (0, 0) to (N-1, N-1), every cell contains a 1, except those cells in the given list mines which are 0. What is the largest axis-aligned plus sign of 1s contained in the grid? Return the order of the plus sign. If there is none, return 0.
 * <p>
 * An "axis-aligned plus sign of 1s of order k" has some center grid[x][y] = 1 along with 4 arms of length k-1 going up, down, left, and right, and made of 1s. This is demonstrated in the diagrams below. Note that there could be 0s or 1s beyond the arms of the plus sign, only the relevant area of the plus sign is checked for 1s.
 * <p>
 * Examples of Axis-Aligned Plus Signs of Order k:
 * <p>
 * Order 1:
 * 000
 * 010
 * 000
 * <p>
 * Order 2:
 * 00000
 * 00100
 * 01110
 * 00100
 * 00000
 * <p>
 * Order 3:
 * 0000000
 * 0001000
 * 0001000
 * 0111110
 * 0001000
 * 0001000
 * 0000000
 * Example 1:
 * <p>
 * Input: N = 5, mines = [[4, 2]]
 * Output: 2
 * Explanation:
 * 11111
 * 11111
 * 11111
 * 11111
 * 11011
 * In the above grid, the largest plus sign can only be order 2.  One of them is marked in bold.
 * Example 2:
 * <p>
 * Input: N = 2, mines = []
 * Output: 1
 * Explanation:
 * There is no plus sign of order 2, but there is of order 1.
 * Example 3:
 * <p>
 * Input: N = 1, mines = [[0, 0]]
 * Output: 0
 * Explanation:
 * There is no plus sign, so return 0.
 * Note:
 * <p>
 * N will be an integer in the range [1, 500].
 * mines will have length at most 5000.
 * mines[i] will be length 2 and consist of integers in the range [0, N-1].
 * (Additionally, programs submitted in C, C++, or C# will be judged with a slightly smaller time limit.)
 */

/**
 * For every grid, we need to know the min value among its up, down, left, right directions' max outreach of consective 1s.
 *
 * So we just need one matrix to store the min among four such signals. If we initial the matrix using N, then in every step we just need to get min no matter what directions we are actually computing. So the time and space could be both O(N^2)
 */
// TODO review
public class LargestPlusSign2 {
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        int[][] grid = new int[N][N];

        for (int i = 0; i < N; i++) {
            Arrays.fill(grid[i], N);
        }

        for (int[] m : mines) {
            grid[m[0]][m[1]] = 0;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0, k = N - 1, l = 0, r = 0, u = 0, d = 0; j < N; j++, k--) {
                grid[i][j] = Math.min(grid[i][j], l = (grid[i][j] == 0 ? 0 : l + 1));  // left direction
                grid[i][k] = Math.min(grid[i][k], r = (grid[i][k] == 0 ? 0 : r + 1));  // right direction
                grid[j][i] = Math.min(grid[j][i], u = (grid[j][i] == 0 ? 0 : u + 1));  // up direction
                grid[k][i] = Math.min(grid[k][i], d = (grid[k][i] == 0 ? 0 : d + 1));  // down direction
            }
        }

        int res = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                res = Math.max(res, grid[i][j]);
            }
        }

        return res;
    }
}
