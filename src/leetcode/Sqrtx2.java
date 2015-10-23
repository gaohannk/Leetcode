package leetcode;
/* Implement int sqrt(int x).
 * Compute and return the square root of x.
 */
/* 牛顿迭代法
 * 经过(xi, f(xi))的切线方程为f(x)=f(xi)+f’(xi)(x-xi)，其中f'(x)为f(x)的导数2x。
 * 令切线方程等于0，即可求出xi+1=xi-f(xi)/f'(xi)。
 * 化简，xi+1=xi - (xi2 - n) / (2xi) = xi - xi / 2 + n / (2xi) = xi / 2 + n / 2xi = (xi + n/xi) / 2。
 */

public class Sqrtx2 {
	public int sqrt(int x) {
	    if (x == 0) return 0;
	    double last = 0;
	    double res = 1;
	    while (res != last)
	    {
	        last = res;
	        res = (res + x / res) / 2;
	    }
	    return (int)res;
	}
}
