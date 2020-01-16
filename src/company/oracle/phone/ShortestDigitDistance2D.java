package company.oracle.phone;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestDigitDistance2D {
    static class Pair {
        public int x;
        public int y;
        public int val;

        Pair(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

    }

    static int direX[] = {-1, 0, 1, 0};
    static int direY[] = {0, 1, 0, -1};

    public static int shortestDistance(int[][] digits, int d1, int d2) {
        if (digits == null)
            return 0;
        int idx1 = -1, idx2 = -1;
        int diff = Integer.MAX_VALUE;
        int row = digits.length;
        int col = digits[0].length;
        for (int i = 0; i < digits.length; i++) {
            for (int j = 0; j < digits.length; j++) {
                if (digits[i][j] == d1) {
                    int dis = BFS(digits, d2, row, col, new Pair(i, j, digits[i][j]));
                    diff = Math.min(diff, dis);
                }
            }
        }
        return diff;
    }

    private static int BFS(int[][] digits, int d2, int row, int col, Pair e) {
        int dis = 0;
        boolean visited[][] = new boolean[row][col];
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(e);
        outer:
        while (!queue.isEmpty()) {
            Queue<Pair> nextLayer = new LinkedList<>();
            while (!queue.isEmpty()) {
                Pair cur = queue.poll();
                visited[cur.x][cur.y] = true;
                if (cur.val == d2) {
                    break outer;
                }
                for (int k = 0; k < 4; k++) {
                    int nextX = cur.x + direX[k];
                    int nextY = cur.y + direY[k];
                    if (nextX >= row || nextX < 0 || nextY >= col || nextY < 0) {
                        continue;
                    }
                    if (visited[nextX][nextY]) {
                        continue;
                    }
                    nextLayer.offer(new Pair(nextX, nextY, digits[nextX][nextY]));
                }
            }
            dis++;
            queue = nextLayer;
        }
        return dis;
    }

    public static void main(String[] args) {
        int digits[][] = {
                {2,1,4,0,2},
                {0,2,0,3,7},
                {1,0,5,4,2},
                {4,9,3,5,0}
        };
        System.out.println(shortestDistance(digits, 1,5));
    }
}
