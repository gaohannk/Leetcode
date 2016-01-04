package leetcode;

import java.util.*;

/* Given a digit string, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class LetterCombinationsofaPhoneNumber2 {
	public List<String> letterCombinations(String digits) {
		Hashtable<Integer, String> table = new Hashtable<Integer, String>();
		table.put(2, "abc");
		table.put(3, "def");
		table.put(4, "ghi");
		table.put(5, "jkl");
		table.put(6, "mno");
		table.put(7, "pqrs");
		table.put(8, "tuv");
		table.put(9, "wxyz");
		return letterCombinationsHelper(digits, table);
	}

	public static List<String> letterCombinationsHelper(String digits, Hashtable<Integer, String> table) {
		ArrayList<String> result = new ArrayList<String>();
		if (digits.length() == 0) {
			result.add("");
			return result;
		}
		List<String> prev = letterCombinationsHelper(digits.substring(0, digits.length() - 1), table);
		int num = digits.charAt(digits.length() - 1) - '0';
		String str = table.get(num);
		char[] chars = str.toCharArray();
		for (int i = 0; i < str.length(); i++) {
			for (int j = 0; j < prev.size(); j++) {
				result.add(prev.get(j) + chars[i]);
			}
		}
		return result;
	}
}
