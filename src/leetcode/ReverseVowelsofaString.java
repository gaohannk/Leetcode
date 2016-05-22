package leetcode;

import java.util.HashMap;
import java.util.HashSet;

public class ReverseVowelsofaString {
	public static String reverseVowels(String s) {
		if (s == null)
			return "";
		char chars[] = new char[s.length()];
		int i = 0, j = s.length() - 1;
		while (i <= j) {
			while (i < s.length() - 1 && !isvowel(s.charAt(i))) {
				chars[i] = s.charAt(i);
				i++;
			}
			while (j >= 0 && !isvowel(s.charAt(j))) {
				chars[j] = s.charAt(j);
				j--;
			}
			if (i < s.length() && j >= 0) {
				chars[i] = s.charAt(j);
				chars[j] = s.charAt(i);
				i++;
				j--;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (i = 0; i < chars.length; i++) {
			sb.append(chars[i]);
		}
		return sb.toString();
	}

	private static boolean isvowel(char c) {
		HashSet<Character> set = new HashSet<Character>();
		set.add('a');
		set.add('e');
		set.add('i');
		set.add('o');
		set.add('u');
		set.add('A');
		set.add('E');
		set.add('I');
		set.add('O');
		set.add('U');
		if (set.contains(c))
			return true;
		return false;
	}

	public static void main(String[] args) {
		System.out.println(reverseVowels(" "));
	}
}
