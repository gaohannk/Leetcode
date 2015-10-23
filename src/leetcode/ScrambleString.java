package leetcode;

/* Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
 */
/* dp[i][j][k] == true means that s1[i:i+k-1] is scrambled from s2[j:j+k-1]
 * the final result is dp[0][0][len]
 */
public class ScrambleString {
	public boolean isScramble(String s1, String s2) {
		int len = s1.length();
		if (len != s2.length())
			return false;

		boolean[][][] dp = new boolean[len][len][len + 1];
		
		// initialize
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				for (int k = 0; k <= len; k++) {
					dp[i][j][k] = false;
				}
				dp[i][j][1] = (s1.charAt(i) == s2.charAt(j));
			}
		}

		for (int k = 2; k <= len; k++) {
			for (int i = 0; i <= len - k; i++) {
				for (int j = 0; j <= len - k; j++) {
					for (int k1 = 1; k1 <= k; k1++) {
						int k2 = k - k1;
						if (dp[i][j][k1] && dp[i + k1][j + k1][k2]) {
							dp[i][j][k] = true;
							break;
						} else if (dp[i][j + k2][k1] && dp[i + k1][j][k2]) {
							dp[i][j][k] = true;
							break;
						}
					}

				}
			}
		}
		return dp[0][0][len];
	}
}
