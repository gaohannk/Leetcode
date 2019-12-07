package leetcode;

/* Given a string S, find the longest palindromic substring in S.
 * You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
 */

/**
 * Method2 DP
 * dp(i, j) represents whether s(i ... j) can form a palindromic substring,
 * dp(i, j) is true when s(i) equals to s(j) and s(i+1 ... j-1) is a palindromic substring.
 */
public class LongestPalindromicSubstring2 {
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 2)
            return s;
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        String res = "";
        // dp[i][i]
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
            res = s.substring(i, i + 1);
        }
        // dp[i][i+1]
        for (int i = 0; i < len - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                res = s.substring(i, i + 2);
            }
        }

        for (int i = len-1; i  >=0; i--) {
            for (int j = i + 2; j < len; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
                if (dp[i][j] && j - i + 1 > res.length()) {
                    res = s.substring(i, j + 1);
                }
            }
        }
        //printDp(dp);
        return res;
    }

    private static void printDp(boolean[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] ? "T " : "F ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.print(longestPalindrome("abcba"));
    }
}
