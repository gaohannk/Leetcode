package leetcode.d;

import java.util.Stack;

/**
 * An encoded string S is given.  To find and write the decoded string to a tape, the encoded string is read one character at a time and the following steps are taken:
 * <p>
 * If the character read is a letter, that letter is written onto the tape.
 * If the character read is a digit (say d), the entire current tape is repeatedly written d-1 more times in total.
 * Now for some encoded string S, and an index K, find and return the K-th letter (1 indexed) in the decoded string.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: S = "leet2code3", K = 10
 * Output: "o"
 * Explanation:
 * The decoded string is "leetleetcodeleetleetcodeleetleetcode".
 * The 10th letter in the string is "o".
 * Example 2:
 * <p>
 * Input: S = "ha22", K = 5
 * Output: "h"
 * Explanation:
 * The decoded string is "hahahaha".  The 5th letter is "h".
 * Example 3:
 * <p>
 * Input: S = "a2345678999999999999999", K = 1
 * Output: "a"
 * Explanation:
 * The decoded string is "a" repeated 8301530446056247680 times.  The 1st letter is "a".
 */
public class DecodedStringatIndex {
    public String decodeAtIndex(String S, int K) {
        long total = 0;
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (Character.isAlphabetic(c))
                total++;
            else {
                total *= Integer.parseInt(c + "");
            }
        }

        for (int i = S.length() - 1; i >= 0; --i) {
            char c = S.charAt(i);
            K %= total;
            if (K == 0 && Character.isAlphabetic(c))
                return Character.toString(c);

            if (Character.isDigit(c))
                total /= Integer.parseInt(c + "");
            else
                total--;
        }

        return null;
    }
}
