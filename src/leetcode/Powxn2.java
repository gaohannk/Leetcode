package leetcode;

/*Implement pow(x, n).
 */
public class Powxn2 {
	public double pow(double x, int n) {
		if (n == 0)
			return 1.0;
		if (n == 2)
			return x * x;
		if (n < 0) {
			n = -n;
			x = 1.0 / x;
		}
		if (n % 2 == 0)
			return pow(pow(x, n / 2), 2);
		else
			return x * pow(pow(x, n / 2), 2);
	}
}
