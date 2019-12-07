package leetcode;

import java.util.Arrays;

/**
 * Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.
 * <p>
 * The distance between two adjacent cells is 1.
 * Example 1:
 * Input:
 * <p>
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * Output:
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * Example 2:
 * Input:
 * <p>
 * 0 0 0
 * 0 1 0
 * 1 1 1
 * Output:
 * 0 0 0
 * 0 1 0
 * 1 2 1
 * Note:
 * The number of elements of the given matrix will not exceed 10,000.
 * There are at least one 0 in the given matrix.
 * The cells are adjacent in only four directions: up, down, left and right
 */
public class ZeroOneMatrix2 {
//    public static int[][] updateMatrix(int[][] matrix) {
//        int rows = matrix.length;
//        if (rows == 0)
//            return matrix;
//        int cols = matrix[0].length;
//        int[][] dist = new int[rows][cols];
//        Arrays.fill(dist, Integer.MAX_VALUE);
//        queue<pair<int, int>> q;
//        for (int i = 0; i < rows; i++)
//            for (int j = 0; j < cols; j++)
//                if (matrix[i][j] == 0) {
//                    dist[i][j] = 0;
//                    q.push({i, j}); //Put all 0s in the queue.
//                }
//
//        int dir[][] = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
//        while (!q.empty()) {
//            pair<int, int> curr = q.front();
//            q.pop();
//            for (int i = 0; i < 4; i++) {
//                int new_r = curr.first + dir[i][0], new_c = curr.second + dir[i][1];
//                if (new_r >= 0 && new_c >= 0 && new_r < rows && new_c < cols) {
//                    if (dist[new_r][new_c] > dist[curr.first][curr.second] + 1) {
//                        dist[new_r][new_c] = dist[curr.first][curr.second] + 1;
//                        q.push({new_r, new_c});
//                    }
//                }
//            }
//        }
//        return dist;
//    }
}
