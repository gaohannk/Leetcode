package leetcode;

import java.util.List;

/**
 * Given a sequence of words, check whether it forms a valid word square.
 * <p>
 * A sequence of words forms a valid word square if the kth row and column read the exact same string, where 0 ≤ k < max(numRows, numColumns).
 * <p>
 * Note:
 * <p>
 * The number of words given is at least 1 and does not exceed 500.
 * Word length will be at least 1 and does not exceed 500.
 * Each word contains only lowercase English alphabet a-z.
 * Example 1:
 * <p>
 * Input:
 * [
 * "abcd",
 * "bnrt",
 * "crmy",
 * "dtye"
 * ]
 * <p>
 * Output:
 * true
 * <p>
 * Explanation:
 * The first row and first column both read "abcd".
 * The second row and second column both read "bnrt".
 * The third row and third column both read "crmy".
 * The fourth row and fourth column both read "dtye".
 * <p>
 * Therefore, it is a valid word square.
 * Example 2:
 * <p>
 * Input:
 * [
 * "abcd",
 * "bnrt",
 * "crm",
 * "dt"
 * ]
 * <p>
 * Output:
 * true
 * <p>
 * Explanation:
 * The first row and first column both read "abcd".
 * The second row and second column both read "bnrt".
 * The third row and third column both read "crm".
 * The fourth row and fourth column both read "dt".
 * <p>
 * Therefore, it is a valid word square.
 * Example 3:
 * <p>
 * Input:
 * [
 * "ball",
 * "area",
 * "read",
 * "lady"
 * ]
 * <p>
 * Output:
 * false
 * <p>
 * Explanation:
 * The third row reads "read" while the third column reads "lead".
 * <p>
 * Therefore, it is NOT a valid word square.
 */
public class ValidWordSquare {
    public boolean validWordSquare(List<String> words) {
        if (words == null || words.size() == 0) {
            return true;
        }
        int n = words.size();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < words.get(i).length(); j++) {
                if (j >= n || words.get(j).length() <= i || words.get(j).charAt(i) != words.get(i).charAt(j))
                    return false;
            }
        }
        return true;
    }
}
