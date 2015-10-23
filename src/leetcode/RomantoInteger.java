package leetcode;
/* Given a Roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 */
import java.util.*;

public class RomantoInteger {
	// method 1: add or subtract from the lower
	public int romanToInt(String s) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);

		int number = 0;
		int prev = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			char ch = s.charAt(i);
			int value = map.get(ch);
			if (value < prev) {
				number = number - value;
			} else {
				number = number + value;
			}
			prev = value;
		}
		return number;
	}
}
