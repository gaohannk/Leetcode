package leetcode;

/**
 * There are N dominoes in a line, and we place each domino vertically upright.
 * <p>
 * In the beginning, we simultaneously push some of the dominoes either to the left or to the right.
 * <p>
 * <p>
 * <p>
 * After each second, each domino that is falling to the left pushes the adjacent domino on the left.
 * <p>
 * Similarly, the dominoes falling to the right push their adjacent dominoes standing on the right.
 * <p>
 * When a vertical domino has dominoes falling on it from both sides, it stays still due to the balance of the forces.
 * <p>
 * For the purposes of this question, we will consider that a falling domino expends no additional force to a falling or already fallen domino.
 * <p>
 * Given a string "S" representing the initial state. S[i] = 'L', if the i-th domino has been pushed to the left; S[i] = 'R', if the i-th domino has been pushed to the right; S[i] = '.', if the i-th domino has not been pushed.
 * <p>
 * Return a string representing the final state.
 * <p>
 * Example 1:
 * <p>
 * Input: ".L.R...LR..L.."
 * Output: "LL.RR.LLRRLL.."
 * Example 2:
 * <p>
 * Input: "RR.L"
 * Output: "RR.L"
 * Explanation: The first domino expends no additional force on the second domino.
 * Note:
 * <p>
 * 0 <= N <= 10^5
 * String dominoes contains only 'L', 'R' and '.'
 */

/**
 * Adjacent Symbols [Accepted]
 * Intuition
 * Between every group of vertical dominoes ('.'), we have up to two non-vertical dominoes bordering this group.
 * Since additional dominoes outside this group do not affect the outcome, we can analyze these situations individually: there are 9 of them (as the border could be empty).
 * Actually, if we border the dominoes by 'L' and 'R', there are only 4 cases. We'll write new letters between these symbols depending on each case.
 * Case 1: L....L, R....R then we should write "LLLLLL" "RRRRRR".
 * Case 2: If we have "R....L", then we will write "RRRLLL", or "RRR.LLL"
 * if we have an odd number of dots. If the initial symbols are at positions i and j, we can check our distance k-i and j-k to decide at position k whether to write 'L', 'R', or '.'.
 * Case 3: If we have "L....R" we don't do anything. We can skip this case.
 */
public class PushDominoes {
    public static String pushDominoes(String dominoes) {
        int N = dominoes.length();
        int[] indexes = new int[N + 2];
        char[] symbols = new char[N + 2];
        int len = 1;
        indexes[0] = -1;
        symbols[0] = 'L';

        for (int i = 0; i < N; ++i) {
            if (dominoes.charAt(i) != '.') {
                indexes[len] = i;
                symbols[len++] = dominoes.charAt(i);
            }
        }

        indexes[len] = N;
        symbols[len++] = 'R';

        char[] ans = dominoes.toCharArray();
        for (int index = 0; index < len - 1; ++index) {
            int i = indexes[index], j = indexes[index + 1];
            char x = symbols[index], y = symbols[index + 1];
            if (x == y) { //Case 1
                for (int k = i + 1; k < j; ++k) {
                    ans[k] = x;
                }
            } else if (x > y) { // Case 2
                for (int k = i + 1; k < j; ++k) {
                    ans[k] = k - i == j - k ? '.' : k - i < j - k ? 'R' : 'L';
                }
            }
        }

        return String.valueOf(ans);
    }
    public static void main(String[] args){
        pushDominoes("..LL..RR.R..L");
    }
}
