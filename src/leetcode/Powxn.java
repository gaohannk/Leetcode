package leetcode;
/* Implement pow(x, n).
 */
public class Powxn {
	public double pow(double x, int n) {
		if (n == 0)
			return 1.0;
		if (x == 0.)
			return 0.0;
		if (n < 0) {
			n = -n;
			x = 1. / x;
		}
		double temp = pow(x, n / 2);
		return n % 2 == 0 ? temp * temp : temp * temp * x;
	}
}
