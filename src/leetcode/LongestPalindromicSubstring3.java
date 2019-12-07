package leetcode;

/* Given a string S, find the longest palindromic substring in S.
 * You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
 */

/**
 * Method2 DP
 * dp(i, j) represents whether s(i ... j) can form a palindromic substring,
 * dp(i, j) is true when s(i) equals to s(j) and s(i+1 ... j-1) is a palindromic substring.
 */
public class LongestPalindromicSubstring3 {
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 2)
            return s;
        int n = s.length();
        String res = "";
        boolean[][] dp = new boolean[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                // j- i > 3, no need to initialize dp[i][i] and dp[i][i+1] separately
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);
                if (dp[i][j] && j - i + 1 > res.length()) {
                    res = s.substring(i, j + 1);
                }
            }
        }

        return res;
    }
}