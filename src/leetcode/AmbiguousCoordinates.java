package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * We had some 2-dimensional coordinates, like "(1, 3)" or "(2, 0.5)".  Then, we removed all commas, decimal points, and spaces, and ended up with the string S.  Return a list of strings representing all possibilities for what our original coordinates could have been.
 * <p>
 * Our original representation never had extraneous zeroes, so we never started with numbers like "00", "0.0", "0.00", "1.0", "001", "00.01", or any other number that can be represented with less digits.  Also, a decimal point within a number never occurs without at least one digit occuring before it, so we never started with numbers like ".1".
 * <p>
 * The final answer list can be returned in any order.  Also note that all coordinates in the final answer have exactly one space between them (occurring after the comma.)
 * <p>
 * Example 1:
 * Input: "(123)"
 * Output: ["(1, 23)", "(12, 3)", "(1.2, 3)", "(1, 2.3)"]
 * Example 2:
 * Input: "(00011)"
 * Output:  ["(0.001, 1)", "(0, 0.011)"]
 * Explanation:
 * 0.0, 00, 0001 or 00.01 are not allowed.
 * Example 3:
 * Input: "(0123)"
 * Output: ["(0, 123)", "(0, 12.3)", "(0, 1.23)", "(0.1, 23)", "(0.1, 2.3)", "(0.12, 3)"]
 * Example 4:
 * Input: "(100)"
 * Output: [(10, 0)]
 * Explanation:
 * 1.0 is not allowed.
 * <p>
 * <p>
 * Note:
 * <p>
 * 4 <= S.length <= 12.
 * S[0] = "(", S[S.length - 1] = ")", and the other elements in S are digits.
 */
public class AmbiguousCoordinates {
    public List<String> ambiguousCoordinates(String S) {
        List<String> ans = new ArrayList();
        for (int i = 2; i < S.length() - 1; i++)
            for (String left : make(S, 1, i))
                for (String right : make(S, i, S.length() - 1))
                    ans.add("(" + left + ", " + right + ")");
        return ans;
    }

    public List<String> make(String S, int i, int j) {
        // Make on S.substring(i, j)
        List<String> ans = new ArrayList();
        for (int d = 1; d <= j - i; d++) {
            String left = S.substring(i, i + d);
            String right = S.substring(i + d, j);
            if ((!left.startsWith("0") || left.equals("0"))
                    && !right.endsWith("0"))
                ans.add(left + (d < j - i ? "." : "") + right);
        }
        return ans;
    }
}
