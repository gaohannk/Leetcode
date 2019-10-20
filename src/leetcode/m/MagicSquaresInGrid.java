package leetcode.m;

/**
 * A 3 x 3 magic square is a 3 x 3 grid filled with distinct numbers from 1 to 9 such that each row, column, and both diagonals all have the same sum.
 * <p>
 * Given an grid of integers, how many 3 x 3 "magic square" subgrids are there?  (Each subgrid is contiguous).
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [[4,3,8,4],
 * [9,5,1,9],
 * [2,7,6,2]]
 * Output: 1
 * Explanation:
 * The following subgrid is a 3 x 3 magic square:
 * 438
 * 951
 * 276
 * <p>
 * while this one is not:
 * 384
 * 519
 * 762
 * <p>
 * In total, there is only one magic square inside the given grid.
 * Note:
 * <p>
 * 1 <= grid.length <= 10
 * 1 <= grid[0].length <= 10
 * 0 <= grid[i][j] <= 15
 */
public class MagicSquaresInGrid {
    public int numMagicSquaresInside(int[][] grid) {
        int R = grid.length, C = grid[0].length;
        int ans = 0;
        for (int r = 0; r < R - 2; ++r)
            for (int c = 0; c < C - 2; ++c) {
                if (isMagic(grid[r][c], grid[r][c + 1], grid[r][c + 2],
                        grid[r + 1][c], grid[r + 1][c + 1], grid[r + 1][c + 2],
                        grid[r + 2][c], grid[r + 2][c + 1], grid[r + 2][c + 2]))
                    ans++;
            }

        return ans;
    }

    public boolean isMagic(int... vals) {
        int[] count = new int[16];
        for (int v : vals) count[v]++;
        for (int v = 1; v <= 9; ++v)
            if (count[v] != 1)
                return false;

        return (vals[0] + vals[1] + vals[2] == 15 &&
                vals[3] + vals[4] + vals[5] == 15 &&
                vals[6] + vals[7] + vals[8] == 15 &&
                vals[0] + vals[3] + vals[6] == 15 &&
                vals[1] + vals[4] + vals[7] == 15 &&
                vals[2] + vals[5] + vals[8] == 15 &&
                vals[0] + vals[4] + vals[8] == 15 &&
                vals[2] + vals[4] + vals[6] == 15);
    }
}
