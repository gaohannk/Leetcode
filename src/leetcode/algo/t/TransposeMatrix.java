package leetcode.algo.t;

import java.util.stream.IntStream;

/**
 * Given a matrix A, return the transpose of A.
 * <p>
 * The transpose of a matrix is the matrix flipped over it's main diagonal, switching the row and column indices of the matrix.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [[1,4,7],[2,5,8],[3,6,9]]
 * Example 2:
 * <p>
 * Input: [[1,2,3],[4,5,6]]
 * Output: [[1,4],[2,5],[3,6]]
 */
public class TransposeMatrix {
    public int[][] transpose(int[][] A) {


        int row = A.length, col = A[0].length;
        int[][] ans = new int[col][row];
        for (int r = 0; r < row; r++)
            for (int c = 0; c < col; ++c) {
                ans[c][r] = A[r][c];
            }
        return ans;

    }

    public int[][] transpose2(int[][] A) {
        return IntStream.range(0, A[0].length)
                .mapToObj(c -> IntStream.range(0, A.length).map(r -> A[r][c]).toArray())
                .toArray(int[][]::new);
    }
}
