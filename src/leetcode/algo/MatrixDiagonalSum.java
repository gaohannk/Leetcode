package leetcode.algo;

public class MatrixDiagonalSum {
    public int diagonalSum(int[][] mat) {
        if (mat == null)
            return 0;
        int sum = 0;
        for (int i = 0, j = 0; i < mat.length && j < mat[0].length; i++, j++) {
            sum += mat[i][j];
        }
        for (int i = 0, j = mat[0].length - 1; i < mat.length && j >= 0; i++, j--) {
            sum += mat[i][j];
        }
        if (mat.length % 2 == 1) {
            sum -= mat[mat.length / 2][mat.length / 2];
        }
        return sum;
    }
}
