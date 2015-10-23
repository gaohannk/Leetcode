package leetcode;
/* Given an integer, write a function to determine if it is a power of two
 * 
 */
public class PowerofTwo2 {
	public boolean isPowerOfTwo(int n) {
		if (n == 1)
			return true;
		if (n == 0)
			return false;
		while (n != 1) {
			if ((n & 1) != 0)
				return false;
			n = n >> 1;
		}
		return true;
	}
}
