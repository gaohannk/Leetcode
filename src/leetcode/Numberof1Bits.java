package leetcode;

public class Numberof1Bits {
	// you need to treat n as an unsigned value
	public int hammingWeight(int n) {
		int num = 32;
		int count = 0;
		while (num-- > 0) {
			if (((1 << num) & n) !=0)
				count++;
		}
		return count;
	}
}
