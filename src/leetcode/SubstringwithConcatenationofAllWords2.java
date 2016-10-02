package leetcode;

/* You are given a string, S, and a list of words, L, that are all of the same length. 
 * Find all starting indices of substring(s) in S that is a concatenation of each word
 * in L exactly once and without any intervening characters.
 * For example, given:
 * S: "barfoothefoobarman"
 * L: ["foo", "bar"]
 * You should return the indices: [0,9]. (order does not matter).
 */
import java.util.*;

/* Scan every wordlength*wordnum long string start from each position in S, see if all the strings in L 
 * have been appeared only once using Map data structure. If so, store the starting position.
 */
public class SubstringwithConcatenationofAllWords2 {
	public static List<Integer> findSubstring(String s, String[] words) {
		if (words.length < 1)
			return new ArrayList<Integer>();

		int start, wordLength = words[0].length();
		int sliceLength = wordLength * words.length;

		Map<String, Integer> wordsLookup = buildLookup(words);
		List<Integer> startLoc = new ArrayList<Integer>();
		for (start = 0; start + sliceLength - 1 < s.length(); start++) {
			String sub = s.substring(start, start + sliceLength);
			if (isSubString(sub, wordsLookup, wordLength)) {
				startLoc.add(start);
			}
		}

		return startLoc;
	}

	private static Map<String, Integer> buildLookup(String[] words) {
		Map<String, Integer> lookup = new HashMap<String, Integer>();
		for (String s : words) {
			if (lookup.containsKey(s))
				lookup.put(s, lookup.get(s) + 1);
			else
				lookup.put(s, 1);
		}
		return lookup;
	}

	private static boolean isSubString(String sub, Map<String, Integer> wordLookup, int wordLength) {
		Map<String, Integer> subLookup = new HashMap<String, Integer>();

		for (int i = 0; i < sub.length(); i += wordLength) {
			String s = sub.substring(i, i + wordLength);
			if (!wordLookup.containsKey(s))
				return false;
			else if (subLookup.containsKey(s)) {
				if (subLookup.get(s) == wordLookup.get(s))
					return false;
				subLookup.put(s, subLookup.get(s) + 1);
			} else
				subLookup.put(s, 1);
		}
		return true;
	}
}
