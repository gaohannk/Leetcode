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
public class TextJustification {
	public ArrayList<String> fullJustify(String[] words, int L) {
		int len = 0;
		ArrayList<String> list = new ArrayList<String>();
		StringBuffer str = new StringBuffer();
		int preindex = 0;
		for (int i = 0; i < words.length; i++) {
			if (len + words[i].length() + i - preindex > L) {
				int spacenum = 0;
				int extraspace = 0;
				if (i - preindex != 1) {
					spacenum = (L - len) / (i - preindex - 1);
					extraspace = (L - len) % (i - preindex - 1);
				}
				str = new StringBuffer();
				for (int j = preindex; j < i; j++) {
					str.append(words[j]);
					if (j < i - 1) {
						for (int k = 0; k < spacenum; k++)
							str.append(" ");
						if (extraspace > 0)
							str.append(" ");
						extraspace--;
					}
				}
				for (int j = str.length(); j < L; j++)
					str.append(" ");

				list.add(str.toString());
				preindex = i;
				len = 0;
			}
			len += words[i].length();
		}
		str = new StringBuffer();
		for (int i = preindex; i < words.length; i++) {
			str.append(words[i]);
			if (str.length() < L)
				str.append(" ");
		}
		for (int i = str.length(); i < L; i++) {
			str.append(" ");
		}
		list.add(str.toString());
		return list;
	}
}
