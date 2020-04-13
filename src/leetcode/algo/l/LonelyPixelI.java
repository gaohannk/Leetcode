package leetcode.algo.l;

/**
 * Given a picture consisting of black and white pixels, find the number of black lonely pixels.
 * <p>
 * The picture is represented by a 2D char array consisting of 'B' and 'W', which means black and white pixels respectively.
 * <p>
 * A black lonely pixel is character 'B' that located at a specific position where the same row and same column don't have any other black pixels.
 * <p>
 * Example:
 * Input:
 * [['W', 'W', 'B'],
 * ['W', 'B', 'W'],
 * ['B', 'W', 'W']]
 * <p>
 * Output: 3
 * Explanation: All the three 'B's are black lonely pixels.
 * Note:
 * The range of width and height of the input 2D array is [1,500].
 */
public class LonelyPixelI {
    public int findLonelyPixel(char[][] picture) {
        int m = picture.length;
        int n = picture[0].length;
        int[] M = new int[m];
        int[] N = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] == 'B') {
                    M[i] = M[i] == 0 ? j + 1 : -1;
                    N[j] = N[j] == 0 ? i + 1 : -1;
                }

            }
        }
        int sum = 0;
        for (int i = 0; i < m; i++) {
            if (M[i] > 0 && N[M[i] - 1] == i + 1) {
                sum++;
            }
        }
        return sum;
    }
}
