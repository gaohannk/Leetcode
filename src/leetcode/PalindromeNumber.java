package leetcode;

/* Determine whether an integer is a Palindrome. Do this without extra space.
 * 
 */
public class PalindromeNumber {
	public boolean isPalindrome(int x) {
		if (x < 0)
			return false;
		return reverse(x) == x;
	}

	public static int reverse(int x) {
		int result = 0;
		while (x != 0) {
			result = result * 10 + x % 10;
			x /= 10;
		}
		return result;
	}
}
