package leetcode;

/**
 * On an 8 x 8 chessboard, there is one white rook.  There also may be empty squares, white bishops, and black pawns.  These are given as characters 'R', '.', 'B', and 'p' respectively. Uppercase characters represent white pieces, and lowercase characters represent black pieces.
 * <p>
 * The rook moves as in the rules of Chess: it chooses one of four cardinal directions (north, east, west, and south), then moves in that direction until it chooses to stop, reaches the edge of the board, or captures an opposite colored pawn by moving to the same square it occupies.  Also, rooks cannot move into the same square as other friendly bishops.
 * <p>
 * Return the number of pawns the rook can capture in one move.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: [[".",".",".",".",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".","R",".",".",".","p"],[".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".","."]]
 * Output: 3
 * Explanation:
 * In this example the rook is able to capture all the pawns.
 * Example 2:
 * <p>
 * <p>
 * <p>
 * Input: [[".",".",".",".",".",".",".","."],[".","p","p","p","p","p",".","."],[".","p","p","B","p","p",".","."],[".","p","B","R","B","p",".","."],[".","p","p","B","p","p",".","."],[".","p","p","p","p","p",".","."],[".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".","."]]
 * Output: 0
 * Explanation:
 * Bishops are blocking the rook to capture any pawn.
 * Example 3:
 * <p>
 * <p>
 * <p>
 * Input: [[".",".",".",".",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".","p",".",".",".","."],["p","p",".","R",".","p","B","."],[".",".",".",".",".",".",".","."],[".",".",".","B",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".",".",".",".",".","."]]
 * Output: 3
 * Explanation:
 * The rook can capture the pawns at positions b5, d6 and f5.
 * <p>
 * <p>
 * Note:
 * <p>
 * board.length == board[i].length == 8
 * board[i][j] is either 'R', '.', 'B', or 'p'
 * There is exactly one cell with board[i][j] == 'R'
 */
public class AvailableCapturesforRook {
    public int numRookCaptures(char[][] board) {
        int ans = 0;
        int row = board.length;
        int col = board[0].length;
        int locx = 0;
        int locy = 0;
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if ((board[i][j] - 'R') == 0) {
                    locx = i;
                    locy = j;
                }
            }
        }
        for (int i = locy + 1; i < col; ++i) {
            if ((board[locx][i] - 'B') == 0) {
                break;
            }
            if ((board[locx][i] - 'p') == 0) {
                ans++;
                break;
            }
        }
        for (int i = locy - 1; i >= 0; --i) {
            if ((board[locx][i] - 'B') == 0) {
                break;
            }
            if ((board[locx][i] - 'p') == 0) {
                ans++;
                break;
            }
        }
        for (int i = locx - 1; i >= 0; --i) {
            if ((board[i][locy] - 'B') == 0) {
                break;
            }
            if ((board[i][locy] - 'p') == 0) {
                ans++;
                break;
            }
        }
        for (int i = locx + 1; i < row; ++i) {
            if ((board[i][locy] - 'B') == 0) {
                break;
            }
            if ((board[i][locy] - 'p') == 0) {
                ans++;
                break;
            }
        }
        return ans;
    }
}
