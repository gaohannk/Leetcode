package leetcode;

import java.util.HashMap;

public class RansomNote {
	public boolean canConstruct(String ransomNote, String magazine) {

		HashMap<Character, Integer> map = new HashMap<Character, Integer>();

		for (int i = 0; i < magazine.length(); i++) {
			if (null != map.get(magazine.charAt(i)))
				map.put(magazine.charAt(i), map.get(magazine.charAt(i)) + 1);
			else
				map.put(magazine.charAt(i), 1);

		}

		for (int i = 0; i < ransomNote.length(); i++) {
			if (null == map.get(ransomNote.charAt(i)) || 0 == map.get(ransomNote.charAt(i))) {
				return false;
			} else
				map.put(ransomNote.charAt(i), map.get(ransomNote.charAt(i)) - 1);

		}
		return true;
	}
}