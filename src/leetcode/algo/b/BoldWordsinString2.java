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
public class BoldWordsinString2 {
    public String boldWords(String[] words, String S) {
        int N = S.length();
        boolean[] mask = new boolean[N];
        for (int i = 0; i < N; ++i)
            for (String word : words)
                search:{
                    for (int k = 0; k < word.length(); ++k)
                        if (k + i >= S.length() || S.charAt(k + i) != word.charAt(k))
                            break search;

                    for (int j = i; j < i + word.length(); ++j)
                        mask[j] = true;
                }

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < N; ++i) {
            if (mask[i] && (i == 0 || !mask[i - 1]))
                ans.append("<b>");
            ans.append(S.charAt(i));
            if (mask[i] && (i == N - 1 || !mask[i + 1]))
                ans.append("</b>");
        }
        return ans.toString();
    }
}
