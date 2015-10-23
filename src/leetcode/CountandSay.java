package leetcode;

/* The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth sequence.
 * Note: The sequence of integers will be represented as a string.
 */
public class CountandSay {
	public String countAndSay(int n) {
		String str = "1";
		while (--n > 0)
			str = next_seq(str);
		return str;
	}

	public String next_seq(String str) {
		StringBuffer nextstr = new StringBuffer();
		int count = 1;
		int i;
		for (i = 1; i < str.length(); i++) {
			if (str.charAt(i) == str.charAt(i-1)) {
				count++;
			} else {
				nextstr.append(count).append(str.charAt(i - 1));
				count = 1;
			}
		}
		nextstr.append(count).append(str.charAt(i - 1));
		return nextstr.toString();
	}
}
