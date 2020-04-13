package leetcode.algo.l;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
public class LonelyPixelII {
    public int findBlackPixel(char[][] picture, int N) {
        int m = picture.length, n = picture[0].length;
        int[] row = new int[m], col = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; ++j) {
                if (picture[i][j] == 'B') {
                    row[i]++;
                    col[j]++;
                }
            }
        }

        int count = 0;
        for (int j = 0; j < n; j++) {
            if (col[j] == N) {
                List<Integer> list = new ArrayList<>();
                int num = 0;
                for (int i = 0; i < m; ++i) {
                    if (picture[i][j] == 'B' && row[i] == N) {
                        num++;
                    }
                    if (picture[i][j] == 'B') {
                        list.add(i);
                    }
                }

                if (num > 0) {
                    boolean flag = true;
                    for (int x = 1; x < list.size(); ++x) {
                        if (!Arrays.equals(picture[list.get(x)], picture[list.get(x - 1)])) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        count += num;
                    }
                }
            }
        }

        return count;
    }
}
