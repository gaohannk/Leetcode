package leetcode.algo.s;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * You want to build a house on an empty land which reaches all buildings in the shortest amount of distance. You can only move up, down, left and right. You are given a 2D grid of values 0, 1 or 2, where:
 * <p>
 * Each 0 marks an empty land which you can pass by freely.
 * Each 1 marks a building which you cannot pass through.
 * Each 2 marks an obstacle which you cannot pass through.
 * For example, given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2):
 * <p>
 * 1 - 0 - 2 - 0 - 1
 * |   |   |   |   |
 * 0 - 0 - 0 - 0 - 0
 * |   |   |   |   |
 * 0 - 0 - 1 - 0 - 0
 * The point (1,2) is an ideal empty land to build a house, as the total travel distance of 3+3+1=7 is minimal. So return 7.
 * <p>
 * Note:
 * There will be at least one building. If it is not possible to build such house according to the above rules, return -1.
 */

/**
 * BFS
 */
public class ShortestDistancefromAllBuildings {
    static class Pair {
        public int x;
        public int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int res = Integer.MAX_VALUE;

    public static int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0)
            return -1;
        int row = grid.length;
        int col = grid[0].length;

        int[][] sum = new int[row][col];
        int[][] dist = new int[row][col];

        int[] deltax = new int[]{0, 1, -1, 0};
        int[] deltay = new int[]{1, 0, 0, -1};
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // distance to current point

                int[][] visit = new int[row][col];
                if (grid[i][j] == 1) {
                    Queue<Pair> index = new LinkedList<>();
                    index.add(new Pair(i, j));
                    while (!index.isEmpty()) {
                        Pair cur = index.poll();
                        int x = cur.x;
                        int y = cur.y;

                        for (int k = 0; k < 4; k++) {
                            int next_x = x + deltax[k];
                            int next_Y = y + deltay[k];
                            if (next_x >= 0 && next_x < row
                                    && next_Y >= 0 && next_Y < col
                                    && grid[next_x][next_Y] == 0
                                    && visit[next_x][next_Y] != 1) {
                                visit[next_x][next_Y] = 1;
                                dist[next_x][next_Y] = dist[x][y] + 1;
                                sum[next_x][next_Y] += dist[next_x][next_Y];
                                index.add(new Pair(next_x, next_Y));

                            }
                        }
                    }
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (sum[i][j] != 0)
                    res = Math.min(res, sum[i][j]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 0, 2, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}};
        int res = shortestDistance(matrix);
        System.out.print(res);
    }

}
