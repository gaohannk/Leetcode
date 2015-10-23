package leetcode;

import java.util.HashSet;

/* Write an algorithm to determine if a number is "happy".
 * A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 
 * (where it will stay), or it loops endlessly in a cycle which does not include 1. 
 * Those numbers for which this process ends in 1 are happy numbers.
 * Example: 19 is a happy number
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 */
public class HappyNumber {
	public boolean isHappy(int n) {
		HashSet<Integer> set = new HashSet<Integer>();
		while (n != 1 && !set.contains(n)) {
			set.add(n);
			n = getNext(n);
		}
		return n == 1;
	}

	private static int getNext(int m) {
		int res = 0;
		while (m > 0) {
			res += (m % 10) * (m % 10);
			m = m / 10;
		}
		return res;
	}
	/*public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<Integer>();
        set.add(n);
        while (n != 1) {
            int result = 0;
            while (n != 0) {
                result += Math.pow(n % 10, 2);
                n /= 10;
            }
            if (set.contains(result)) {
                return false;
            }
            set.add(result);
            n = result;
        }
        return true;
    }*/
}
