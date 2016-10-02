package leetcode;

import java.util.Stack;

/*Given an encoded string, return it's decoded string.
The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

Examples:

s = "3[a]2[bc]", return "aaabcbc".
s = "3[a2[c]]", return "accaccacc".
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".

*/
public class DecodeString {
	public String decodeString(String s) {
		Stack<Integer> stack = new Stack<>();
		Stack<Character> stack2 = new Stack<>();
		String res = "";
		String num = "";
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= 0 && s.charAt(i) <= 9) {
				num += s.charAt(i);
			} else if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z')
				res += s.charAt(i);
			else if (s.charAt(i) == '[')
				break;
		}
		int time = Integer.parseInt(num);
		while (time-- > 0) {
			res += decodeString(s.substring(s.indexOf('[')+1));
		}
		return res;
	}
}
