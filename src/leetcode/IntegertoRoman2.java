package leetcode;
/* Given an integer, convert it to a Roman numeral.
 * Input is guaranteed to be within the range from 1 to 3999.
 */
public class IntegertoRoman2 {
	// recursive
	public String intToRoman(int num) {
		int[] int_dict = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
		String[] roman_dict = { "M", "CM", "D", "CD", "C", "XC", "L", "XL",
				"X", "IX", "V", "IV", "I" };
		for (int i = 0; i <= int_dict.length - 1; i++) {
			if (num - int_dict[i] >= 0)
				return roman_dict[i] + intToRoman(num - int_dict[i]);
		}
		return "";
	}
}
