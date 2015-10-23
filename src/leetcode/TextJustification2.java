package leetcode;

import java.util.ArrayList;

/* Given an array of words and a length L, format the text such that each line has exactly L characters and is fully 
 * (left and right) justified.You should pack your words in a greedy approach; that is, pack as many words as you can 
 * in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.
 * Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not 
 * divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
 * For the last line of text, it should be left justified and no extra space is inserted between words.
 * For example,
 * words: ["This", "is", "an", "example", "of", "text", "justification."]
 * L: 16.
 * Return the formatted lines as:
 * [
 *    "This    is    an",
 *    "example  of text",
 *    "justification.  "
 * ]
 * Note: Each word is guaranteed not to exceed L in length.
 */
public class TextJustification2 {
	public ArrayList<String> fullJustify(String[] words, int L) {
		ArrayList<String> ret = new ArrayList<String>();
		if (words == null || words.length == 0)
			return ret;

		int start = 0, end = pack(words, start, L);
		ret.add(convert(words, start, end, L));
		while (end != words.length - 1) {
			start = end + 1;
			end = pack(words, start, L);
			ret.add(convert(words, start, end, L));
		}
		return ret;
	}

	// pack a line and return the end of this line
	private int pack(String[] words, int start, int L) {
		int next = start; // the index of the next word
		int length = words[next].length();

		// always try to include the next word plus a padding space (greedy
		// packing)
		while (next + 1 < words.length && length + 1 + words[next + 1].length() <= L)
			length += words[++next].length() + 1;
		return next;
	}

	// convert multiple words along with extra padding space into a string of
	// length L
	private String convert(String[] words, int start, int end, int L) {
		StringBuilder sb = new StringBuilder();

		// if this line only contains one word
		if (start == end) {
			sb.append(words[start]);
			for (int i = 0; i < L - words[start].length(); i++) {
				sb.append(" ");
			}
			return sb.toString();
		}
		// if the line is the last line, the space distribution rule is
		// different
		else if (end == words.length - 1) {
			int curLen = 0;
			for (int i = start; i < end; i++) {
				sb.append(words[i]);
				sb.append(" ");
				curLen += words[i].length() + 1;
			}
			sb.append(words[end]);
			curLen += words[end].length();

			for (int i = 0; i < L - curLen; i++) {
				sb.append(" ");
			}
			return sb.toString();
		}

		// calculate the lengths of padding space
		int totalLen = 0, numOfSpaces = end - start;
		for (int i = start; i <= end; i++)
			totalLen += words[i].length();
		int lenOfPaddingSpace = (L - totalLen) / numOfSpaces;
		int numOfExtraSpaces = (L - totalLen) % numOfSpaces;

		// construct the line
		int count = 0; // count of the extra spaces
		for (int i = start; i < end; i++) {
			sb.append(words[i]);
			for (int j = 0; j < lenOfPaddingSpace; j++)
				sb.append(" ");
			if (count < numOfExtraSpaces)
				sb.append(" ");
			count++;
		}
		sb.append(words[end]);

		return sb.toString();
	}
}
