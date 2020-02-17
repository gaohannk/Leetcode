package company.amazon.oa;

import java.util.*;

/**
 * // 5. robot removes 障碍
 * // 9 is obstacle, 1 flat lot can move, 0 trenches can't move. Find the minimum val to reach obstacle in order to remove it
 * // e.g.
 * //[1,1,1]
 * //[1,0,0]
 * //[1,9,1]
 * //Output: 3
 */
public class RobotObstacle {
    static int[][] dir = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static int minSteps(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        // Corner case
        if (matrix == null || row == 0 || col == 0 || matrix[0][0] == 0) {
            return -1;
        }
        if (matrix[0][0] == 9) {
            return 0;
        }

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(0, 0));
        boolean[][] visited = new boolean[row][col];
        visited[0][0] = true;
        int dis = 0;
        while (!queue.isEmpty()) {
            Queue<Pair> nextLayer = new LinkedList<>();
            while (!queue.isEmpty()) {
                Pair cur = queue.poll();
                if (matrix[cur.x][cur.y] == 9) {
                    return dis;
                }
                visited[cur.x][cur.y] = true;
                nextLayer.addAll(getNeighbors(cur, matrix, visited));
            }
            dis++;
            queue = nextLayer;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 1, 1}, {1, 0, 0}, {1, 9, 1}};
        System.out.println(minSteps(matrix));
    }

    private static List<Pair> getNeighbors(Pair pair, int[][] matrix, boolean[][] visited) {
        List<Pair> neis = new ArrayList<>();

        for (int[] d : dir) {
            Pair nei = new Pair(pair.x + d[0], pair.y + d[1]);
            if (nei.x < 0 || nei.x >= matrix.length || nei.y < 0 || nei.y >= matrix[0].length
                    || visited[nei.x][nei.y] || matrix[nei.x][nei.y] == 0) {
                continue;
            }
            neis.add(nei);
        }
        return neis;
    }

    static class Pair {
        int x;
        int y;

        public Pair(int i, int j) {
            x = i;
            y = j;
        }
    }
}
