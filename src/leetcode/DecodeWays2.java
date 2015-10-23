package leetcode;

/*A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given an encoded message containing digits, determine the total number of ways to decode it.
 * For example,
 * Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
 * The number of ways decoding "12" is 2.
 */
/* 第一：如果dp[i]所对应的的单个字符可以解码，那么dp[i]就包括前dp[i-1]位所积累的组合数 dp[i] = dp[i-1] 
 * 第二：如果不仅dp[i]所对应的的单个字符可以解码，dp[i-1] － dp[i]，两个字符组成的也可以解码，
 * 那么不仅包括dp[i-1]积累的组合数，也包括dp[i-2]位积累的组合数 dp[i] = dp[i-1] + dp[i-2]
 */

public class DecodeWays2 {
	public int numDecodings(String s) {
		if (s == null || s.length() == 0)
			return 0;
		if (s.charAt(0) == '0')
			return 0;
		int[] dp = new int[s.length() + 1];
		dp[0] = 1;
		if (isValid(s.substring(0, 1)))
			dp[1] = 1;
		else
			dp[1] = 0;
		for (int i = 2; i <= s.length(); i++) {
			if (isValid(s.substring(i - 1, i)))
				dp[i] = dp[i - 1];
			if (isValid(s.substring(i - 2, i)))
				dp[i] += dp[i - 2];
		}
		return dp[s.length()];
	}
	public boolean isValid(String s) {
		if (s.charAt(0) == '0')
			return false;
		int code = Integer.parseInt(s);
		return code >= 1 && code <= 26;
	}
}
