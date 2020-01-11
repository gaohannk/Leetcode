package company.hired;

public class Problem3 {
    public static long[][] solution(long[][] matrix) {
        // Type your solution here
        if (matrix == null || matrix.length == 0) {
            return null;
        }
        if (matrix.length == 1) {
            return matrix;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        long[][] res = new long[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                res[j][row - 1 - i] = matrix[i][j];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        long[][] matrix = new long[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        long[][] res = solution(matrix);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }
}
