package leetcode;
/* Given a string S and a string T, count the number of distinct subsequences of T in S.
 * A subsequence of a string is a new string which is formed from the original string by 
 * deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. 
 * (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 * Here is an example:
 * S = "rabbbit", T = "rabbit"
 * Return 3.
 */
//LTE
public class DistinctSubsequence2 {
	public int numDistinct(String S, String T) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (S.length() == 0) {
			return T.length() == 0 ? 1 : 0;
		}
		if (T.length() == 0) {
			return 1;
		}
		int cnt = 0;
		for (int i = 0; i < S.length(); i++) {
			if (S.charAt(i) == T.charAt(0)) {
				cnt += numDistinct(S.substring(i + 1), T.substring(1));
			}
		}
		return cnt;
	}
}
