package company.offerup.phone;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPath2 {
    static int[] dirX = new int[]{1, 0, -1, 0};
    static int[] dirY = new int[]{0, 1, 0, -1};

    public static int shortestPath(int[][] matrix) {
        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();

        qx.add(0);
        qy.add(0);
        int dis = 0;
        while (!qx.isEmpty() && !qy.isEmpty()) {
            Queue<Integer> curLayerX = new LinkedList<>();
            Queue<Integer> curLayerY = new LinkedList<>();
            while (!qx.isEmpty() && !qy.isEmpty()) {
                int x = qx.poll(), y = qy.poll();
                if (x == matrix.length - 1 && y == matrix[0].length - 1) {
                    return dis;
                }
                for (int i = 0; i < 4; i++) {
                    int nextX = x + dirX[i];
                    int nextY = y + dirY[i];
                    if (nextX >= matrix.length || nextX < 0 || nextY >= matrix[0].length || nextY < 0) {
                        continue;
                    }
                    if (matrix[nextX][nextY] == 1) {
                        continue;
                    }
                    curLayerX.add(nextX);
                    curLayerY.add(nextY);
                }
            }
            dis++;
            qx = curLayerX;
            qy = curLayerY;
        }
        return dis;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {0, 1, 0, 0, 1},
                {0, 1, 1, 0, 0}};
        System.out.println(shortestPath(matrix));
    }
}
