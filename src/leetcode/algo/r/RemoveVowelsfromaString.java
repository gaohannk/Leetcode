package leetcode.algo.r;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given a string S, remove the vowels 'a', 'e', 'i', 'o', and 'u' from it, and return the new string.
 *
 *
 *
 * Example 1:
 *
 * Input: "leetcodeisacommunityforcoders"
 * Output: "ltcdscmmntyfrcdrs"
 * Example 2:
 *
 * Input: "aeiou"
 * Output: ""
 *
 *
 * Note:
 *
 * S consists of lowercase English letters only.
 * 1 <= S.length <= 1000
 */
public class RemoveVowelsfromaString {
    public String removeVowels(String s) {
        if (s == null || s.length() == 0)
            return s;
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!set.contains(s.charAt(i))) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
