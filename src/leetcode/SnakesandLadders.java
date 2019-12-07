package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class SnakesandLadders {
    public int snakesAndLadders(int[][] board) {
        int N = board.length;
        int[] minDis = new int[N * N + 1];
        minDis[1] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        while (!queue.isEmpty()) {
            int pos = queue.remove();
            if (pos == N * N)
                return minDis[pos + 1];
            for (int i = 1; i <= 6; i++) {
                int next = pos + i;
                if (next == N * N)
                    break;
                int r = getRowindex(next, N);
                int c = getColIndex(next, N);
                next = board[r][c] == -1 ? next : board[r][c];
                if (minDis[next + 1] == 0) {
                    minDis[next + 1] = minDis[pos + 1] + 1;
                    queue.add(next);
                }
            }
        }
        return -1;
    }

    private int getColIndex(int pos, int N) {
        int col = 0;
        if ((pos - 1) / N % 2 == 0) {
            col = (pos - 1) % N;
        } else {
            col = N - 1 - (pos - 1) % N;
        }
        return col;
    }

    private int getRowindex(int pos, int N) {
        return pos % N == 0 ? N - pos / N : N - pos / N - 1;
    }
}
