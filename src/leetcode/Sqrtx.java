package leetcode;
/* Implement int sqrt(int x).
 * Compute and return the square root of x.
 */
/* 二分搜索
 * 对于一个非负数n，它的平方根不会大于（n/2+1）
 * 在[0, n/2+1]这个范围内可以进行二分搜索，求出n的平方根。
 */
public class Sqrtx {
	public int sqrt(int x) {
		int left = 0;
		int right = x / 2 + 1;
		while (left <= right) {
			int mid = (left + right) >> 1;
			if ((long) mid * mid == x)
				return mid;
			else if ((long) mid * mid > x)
				right = mid - 1;
			else
				left = mid + 1;
		}
		return left - 1;
	}
}
