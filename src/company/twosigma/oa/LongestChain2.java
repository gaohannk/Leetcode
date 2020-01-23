package company.twosigma.oa;

import java.util.*;

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
// 1048 DP
public class LongestChain2 {

    public int findLongestChain(String[] words) {
        if (words == null || words.length == 0) return 0;
        int longestChain = 0;
        Arrays.sort(words, new Comparator<String>() {
            public int compare(String str1, String str2) {
                return str1.length() - str2.length();
            }
        });
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (String word : words) {
            if (map.containsKey(word)) continue;
            map.put(word, 1);
            for (int i = 0; i < word.length(); i++) {
                StringBuilder sb = new StringBuilder(word);
                sb.deleteCharAt(i);
                String after = sb.toString();
                if (map.containsKey(after) && map.get(after) + 1 > map.get(word)) {
                    map.put(word, map.get(after) + 1);
                }
            }
            if (map.get(word) > longestChain) longestChain = map.get(word);
        }
        return longestChain;
    }
}
