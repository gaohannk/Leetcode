package leetcode;

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
public class GreatestCommonDivisorofStrings {
    public String gcdOfStrings(String str1, String str2) {
        // Swap string
        if (str1.length() > str2.length()) {
            String temp = str1;
            str1 = str2;
            str2 = temp;
        }
        int common = gcd(str1.length(), str2.length());
        String preFix = str1.substring(0, common);
        // Validate
        for (int i = 0; i < str2.length(); i = i + common) {
            if (!str2.substring(i, i + common).equals(preFix)) {
                return "";
            }
        }
        return preFix;
    }

    private int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        return gcd(b % a, a);
    }
}
