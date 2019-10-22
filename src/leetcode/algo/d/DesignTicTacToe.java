package leetcode.algo.d;

public class DesignTicTacToe {

    public class TicTacToe {
        int board[][];

        public TicTacToe(int n) {
            board = new int[n][n];
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board.length; j++) {
                    board[i][j] = -1;
                }
            }
        }

        public int move(int row, int col, int player) {
            board[row][col] = player;
            return isWin(player);
        }

        public int isWin(int p) {
            // check each row
            for (int i = 0; i < board.length; i++) {
                int count = 0;
                for (int j = 0; j < board.length; j++) {
                    if (board[i][j] != p)
                        break;
                    count++;
                }
                if (count == board.length) {
                    return p;
                }
            }
            // check each column
            for (int i = 0; i < board.length; i++) {
                int count = 0;
                for (int j = 0; j < board.length; j++) {
                    if (board[j][i] != p)
                        break;
                    count++;
                }
                if (count == board.length) {
                    return p;
                }
            }
            // check dignose
            int count = 0;
            for (int i = 0; i < board.length; i++) {
                if (board[i][i] != p)
                    break;
                count++;
            }
            if (count == board.length) {
                return p;
            }
            // check dignose
            count = 0;
            for (int i = 0; i < board.length; i++) {
                if (board[i][board.length - 1 - i] != p)
                    break;
                count++;
            }
            if (count == board.length) {
                return p;
            }
            return 0;
        }
    }
}
