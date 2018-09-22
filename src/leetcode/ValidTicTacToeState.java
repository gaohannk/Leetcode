package leetcode;

/**
 * A Tic-Tac-Toe board is given as a string array board. Return True if and only if it is possible to reach this board position during the course of a valid tic-tac-toe game.
 * <p>
 * The board is a 3 x 3 array, and consists of characters " ", "X", and "O".  The " " character represents an empty square.
 * <p>
 * Here are the rules of Tic-Tac-Toe:
 * <p>
 * Players take turns placing characters into empty squares (" ").
 * The first player always places "X" characters, while the second player always places "O" characters.
 * "X" and "O" characters are always placed into empty squares, never filled ones.
 * The game ends when there are 3 of the same (non-empty) character filling any row, column, or diagonal.
 * The game also ends if all squares are non-empty.
 * No more moves can be played if the game is over.
 * Example 1:
 * Input: board = ["O  ", "   ", "   "]
 * Output: false
 * Explanation: The first player always plays "X".
 * <p>
 * Example 2:
 * Input: board = ["XOX", " X ", "   "]
 * Output: false
 * Explanation: Players take turns making moves.
 * <p>
 * Example 3:
 * Input: board = ["XXX", "   ", "OOO"]
 * Output: false
 * <p>
 * Example 4:
 * Input: board = ["XOX", "O O", "XOX"]
 * Output: true
 * Note:
 * <p>
 * board is a length-3 array of strings, where each string board[i] has length 3.
 * Each board[i][j] is a character in the set {" ", "X", "O"}.
 */
public class ValidTicTacToeState {
    public boolean validTicTacToe(String[] board) {
        int xCount = 0, oCount = 0, winState = 0;
        char[] arr = (board[0] + board[1] + board[2]).toCharArray();
        for (char c : arr) {
            if (c == 'O')
                oCount++;
            if (c == 'X')
                xCount++;
        }
        if (xCount < oCount || xCount > oCount + 1)
            return false;
        // diagonals
        winState = getWinState(arr[0], arr[4], arr[8]);
        winState += getWinState(arr[6], arr[4], arr[2]);
        for (int i = 0; i < 3; i++) {
            winState += getWinState(arr[i * 3], arr[i * 3 + 1], arr[i * 3 + 2]);
            winState += getWinState(arr[i], arr[i + 3], arr[i + 6]);
        }
        return winState == 0 || (winState == -10 && oCount == xCount) || ((winState == 1 || winState == 2) && oCount + 1 == xCount);
    }

    private int getWinState(char c1, char c2, char c3) {
        if (c1 != ' ' && c1 == c2 && c2 == c3)
            return c1 == 'X' ? 1 : -10;
        else return 0;
    }
}
