package leetcode;

/* Given a string S, find the longest palindromic substring in S. 
 * You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
 */
/* method2 table
 * table[i][j]表示从i到j的子串是palindromic
 */
public class LongestPalindromicSubstring2 {
	public static String longestPalindrome(String s) {
		if (s == null || s.length() <= 1)
			return s;

		int maxLen = 0;
		String longestStr = null;
		int length = s.length();

		int[][] table = new int[length][length];

		// every single letter is palindromic
		for (int i = 0; i < length; i++) {
			table[i][i] = 1;
		}
		// e.g. bb
		// two consecutive same letters are palindromic
		for (int i = 0; i <= length - 2; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				table[i][i + 1] = 1;
				longestStr = s.substring(i, i + 2);
			}
		}
		// condition for calculate whole table
		for (int l = 3; l <= length; l++) {
			for (int i = 0; i <= length - l; i++) {
				int j = i + l - 1;
				if (s.charAt(i) == s.charAt(j)) {
					table[i][j] = table[i + 1][j - 1];
					if (table[i][j] == 1 && l > maxLen)
						longestStr = s.substring(i, j + 1);
				} else {
					table[i][j] = 0;
				}
			}
		}
		return longestStr;
	}
}
