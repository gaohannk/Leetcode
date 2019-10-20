package leetcode.l;
/* Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 * If the last word does not exist, return 0.
 * Note: A word is defined as a character sequence consists of non-space characters only.
 * For example, 
 * Given s = "Hello World",
 * return 5.
 */
public class LengthofLastWord2 {
	public int lengthOfLastWord(String s) {
		if (s != null && !s.trim().equals("")) {
			String[] arr = s.trim().split(" ");
			int length = arr[arr.length - 1].length();
			return length;
		}
		return 0;
	}
}
