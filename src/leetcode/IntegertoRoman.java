package leetcode;

/* Given an integer, convert it to a Roman numeral.
 * Input is guaranteed to be within the range from 1 to 3999.
 */
public class IntegertoRoman {
	// iteration
	public String intToRoman(int num) {
		int[] int_dict = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
		String[] roman_dict = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
		String roman = "";
		int i = 0;
		while (num > 0) {
			if (num - int_dict[i] >= 0) {
				roman += roman_dict[i];
				num -= int_dict[i];
			} else
				i++;
		}
		return roman;
	}
}
