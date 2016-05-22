package leetcode;

/* Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.
 * Example:
 * For num = 5 you should return [0,1,1,2,1,2].
 * Follow up:
 * It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
 * Space complexity should be O(n).
 * Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.
 * Hint:
 * You should make use of what you have produced already.
 * Divide the numbers in ranges like [2-3], [4-7], [8-15] and so on. And try to generate new range from previous.
 * Or does the odd/even status of the number help you in calculating the number of 1s?
 */
/*
 * Num:0 1 | 2 3 |4 5 6 7 |8 9 10 11 12 13 14 15 |16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 |
 * Bits0 1   1 2  1 2 2 3  1 2 2  3   2  3  3  4 |1  2  2  3  2  3  3  4  2  3  3  4  3  4   4  5
 */
public class CountingBits3 {
	public int[] countBits(int num) {
		int[] ret = new int[num + 1];
		ret[0] = 0;
		int pow = 1;
		for (int i = 1, t = 0; i <= num; i++, t++) {
			if (i == pow) {
				pow *= 2;
				t = 0;
			}
			ret[i] = ret[t] + 1;
		}
		return ret;
	}
}
