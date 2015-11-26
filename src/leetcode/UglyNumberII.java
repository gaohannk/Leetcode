package leetcode;

/* Write a program to find the n-th ugly number.
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
 * Note that 1 is typically treated as an ugly number.
 */
//TLE
public class UglyNumberII {
	public static int nthUglyNumber(int n) {
		int i = 1;
		while (n > 0) {
			if (isUgly(i))
				n--;
			i++;
		}
		return i-1;
	}

	public static boolean isUgly(int num) {
		if (num <= 0)
			return false;
		while (num % 2 == 0) {
			num /= 2;
		}
		while (num % 3 == 0) {
			num /= 3;
		}
		while (num % 5 == 0) {
			num /= 5;
		}
		return num == 1;
	}
	public static void main(String[] args){
		System.out.println(nthUglyNumber(1600));
	}
}
