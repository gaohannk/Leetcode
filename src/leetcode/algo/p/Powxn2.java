package leetcode.algo.p;

/*Implement pow(x, n).
 */
public class Powxn2 {
	public double myPow(double x, int n) {
		if (n == 0)
			return 1.0;
		if (n == 2)
			return x * x;
		if (n < 0) {
			n = -n;
			x = 1.0 / x;
		}
		if (n % 2 == 0)
			return myPow(myPow(x, n / 2), 2);
		else
			return x * myPow(myPow(x, n / 2), 2);
	}
}
