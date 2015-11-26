package leetcode;

import java.util.Stack;

/* Given an input string, reverse the string word by word.
 * For example,
 * Given s = "the sky is blue",
 * return "blue is sky the".
 * Clarification:
 * What constitutes a word?
 * A sequence of non-space characters constitutes a word.
 * Could the input string contain leading or trailing spaces?
 * Yes. However, your reversed string should not contain leading or trailing spaces.
 * How about multiple spaces between two words?
 * Reduce them to a single space in the reversed string.
 * One simple approach is a two-pass solution: First pass to split the string by spaces into an array of words, then second pass to extract the words in reversed order.
 * We can do better in one-pass. While iterating the string in reverse order, we keep track of a word’s begin and end position. When we are at the beginning of a word, we append it.
 */
public class ReverseWordsinaString {
	public String reverseWords(String s) {
		Stack<String> stack = new Stack<String>();
		s.trim();
		int p = 0, q = 0;
		while (p < s.length()) {
			while (q < s.length() && s.charAt(q) == ' ')
				q++;
			p = q;
			while (q < s.length() && s.charAt(q) != ' ')
				q++;
			stack.push(s.substring(p, q));
			p = q;
		}

		StringBuffer buf = new StringBuffer();
		while (!stack.empty()) {
			String top = stack.pop();
			buf.append(top);
			buf.append(' ');
		}
		return buf.toString().trim();
	}
	
}
