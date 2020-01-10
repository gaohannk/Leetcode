package leetcode.algo;

public class Minesweeper {
    int[] direcX = {0, -1, 0, 1, 1, 1, -1, -1};
    int[] direcY = {1, 0, -1, 0, -1, 1, -1, 1};

    public char[][] updateBoard(char[][] board, int[] click) {
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }
        boolean[][] visited = new boolean[board.length][board[0].length];

        helper(board, click[0], click[1], visited);
        return board;
    }

    private void helper(char[][] board, int row, int col, boolean[][] visited) {
        if (visited[row][col])
            return;
        if (board[row][col] == 'M')
            return;
        for (int i = 0; i < 8; i++) {
            int count = getMineArround(board, row, col);
            if (count == 0) {
                board[row][col] = 'B';
            } else {
                board[row][col] = (char) (count + 48);
            }
            visited[row][col] = true;
            if (board[row][col] > '0' && board[row][col] < '9')
                continue;
            if (row + direcX[i] >= board.length || row + direcX[i] < 0 || col + direcY[i] >= board[0].length || col + direcY[i] < 0) {
                continue;
            }
            helper(board, row + direcX[i], col + direcY[i], visited);
        }
    }

    private int getMineArround(char[][] board, int row, int col) {

        int count = 0;
        for (int i = 0; i < 8; i++) {
            if (row + direcX[i] >= board.length || row + direcX[i] < 0 || col + direcY[i] >= board[0].length || col + direcY[i] < 0) {
                continue;
            }
            if (board[row + direcX[i]][col + direcY[i]] == 'M') {
                count++;
            }
        }
        return count;
    }
}
