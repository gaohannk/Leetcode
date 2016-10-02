package leetcode;

/*Given a positive integer num, write a function which returns True if num is a perfect square else False.

Note: Do not use any built-in library function such as sqrt.

Example 1:

Input: 16
Returns: True
Example 2:

Input: 14
Returns: False

*/
public class ValidPerfectSquare {
	public static boolean isPerfectSquare(int num) {
		int low = 1;
		int high = num / 2 + 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if ((long) mid * mid == num)
				return true;
			else if ((long) mid * mid > num)
				high = mid - 1;
			else
				low = mid + 1;
		}
		return false;
	}

	public static void main(String[] args) {
		int num = 808201;
		System.out.println(isPerfectSquare(num));
	}
}
