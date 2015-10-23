package leetcode;

import java.util.Map;
import java.util.HashMap;

/* Given a Roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 */
public class RomantoInteger2 {
	public int romanToInt(String s) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		int prev = 0, total = 0;
		for (char c : s.toCharArray()) {
			int curr = map.get(c);
			total += (curr > prev) ? (curr - 2 * prev) : curr;
			prev = curr;
		}
		return total;
	}
}