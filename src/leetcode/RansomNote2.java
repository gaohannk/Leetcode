package leetcode;

import java.util.HashMap;
import java.util.Map;

/*
 * Given an random 
 */
public class RansomNote2 {
	public boolean canConstruct(String ransomNote, String magazine) {
		Map<Character, Integer> magM = new HashMap<>();
		for (char c : magazine.toCharArray()) {
			int newCount = magM.getOrDefault(c, 0) + 1;
			magM.put(c, newCount);
		}
		for (char c : ransomNote.toCharArray()) {
			int newCount = magM.getOrDefault(c, 0) - 1;
			if (newCount < 0)
				return false;
			magM.put(c, newCount);
		}
		return true;
	}
}