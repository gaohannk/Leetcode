package leetcode;

/* Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring 
 * For example,
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 * Note:
 * Have you consider that the string might be empty? This is a good question to ask during an interview.
 * For the purpose of this problem, we define empty string as valid palindrome.
 */
public class ValidPalindrome {
	public boolean isPalindrome(String s) {

		if (s == null)
			return false;
		char[] chars = s.toCharArray();
		int i = 0;
		int j = s.length() - 1;

		while (i < j) {
			while (i < s.length() - 1 && !isAlphaandNum(chars[i]))
				i++;
			char left = chars[i];
			while (j > 0 && !isAlphaandNum(chars[j]))
				j--;
			char right = chars[j];

			if (i >= j)
				break;

			if (!isSame(left, right))
				return false;
			i++;
			j--;
		}
		return true;
	}

	public boolean isAlphaandNum(char a) {
		if ((a >= 'a' && a <= 'z') || (a >= 'A' && a <= 'Z') || a >= '0' && a <= '9')
			return true;
		return false;
	}

	public boolean isSame(char a, char b) {
		if (Character.toLowerCase(a) == Character.toLowerCase(b) || a == b)
			return true;
		return false;
	}
}
