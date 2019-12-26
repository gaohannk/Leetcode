package leetcode.algo.z;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
// Start from value is 0, BFS
public class ZeroOneMatrix2 {
    public int[][] updateMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] output = new int[row][col];
        boolean visited[][] = new boolean[row][col];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            for (int[] neighbor : getNeighbors(cell, visited)) {
                visited[neighbor[0]][neighbor[1]] = true;
                output[neighbor[0]][neighbor[1]] = output[cell[0]][cell[1]] + 1;
                queue.offer(neighbor);
            }
        }
        return output;
    }

    List<int[]> getNeighbors(int[] cell, boolean visited[][]) {
        int rows = visited.length;
        int cols = visited[0].length;
        List<int[]> list = new LinkedList<>();
        int dir[][] = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int k = 0; k < 4; k++) {
            int new_r = cell[0] + dir[k][0], new_c = cell[1] + dir[k][1];
            if (new_r >= 0 && new_c >= 0 && new_r < rows && new_c < cols) {
                if (!visited[new_r][new_c]) {
                    list.add(new int[]{new_r, new_c});
                }
            }
        }
        return list;
    }
}
