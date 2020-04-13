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
public class LonelyPixelI2 {
    public int findLonelyPixel(char[][] picture) {
        int m = picture.length, n = picture[0].length, rowLP = 0, colLP = 0;
        int[] colCnt = new int[n];
        for (int i = 0; i < m; i++) {
            int rowCnt = 0;
            for (int j = 0; j < n; j++) {
                if (picture[i][j] == 'B') {
                    rowCnt++;
                    colCnt[j]++;
                    if (rowCnt == 1) rowLP++;
                    if (rowCnt == 2) rowLP--;
                    if (colCnt[j] == 1) colLP++;
                    if (colCnt[j] == 2) colLP--;
                }
            }
        }
        return Math.min(rowLP, colLP);
    }
}
