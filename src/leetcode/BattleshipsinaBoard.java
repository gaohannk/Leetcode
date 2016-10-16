package leetcode;

/**
 * Given an 2D board, count how many different battleships are in it. The battleships are represented with 'X's, empty slots are represented with '.'s. You may assume the following rules:
 * <p>
 * You receive a valid board, made of only battleships or empty slots.
 * Battleships can only be placed horizontally or vertically. In other words, they can only be made of the shape 1xN (1 row, N columns) or Nx1 (N rows, 1 column).
 * At least one horizontal or vertical cell separates between two battleships - there are no adjacent battleships.
 * Example:
 * X..X
 * ...X
 * ...X
 * In the above board there are 2 battleships.
 * Your algorithm should not modify the value of the board.
 */
public class BattleshipsinaBoard {
    public int countBattleships(char[][] board) {
        if(board==null||board.length==0)
            return 0;
        boolean[][] visit = new boolean[board.length][board[0].length];
        int res[] = new int[1];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'X' && !visit[i][j]) {
                    res[0]++;
                    DFS(i, j, board, visit, res);
                }

            }
        }
        return res[0];
    }

    private void DFS(int i, int j, char[][] board, boolean[][] visit, int[] res) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '.' || visit[i][j]) return;
        visit[i][j] = true;
        DFS(i + 1, j, board, visit, res);
        DFS(i, j + 1, board, visit, res);
        DFS(i - 1, j, board, visit, res);
        DFS(i, j - 1, board, visit, res);
    }
}
