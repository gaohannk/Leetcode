package leetcode.i;

import java.awt.*;
import java.util.LinkedList;

/**
 * Two images A and B are given, represented as binary, square matrices of the same size.  (A binary matrix has only 0s and 1s as values.)
 * <p>
 * We translate one image however we choose (sliding it left, right, up, or down any number of units), and place it on top of the other image.  After, the overlap of this translation is the number of positions that have a 1 in both images.
 * <p>
 * (Note also that a translation does not include any kind of rotation.)
 * <p>
 * What is the largest possible overlap?
 * <p>
 * Example 1:
 * <p>
 * Input: A = [[1,1,0],
 * [0,1,0],
 * [0,1,0]]
 * B = [[0,0,0],
 * [0,1,1],
 * [0,0,1]]
 * Output: 3
 * Explanation: We slide A to right by 1 unit and down by 1 unit.
 * Notes:
 * <p>
 * 1 <= A.length = A[0].length = B.length = B[0].length <= 30
 * 0 <= A[i][j], B[i][j] <= 1
 */
/**
 * Complexity Analysis
 * <p>
 * Time Complexity: O(N^4), where N is the length of A or B.
 * <p>
 * Space Complexity: O(N^2)
 */
public class ImageOverlap {
    public int largestOverlap(int[][] A, int[][] B) {
        int N = A.length;
        int[][] count = new int[2 * N + 1][2 * N + 1];
        for (int i = 0; i < N; ++i)
            for (int j = 0; j < N; ++j)
                if (A[i][j] == 1)
                    for (int i2 = 0; i2 < N; ++i2)
                        for (int j2 = 0; j2 < N; ++j2)
                            if (B[i2][j2] == 1)
                                count[i - i2 + N][j - j2 + N] += 1;

        int ans = 0;
        for (int[] row : count)
            for (int v : row)
                ans = Math.max(ans, v);
        return ans;
    }
}
