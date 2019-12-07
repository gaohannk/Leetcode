package leetcode.algo.g;

/**
 * For strings S and T, we say "T divides S" if and only if S = T + ... + T  (T concatenated with itself 1 or more times)
 * <p>
 * Return the largest string X such that X divides str1 and X divides str2.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: str1 = "ABCABC", str2 = "ABC"
 * Output: "ABC"
 * Example 2:
 * <p>
 * Input: str1 = "ABABAB", str2 = "ABAB"
 * Output: "AB"
 * Example 3:
 * <p>
 * Input: str1 = "LEET", str2 = "CODE"
 * Output: ""
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= str1.length <= 1000
 * 1 <= str2.length <= 1000
 * str1[i] and str2[i] are English uppercase letters.
 */
public class GreatestCommonDivisorofStrings2 {
    public String gcdOfStrings(String str1, String str2) {

        if (str1.length() == 0 || str1.equals(str2))
            return str2;
        if (str2.length() == 0)
            return str1;
        // get new b = (a%b)/a-b;
        if (str1.length() > str2.length()) {
            if (str1.startsWith(str2)) {// str1-str2
                return gcdOfStrings(str2, str1.substring(str2.length()));
            } else return ""; // no common prefiex
        } else {
            if (str2.startsWith(str1)) {
                return gcdOfStrings(str1, str2.substring(str1.length()));
            }

            return "";
        }
    }
}
