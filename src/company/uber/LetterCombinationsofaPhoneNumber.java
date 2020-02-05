package company.uber;

/* Given a digit string, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class LetterCombinationsofaPhoneNumber {
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
		ArrayList<String> list = new ArrayList<String>();
		String str = "";
		helper(digits, str, list, table, 0);
		return list;
	}

	public static void helper(String digits, String str, ArrayList<String> list, Hashtable<Integer, String> table, int index) {

		if (str.length() == digits.length()) {
			list.add(str);
		}
		if (index < digits.length()) {
			int num = digits.charAt(index) - '0';
			String s = table.get(num);
			for (int i = 0; i < s.length(); i++) {
				String nextString = str + s.charAt(i);
				helper(digits, nextString, list, table, index + 1);
			}
		}
	}
}
