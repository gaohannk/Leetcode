package leetcode;

/* Given two strings S and T, determine if they are both one edit distance apart. Hint:
 * 1. If | n – m | is greater than 1, we know immediately both are not one-edit distance apart.
 * 2. It might help if you consider these cases separately, m == n and m ≠ n.
 * 3. Assume that m is always ≤ n, which greatly simplifies the conditional statements.
 * If m > n, we could just simply swap S and T.
 * 4. If m == n, it becomes finding if there is exactly one modified operation. If m ≠ n, you do not have to consider the delete operation. Just consider the insert operation in T.
 */
/* We make a first pass over S and T concurrently and stop at the first non-matching character between S and T.
 * 1. If S matches all characters in T, then check if there is an extra character at the end of T. (Modify operation)
 * 2. If | n – m | == 1, that means we must skip this non-matching character only in T and make sure the remaining characters between S and T are exactly matching. (Insert operation)
 * 3. If | n – m | == 0, then we skip both non-matching characters in S and T and make sure the remaining characters between S and T are exactly matching. (Append operation)
 */
public class OneEditDistance {
	public static boolean isOneEditDistance(String s, String t) {
		int m = s.length(), n = t.length();
		if (m > n)
			return isOneEditDistance(t, s);
		if (n - m > 1)
			return false;
		int i = 0, shift = n - m;
		while (i < m && s.charAt(i) == t.charAt(i))
			i++;
		if (i == m) {
			if (shift == 0)
				return false; // s ==t
			else
				return true; // s append one letter == t
		}
		if (shift == 0)
			i++; // jump one diff letter
		while (i < m && s.charAt(i) == t.charAt(i + shift))
			i++;
		return i == m;
	}
	public static void main(String[] args) {
		String s = "ababa";
		String t = "abcba";
		System.out.println(isOneEditDistance(s, t));
	}
}
