package leetcode;

/**
 * We have a two dimensional matrix A where each value is 0 or 1.
 * <p>
 * A move consists of choosing any row or column, and toggling each value in that row or column: changing all 0s to 1s, and all 1s to 0s.
 * <p>
 * After making any number of moves, every row of this matrix is interpreted as a binary number, and the score of the matrix is the sum of these numbers.
 * <p>
 * Return the highest possible score.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [[0,0,1,1],[1,0,1,0],[1,1,0,0]]
 * Output: 39
 * Explanation:
 * Toggled to [[1,1,1,1],[1,0,0,1],[1,1,1,1]].
 * 0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= A.length <= 20
 * 1 <= A[0].length <= 20
 * A[i][j] is 0 or 1.
 */

/**
 * Algorithm
 * <p>
 * If we toggle rows by the first column (A[r][c] ^= A[r][0]), then the first column will be all 0.
 * Afterwards, the base score is max(col, R - col) where col is the column sum; and (1 << (C-1-c)) is the power of 2 that each 1 in that column contributes to the score.
 * Let's say original column i (not the first column) is (a1, a2, a3, a4, a5) and a2 and a4 are on the row whose first element is 0. Then we can choose to toggle row2 and row4 to make first column all 1s, which makes column i become (a1, a2 xor 1, a3, a4 xor 1, a5). Another choice is to toggle row1, row3, row5 to make first column all 0s and then toggle first column. This makes column i become (a1 xor 1, a2, a3 xor 1, a4, a5 xor 1).
 * Then if we use xor 1 on each element of this tuple, we can easily see that:
 * (a1 xor 1, a2, a3 xor 1, a4, a5 xor 1) xor 1 = (a1, a2 xor 1, a3, a4 xor 1, a5)
 * So the two choices actually generates "opposite" results on later columns. The max(col, R - col) is same on all columns.
 */
public class ScoreAfterFlippingMatrix {
    public static int matrixScore(int[][] A) {
        int R = A.length, C = A[0].length;
        int ans = 0;
        for (int c = 0; c < C; ++c) {
            int col = 0;
            for (int r = 0; r < R; ++r) {
                col += A[r][c] ^ A[r][0];
            }
            System.out.println("col:" + col);
            ans += Math.max(col, R - col) * (1 << (C - 1 - c));
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] A = new int[][]{{0, 0, 1, 1}, {1, 0, 1, 0}, {1, 1, 0, 0}, {1, 1, 0, 1}};
        System.out.print(matrixScore(A));
    }
}
