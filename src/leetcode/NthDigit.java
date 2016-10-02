package leetcode;

/*
 * Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...
 * Note:
 * n is positive and will fit within the range of a 32-bit signed integer (n < 231).
Example 1:
Input:
3
Output:
3
Example 2:
Input:
11
Output:
0
Explanation:
The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, which is part of the number 10.
*/
public class NthDigit {
	public static int findNthDigit(int n) {
		int time = 1;
		int digit = 1;
		while (true) {
			// 9 * time * digit may exceed int range
			if (n > (long) 9 * time * digit) {
				n -= 9 * time * digit;
				time *= 10;
				digit++;
			} else {
				break;
			}
		}
		int num = time + (n - 1) / digit;
		int index = (n - 1) % digit;
		return Integer.parseInt("" + String.valueOf(num).charAt((int) index));
	}

	public static void main(String[] args) {
		System.out.println("digit is: " + findNthDigit(2147483647));
	}
}
