package company.twosigma.oa;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Problem Statement
 * You are given a library with n words (w[0], w[1], ...,w[n-1]). You choose a word from it, and in each step, remove one letter from this word only if doing so yields another word in the library. What is the longest possible chain of these removal steps?
 *
 * Constraints:
 * 1 <= n <= 50000
 * 1 <= the length of each string in w <= 50
 * Each string is composed of lowercase ascii letters only
 * The function should take in an array of strings w as its argument and should return a single integer representing the length of the longest chain of character removals possible.
 *
 * Example input/output
 * a
 * b
 * ba
 * bca
 * bda
 * bdca
 *
 * Calling the function on the input above should output 4. The longest possible chain is "bdca" -> "bca" -> "ba" -> "a".
 */
// 1048 dfs O(N)

public class LongestChain {

    public int longestStrChain(String[] words) {
        int[] res = new int[1];
        Set<String> set = new TreeSet<>(Comparator.reverseOrder());
        for (String word : words) {
            set.add(word);
        }
        for (String word : set) {
            int cur = 1;
            dfs(set, word, cur, res);
        }
        return res[0];
    }

    private void dfs(Set<String> set, String word, int cur, int[] res) {
        for (int i = 0; i < word.length(); i++) {
            StringBuilder sb = new StringBuilder(word);
            String next = sb.deleteCharAt(i).toString();
            if (set.contains(next)) {
                dfs(set, next, cur + 1, res);
            }
        }
        res[0] = Math.max(res[0], cur);
        return;
    }
}
