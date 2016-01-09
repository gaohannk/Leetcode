package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* Given a string, we can “shift” each of its letter to its successive letter, for example: “abc” -> “bcd”. 
 * We can keep “shifting” which forms the sequence:
 * "abc" -> "bcd" -> ... -> "xyz"
 * Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.
 * For example,
 * given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"], Return:
 * 
 * [
 *  ["abc","bcd","xyz"],
 *  ["az","ba"],
 *  ["acef"],
 *  ["a","z"]
 * ]
 * Note: For the return value, each inner list’s elements must follow the lexicographic order.
 */
public class GroupShiftedStrings {
	public List<List<String>> groupStrings(String[] strings) {
		if (strings == null)
			return null;
		List<List<String>> res = new ArrayList<>();
		Map<String, List<String>> map = new HashMap<>();

		for (String s : strings) {
			String code = getFeatureCode(s);
			List<String> val;
			if (!map.containsKey(code))
				val = new ArrayList<>();
			else
				val = map.get(code);
			val.add(s);
			map.put(code, val);
		}

		for (String key : map.keySet()) {
			List<String> val = map.get(key);
			Collections.sort(val);
			res.add(val);
		}
		return res;
	}

	private String getFeatureCode(String s) {
		StringBuilder sb = new StringBuilder();
		sb.append("#");
		for (int i = 1; i < s.length(); i++) {
			int tmp = Math.abs(s.charAt(i) - s.charAt(i - 1));
			sb.append(tmp).append("#");
		}
		return sb.toString();
	}

}
