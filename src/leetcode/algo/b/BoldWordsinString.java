package leetcode.algo.b;

/**
 * Given a set of keywords words and a string S, make all appearances of all keywords in S bold. Any letters between and tags become bold.
 * <p>
 * The returned string should use the least number of tags possible, and of course the tags should form a valid combination.
 * <p>
 * For example, given that words = [“ab”, “bc”] and S = “aabcd”, we should return “aabcd”. Note that returning “aabcd” would use more tags, so it is incorrect.
 * <p>
 * Note:
 * <p>
 * words has length in range [0, 50].
 * words[i] has length in range [1, 10].
 * S has length in range [0, 500].
 * All characters in words[i] and S are lowercase letters.
 */
public class BoldWordsinString {
    public String boldWords(String[] words, String S) {
        int len = S.length();
        boolean[] marked = new boolean[len];
        for (int i = 0; i < len; ++i) {
            for (String word : words) {
                if (i + word.length() <= len && word.equals(S.substring(i, i + word.length()))) {
                    for (int j = i; j < i + word.length(); ++j) {
                        marked[j] = true;
                    }
                }
            }
        }

        StringBuilder res = new StringBuilder();
        int j = 0;
        while (j < len) {
            while (j < len && !marked[j]) {
                res.append(S.charAt(j));
                j++;
            }
            if (j >= len)
                break;
            StringBuilder bold = new StringBuilder();
            while (j < len && marked[j]) {
                bold.append(S.charAt(j));
                j++;
            }
            if (bold.length() != 0)
                res.append("<b>" + bold.toString() + "</b>");
        }
        return res.toString();
    }
}
