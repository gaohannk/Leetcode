package leetcode;

/* Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.
 * The input string does not contain leading or trailing spaces and the words are always separated by a single space.
 * For example, Given s = "the sky is blue", return "blue is sky the".
 * Could you do it in-place without allocating extra space?
 */
public class ReverseWordsinaStringII2 {
	public void reverseWords(char[] s) {
		for (int i = 0, j = 0; i < s.length; i++) {
			for (j = i; i < s.length && s[i] != ' '; i++)
				;
			reverse(s, j, i - 1);
		}
		reverse(s, 0, s.length - 1);
	}

	private void reverse(char[] s, int i, int j) {
		for (; i < j; i++, j--) {
			char c = s[i];
			s[i] = s[j];
			s[j] = c;
		}
	}
}
