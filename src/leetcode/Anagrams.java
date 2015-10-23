package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/* Given an array of strings, return all groups of strings that are anagrams.
 * Note: All inputs will be in lower-case.
 */
public class Anagrams {
	public ArrayList<String> anagrams(String[] strs) {
		ArrayList<String> result = new ArrayList<String>();
		if (strs.length == 0||strs==null)
			return result;
		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		for (String s : strs) {
			char[] chars = s.toCharArray();
			Arrays.sort(chars);
			String tempStr = new String(chars);
			if (map.containsKey(tempStr)) {
				map.get(tempStr).add(s);
			} else {
				ArrayList<String> list = new ArrayList<String>();
				list.add(s);
				map.put(tempStr, list);
			}
		}
		for (String str : map.keySet()) {
			if (map.get(str).size() > 1) {
				for (String s : map.get(str))
					result.add(s);
			}
		}
		return result;
	}
}
