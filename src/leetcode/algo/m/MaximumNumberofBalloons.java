package leetcode.algo.m;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string text, you want to use the characters of text to form as many instances of the word "balloon" as possible.
 * <p>
 * You can use each character in text at most once. Return the maximum number of instances that can be formed.
 * <p>
 * Example 1:
 * <p>
 * Input: text = "nlaebolko"
 * Output: 1
 * Example 2:
 * <p>
 * Input: text = "loonbalxballpoon"
 * Output: 2
 * Example 3:
 * <p>
 * Input: text = "leetcode"
 * Output: 0
 */
public class MaximumNumberofBalloons {
    public int maxNumberOfBalloons(String s) {
        String t = "balloon";
        Map<Character, Integer> M = new HashMap<>();
        M.put('b', 1);
        M.put('a', 1);
        M.put('l', 2);
        M.put('o', 2);
        M.put('n', 1);
        int[] A = new int[26];
        for (char c : s.toCharArray())
            ++A[c - 'a'];
        int x = Integer.MAX_VALUE;
        for (char c : t.toCharArray()) {
            if (M.containsKey(c)) {
                x = Math.min(x, A[c - 'a'] / M.get(c));
            }
        }
        return x;
    }
}
