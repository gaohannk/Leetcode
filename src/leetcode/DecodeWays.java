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
public class DecodeWays {
	public int numDecodings(String s) {

		if (s == null || s.length() == 0)
			return 0;
		if (s.charAt(0) == '0')
			return 0;

		if (s.length() == 1)
			return 1;
		if (s.length() == 2) {
			if (s.charAt(1) == 0)
				return 1;
			else if (Integer.parseInt(s.substring(0, 2)) > 26)
				return 1;
			else
				return 2;
		}

		if (s.charAt(s.length() - 1) == '0')
			return numDecodings(s.substring(0, s.length() - 2));
		else {
			int i = Integer.parseInt(s.substring(s.length() - 2, s.length()));
			if (i > 26)
				return numDecodings(s.substring(0, s.length() - 1));
			else
				return numDecodings(s.substring(0, s.length() - 1)) + numDecodings(s.substring(0, s.length() - 2));
		}
	}
}
