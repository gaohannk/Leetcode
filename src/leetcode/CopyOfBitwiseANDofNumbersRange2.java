package leetcode;

/* Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.
 * For example, given the range [5, 7], you should return 4.
 */
public class CopyOfBitwiseANDofNumbersRange2 {
	/*
	 * public int rangeBitwiseAnd(int m, int n) { int res=m; for(int
	 * i=m+1;i<=n;i++){ res=res&i; } return res; }
	 */
	public static int rangeBitwiseAnd(int m, int n) {
		int[] bit = new int[32];
		int res = 0;
		for (int i = m; i <= n; i++) {
			int cur = i;
			int base = 2;
			int count = 0;
			while (base <= cur) {
				count++;
				base *= 2;
			}
			int begin = base / 2;
			bit[count]++;
			cur-=begin;
			while (cur > 0) {
				while (begin > cur) {
					begin /= 2;
					count--;
				}
				bit[count]++;
				cur-=begin;
			}
		}
		for (int i = 0; i < 32; i++) {
			if (bit[i] == n - m + 1)
				res += Math.pow(2, i);
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(rangeBitwiseAnd(10,13));
	}

}
