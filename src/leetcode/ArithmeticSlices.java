package leetcode;

/**
 * A sequence of number is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.
 * <p>
 * For example, these are arithmetic sequence:
 * <p>
 * 1, 3, 5, 7, 9
 * 7, 7, 7, 7
 * 3, -1, -5, -9
 * The following sequence is not arithmetic.
 * <p>
 * 1, 1, 2, 5, 7
 * <p>
 * A zero-indexed array A consisting of N numbers is given. A slice of that array is any pair of integers (P, Q) such that 0 <= P < Q < N.
 * <p>
 * A slice (P, Q) of array A is called arithmetic if the sequence:
 * A[P], A[p + 1], ..., A[Q - 1], A[Q] is arithmetic. In particular, this means that P + 1 < Q.
 * <p>
 * The function should return the number of arithmetic slices in the array A.
 * <p>
 * <p>
 * Example:
 * <p>
 * A = [1, 2, 3, 4]
 * <p>
 * return: 3, for 3 arithmetic slices in A: [1, 2, 3], [2, 3, 4] and [1, 2, 3, 4] itself.
 */
public class ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] A) {
        if (A.length < 3)
            return 0;
        int count = 0;
        for (int len = 3; len <= A.length; len++) {
            for (int i = 0; i < A.length - len + 1; i++) {

                int cur = i + 1;
                int diff = A[cur] - A[i];
                boolean flag = true;
                while (cur < i + len) {
                    if (A[cur] - A[cur - 1] != diff) {
                        flag = false;
                        break;
                    }
                    cur++;
                }
                if (flag)
                    count++;
            }
        }
        return count;
    }
}
