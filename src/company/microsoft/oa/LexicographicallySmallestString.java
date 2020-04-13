package company.microsoft.oa;

/**
 * Lexicographically smallest string formed by removing at most one character.
 *
 * Example 1:
 *
 * Input: "abczd"
 * Output: "abcd"
 */
public class LexicographicallySmallestString {
    private static String lexiSmallestString(String s) {
        StringBuilder str = new StringBuilder(s);
        int i;
        for (i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) > str.charAt(i + 1)) {
                break;
            }
        }

        return str.deleteCharAt(i).toString();
    }
}
