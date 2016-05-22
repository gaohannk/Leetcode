package leetcode;

public class ReverseString {
	public String reverseString(String s) {
		char[] chars = s.toCharArray();
		int i = 0, j = s.length() - 1;
		while (i < j) {
			char tmp = chars[i];
			chars[i] = chars[j];
			chars[j] = tmp;
			i++;
			j--;
		}
		return new String(chars);
	}
}
