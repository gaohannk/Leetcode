package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * A group of two or more people wants to meet and minimize the total travel distance. You are given a 2D grid of values 0 or 1, where each 1 marks the home of someone in the group. The distance is calculated using Manhattan Distance, where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.
 * <p>
 * For example, given three people living at (0,0), (0,4), and (2,2):
 * <p>
 * 1 - 0 - 0 - 0 - 1
 * |   |   |   |   |
 * 0 - 0 - 0 - 0 - 0
 * |   |   |   |   |
 * 0 - 0 - 1 - 0 - 0
 * The point (0,2) is an ideal meeting point, as the total travel distance of 2+2+2=6 is minimal. So return 6.
 * <p>
 * Hint:
 * <p>
 * Try to solve it in one dimension first. How can this solution apply to the two dimension case?
 */
public class BestMeetingPoint {
    static class Pair {
        public int x;
        public int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int res = Integer.MAX_VALUE;

    public static int minTotalDistance(int[][] grid) {
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

                        for (int k = 0; k < 4; k++) {
                            int next_x = cur.x + deltax[k];
                            int next_Y = cur.y + deltay[k];
                            if (next_x >= 0 && next_x < row
                                    && next_Y >= 0 && next_Y < col
                                    && grid[next_x][next_Y] == 0
                                    && visit[next_x][next_Y] != 1) {
                                visit[next_x][next_Y] = 1;
                                dist[next_x][next_Y] = dist[cur.x][cur.y] + 1;
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
        int[][] matrix = {{1, 0, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}};
        int res = minTotalDistance(matrix);
        System.out.print(res);
    }

}
