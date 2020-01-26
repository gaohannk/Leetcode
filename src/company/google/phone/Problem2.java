package company.google.phone;

/**
 * Given a 0-1 matrix A of size NxM. Each element A[i][j] can only be a 0 or 1, where 0<=i<N and 0<=j<M.  If a sub-matrix only contains 0, we call it valid.
 * How many valid matrices are there in A ?
 * For example:
 */

public class Problem2 {
    static int res = 0;

    public int solution(int[][] A) {
        for (int i = 1; i < A.length; i++) {
            for (int j = 1; j < A[0].length; j++) {
                checkMatrix(i, j, A);
            }
        }
        return res;
    }

    // define the size of the matrix rowlen colLen
    public void checkMatrix(int rowLen, int colLen, int[][] A) {
        for (int i = 0; i < A.length - rowLen; i++) {
            for (int j = 0; j < A[0].length - colLen; j++) {
                int x = i; // start pointer for loop in matrix
                int y = j;
                boolean flag = true;
                for (int k = x; k < k + rowLen; k++) {
                    for (int l = y; l < l + colLen; l++) {
                        if (A[k][l] == 1) {
                            flag = false;
                            break;
                        }
                    }
                }
                if (flag) {
                    res++;
                }
            }
        }
    }

    // define the size of the matrix rowlen colLen
    public void checkMatrix2(int rowLen, int colLen, int[][] A) {
        int dp[][] = new int[A.length][A[0].length];

        dp[0][0] = A[0][0] == 1 ? 1 : 0;
        for (int i = 0; i < A[0].length; i++) {
            if (dp[0][i - 1] == 1 || A[0][i] == 1) {
                dp[0][i] = 1;
            }
        }
        for (int i = 0; i < A.length; i++) {
            if (dp[i - 1][0] == 1 || A[i][0] == 1) {
                dp[i][0] = 1;
            }
        }

        for (int i = 1; i < A.length - rowLen; i++) {
            for (int j = 1; j < A[0].length - colLen; j++) {
                if (dp[i - 1][j] == 1 || dp[i][j - 1] == 1 || dp[i - 1][j - 1] == 1 || A[i][j] == 1) {
                    dp[i][j] = 1;
                }
                if (dp[i][j] == 0) {
                    res++;
                }
            }
        }
    }
}
