package leetcode;

/*Given a string s and a string t, check if s is subsequence of t.
You may assume that there is only lower case English letters in both s and t. t is potentially a very long (length ~= 500,000) string, and s is a short string (<=100).
A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).
Example 1:
s = "abc", t = "ahbgdc"
Return true.
Example 2:
s = "axc", t = "ahbgdc"
Return false.
Follow up:
If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you want to check one by one to see if T has its subsequence. In this scenario, how would you change your code?
*/
public class IsSubsequence {
	public boolean isSubsequence(String s, String t) {
		int cur = -1;
		String test = "";
		for (int i = 0; i < s.length(); i++) {
			if (cur < t.length())
				test = t.substring(cur + 1);
			else
				return false;
			// not found char in rest of t
			if (test.indexOf(s.charAt(i)) == -1) {
				return false;
			// recode index in t, don't forget the increament of cur since test is residue of t.
			} else {
				cur += test.indexOf(s.charAt(i)) + 1;
			}
		}
		return true;
	}
}
