package leetcode;

/* Reverse bits of a given 32 bits unsigned integer.
 * For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), 
 * return 964176192 (represented in binary as 00111001011110000010100101000000).
 * Follow up:
 * If this function is called many times, how would you optimize it?
 */
public class ReverseBits2 {
	// you need treat n as an unsigned value
	public int reverseBits(int n) {
		int total = 32;
		for (int i = 0; i < total / 2; i++) {
			n = swapBits(n, i, total - i - 1);
		}
		return n;
	}

	private int swapBits(int n, int i, int j) {
		int lo = (n >> i) & 1;
		int hi = (n >> j) & 1;
		if ((lo ^ hi) == 1) { // both bits are different so need to swap
			n ^= ((1 << i) | (1 << j));
		}
		return n;
	}
}
