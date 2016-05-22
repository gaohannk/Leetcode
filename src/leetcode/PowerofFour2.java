package leetcode;

/* Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
 * Example:
 * Given num = 16, return true. Given num = 5, return false.
 * Follow up: Could you solve it without loops/recursion?
*/
public class PowerofFour2 {
	public boolean isPowerOfFour(int num) {
		if (num <= 0)
			return false;
		if (num == 2)
			return false;
		int count = 0;
		int zeros = 0;
		while (num != 0) {
			if ((num & 1) == 1)
				count++;
			else {
				zeros++;
			}
			num = num >> 1;
		}
		return count == 1 && zeros % 2 == 0;
	}
}
