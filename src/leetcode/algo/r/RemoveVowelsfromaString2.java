package leetcode.algo.r;

/**
 * Given a string S, remove the vowels 'a', 'e', 'i', 'o', and 'u' from it, and return the new string.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: "leetcodeisacommunityforcoders"
 * Output: "ltcdscmmntyfrcdrs"
 * Example 2:
 * <p>
 * Input: "aeiou"
 * Output: ""
 * <p>
 * <p>
 * Note:
 * <p>
 * S consists of lowercase English letters only.
 * 1 <= S.length <= 1000
 */
public class RemoveVowelsfromaString2 {
    public String removeVowels(String S) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') continue;
            res.append(c);
        }
        return res.toString();
    }
}
