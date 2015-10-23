package leetcode;

public class ReverseInteger2 {
	public int reverse(int x) {
		StringBuilder num = new StringBuilder();
		int val = 0;

		if (x > 0) {
			num = num.append(x).reverse();
			try {
				val = (int) Integer.parseInt(num.toString());
			} catch (NumberFormatException e) {
				return 0;
			}

			return val;
		}

		else {
			x = -x;
			num = num.append(x).reverse();
			try {
				val = (int) Integer.parseInt(num.toString());
			} catch (NumberFormatException e) {
				return 0;
			}
			return -val;
		}
	}
}
