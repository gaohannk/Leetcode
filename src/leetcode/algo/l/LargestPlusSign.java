package leetcode.algo.l;

import java.util.HashSet;
import java.util.Set;

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

// TLE
public class LargestPlusSign {
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        Set<Integer> banned = new HashSet();
        for (int[] mine : mines)
            banned.add(mine[0] * N + mine[1]);

        int ans = 0;
        for (int r = 0; r < N; ++r)
            for (int c = 0; c < N; ++c) {
                int k = 0;
                while (k <= r && r < N - k && k <= c && c < N - k &&
                        !banned.contains((r - k) * N + c) &&
                        !banned.contains((r + k) * N + c) &&
                        !banned.contains(r * N + c - k) &&
                        !banned.contains(r * N + c + k))
                    k++;

                ans = Math.max(ans, k);
            }
        return ans;
    }
}
