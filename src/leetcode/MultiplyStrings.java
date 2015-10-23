package leetcode;
/* Given two numbers represented as strings, return multiplication of the numbers as a string.
 * Note: The numbers can be arbitrarily large and are non-negative.
 */
public class MultiplyStrings {
	public String multiply(String num1, String num2) {

		if ((num1.equals("")) || (num2.equals("")) || (!num1.matches("[0-9]+"))
				|| (!num2.matches("[0-9]+")))
			return "";
		
		int[] output = new int[num1.length() + num2.length()];
		
		for (int i = num1.length() - 1; i >= 0; i--) {
			
			int carryM = 0;
			int carryS = 0;
			
			for (int j = num2.length() - 1; j >= 0; j--) {
				int m1 = Integer.parseInt(num1.substring(i, i + 1));
				int m2 = Integer.parseInt(num2.substring(j, j + 1));
				int mult = (m1 * m2) + carryM;
				carryM = mult / 10;
				int rest = mult % 10;

				int inc = output[j + i + 1] + rest + carryS;
				output[j + i + 1] = inc % 10;
				carryS = inc / 10;
			}
			output[i] = carryM + carryS;
		}
		
		StringBuilder out = new StringBuilder();
		boolean firstZeros = true;
		for (int i = 0; i < output.length; i++) {
			if ((output[i] == 0) && (i != output.length - 1)) {
				if (!firstZeros)
					out.append(output[i]);
			} else {
				out.append(output[i]);
				firstZeros = false;
			}
		}

		return out.toString();
	}
}
