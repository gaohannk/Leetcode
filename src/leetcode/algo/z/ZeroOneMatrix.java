package leetcode.algo.z;

import java.util.Arrays;
import java.util.LinkedList;
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

// TODO verify
public class ZeroOneMatrix {
    public static int[][] updateMatrix(int[][] matrix) {
        int rows = matrix.length;
        if (rows == 0)
            return matrix;
        int cols = matrix[0].length;
        int[][] res =new int[rows][cols];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] != 0) {
                    Queue<int[]> xq = new LinkedList<>();
                    int level = 1;
                    xq.add(new int[]{i, j});
                    int[][] visited = new int[rows][cols];
                    BFS(xq, level, rows, cols, i, j, matrix, visited, res);
                }else{
                    res[i][j]=0;
                }
            }
        }

        return matrix;
    }

    public static void BFS(Queue<int[]> queue, int level, int rows, int cols, int i, int j, int[][] matrix, int[][] visited, int[][] res) {
        int dir[][] = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty()) {
            Queue<int[]> next = new LinkedList<>();
            for (int l= 0; l < queue.size(); l++) {
                int[] id = queue.poll();
                visited[id[0]][id[1]] = 1;
                for (int k = 0; k < 4; k++) {
                    int new_r = id[0] + dir[k][0], new_c = id[1] + dir[k][1];
                    if (new_r >= 0 && new_c >= 0 && new_r < rows && new_c < cols) {
                        if (visited[new_r][new_c] != 1) {
                            if (matrix[new_r][new_c] != 0) {
                                next.add(new int[]{new_r, new_c});
                            } else {
                                res[i][j] = level;
                                return;
                            }
                        }
                    }
                }
            }
            queue = new LinkedList<>(next);
            level++;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[3][3];
        updateMatrix(matrix);
    }
}
