package leetcode;

import java.util.ArrayList;
import java.util.List;

/* You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -, you and your friend take turns to flip two consecutive "++" into "--". The game ends when a person can no longer make a move and therefore the other person will be the winner.
 * Write a function to compute all possible states of the string after one valid move.
 * For example, given s = "++++", after one move, it may become one of the following states:
 * [
 *   "--++",
 *   "+--+",
 *   "++--"
 * ]
 * If there is no valid move, return an empty list [].
 */
public class FlipGame {
	public List<String> generatePossibleNextMoves(String s) {
		List<String> res = new ArrayList<String>();
		char chs[] = s.toCharArray();
		for (int i = 0; i < s.length() - 1; i++) {
			if (chs[i] == chs[i + 1] && chs[i] == '+') {
				chs[i] = chs[i + 1] = '-';
				res.add(String.valueOf(chs));
				chs[i] = chs[i + 1] = '+';
			}
		}
		return res;
	}
}
