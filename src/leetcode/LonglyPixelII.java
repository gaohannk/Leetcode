package leetcode;

/**
 * Given a picture consisting of black and white pixels, and a positive integer N, find the number of black pixels located at some specific row R and column C that align with all the following rules:
 * <p>
 * Row R and column C both contain exactly N black pixels.
 * For all rows that have a black pixel at column C, they should be exactly the same as row R
 * The picture is represented by a 2D char array consisting of 'B' and 'W', which means black and white pixels respectively.
 * <p>
 * Example:
 * Input:
 * [['W', 'B', 'W', 'B', 'B', 'W'],
 * ['W', 'B', 'W', 'B', 'B', 'W'],
 * ['W', 'B', 'W', 'B', 'B', 'W'],
 * ['W', 'W', 'B', 'W', 'B', 'W']]
 * <p>
 * N = 3
 * Output: 6
 * Explanation: All the bold 'B' are the black pixels we need (all 'B's at column 1 and 3).
 * 0    1    2    3    4    5         column index
 * 0    [['W', 'B', 'W', 'B', 'B', 'W'],
 * 1     ['W', 'B', 'W', 'B', 'B', 'W'],
 * 2     ['W', 'B', 'W', 'B', 'B', 'W'],
 * 3     ['W', 'W', 'B', 'W', 'B', 'W']]
 * row index
 * <p>
 * Take 'B' at row R = 0 and column C = 1 as an example:
 * Rule 1, row R = 0 and column C = 1 both have exactly N = 3 black pixels.
 * Rule 2, the rows have black pixel at column C = 1 are row 0, row 1 and row 2. They are exactly the same as row R = 0.
 * <p>
 * Note:
 * The range of width and height of the input 2D array is [1,200].
 */
// TODO need revisit
public class LonglyPixelII {
    public int findBlackPixel(char[][] picture, int N) {
        int[] row = new int[picture.length];
        int[] col = new int[picture[0].length];
        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[0].length; j++) {
                if (picture[i][j] == 'B') {
                    row[i] = row[i] + 1;
                    col[j] = col[j] + 1;
                }
            }
        }
        int total = 0;
        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[0].length; j++) {
                if (picture[i][j] == 'B' && row[i] == N && col[j] == N) {
                    boolean flag = true;
                    for (int r = 0; r < picture.length && flag; r++) {
                        if (picture[r][j] == 'B' && r != i) {
                            for (int c = 0; c < picture[0].length && flag; c++) {
                                if (picture[i][c] != picture[r][c]) {
                                    flag = false;
                                }
                            }
                        }
                    }
                    if (flag) total++;
                }
            }
        }
        return total;
    }

}
