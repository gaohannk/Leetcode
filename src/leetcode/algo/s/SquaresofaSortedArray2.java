package leetcode.algo.s;

/**
 * Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number, also in sorted non-decreasing order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * Example 2:
 * <p>
 * Input: [-7,-3,2,3,11]
 * Output: [4,9,9,49,121]
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= A.length <= 10000
 * -10000 <= A[i] <= 10000
 * A is sorted in non-decreasing order.
 */
public class SquaresofaSortedArray2 {
    public int[] sortedSquares(int[] A) {
        int N = A.length;
        if (N == 1)
            return new int[]{A[0] * A[0]};

        int p1 = 0, p2 = 1;
//        while (p2 < N && A[p2] < 0)
//            p2++;
//        int p1 = p2-1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] < 0 && A[i + 1] >= 0) {
                p1 = i;
                p2 = i + 1;
            }
        }

        int[] res = new int[N];
        int id = 0;

        while (p1 >= 0 && p2 < N) {
            if (A[p1] * A[p1] < A[p2] * A[p2]) {
                res[id++] = A[p1] * A[p1];
                p1--;
            } else {
                res[id++] = A[p2] * A[p2];
                p2++;
            }
        }

        while (p1 >= 0) {
            res[id++] = A[p1] * A[p1];
            p1--;
        }
        while (p2 < N) {
            res[id++] = A[p2] * A[p2];
            p2++;
        }

        return res;
    }
}
