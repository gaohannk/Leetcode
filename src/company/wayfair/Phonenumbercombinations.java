package company.wayfair;

import java.util.ArrayList;
import java.util.List;

/**
 * Question: We are interested in getting 7 digit phone number by watching a chess piece (rook) traverse a board with numbers on each board position.
 * <p>
 * Given a 3 by 3 board that looks like this.
 * <p>
 * 1 2 3
 * 4 5 6
 * 7 8 9
 * <p>
 * And assuming that a rook starts on position 4, write a function which provides all of the combinations of 7 digit numbers which start with 4.
 * <p>
 * For example:
 * <p>
 * 456-3214 would be generated when the rook moves
 * { right one, right one, up one, left one, left one, down one }
 * <p>
 * 464-6464 would be generated when the rook moves
 * {right two, left two, right two, left two, right two, left two }
 */
public class Phonenumbercombinations {

    private static final int[][] DIRS = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}, {0, 2}, {0, -2}, {-2, 0}, {2, 0}};
    private static final int MAX_PHONE_LENGTH = 7;

    public static List<String> phoneCombinations(int[][] board, int sr, int sc) {
        if (isNullOrEmpty(board) || !isSafe(board, sr, sc)) {
            return List.of();
        }
        List<String> res = new ArrayList<>();
        StringBuilder phone = new StringBuilder(MAX_PHONE_LENGTH);
        phone.append(board[sr][sc]);
        helper(board, res, phone, sr, sc);
        return res;
    }

    private static void helper(int[][] board, List<String> res, StringBuilder phone, int sr, int sc) {
        if (phone.length() == MAX_PHONE_LENGTH) {
            res.add(phone.toString());
            return;
        }

        for (int[] dir : DIRS) {
            int r = sr + dir[0];
            int c = sc + dir[1];
            if (isSafe(board, r, c)) {
                phone.append(board[r][c]);
                helper(board, res, phone, r, c);
                phone.setLength(phone.length() - 1);
            }
        }
    }

    private static boolean isSafe(int[][] board, int r, int c) {
        return r >= 0 && r < board.length && c >= 0 && c < board[0].length;
    }

    private static boolean isNullOrEmpty(int[][] board) {
        return board == null || board.length == 0 || board[0].length == 0;
    }
}
