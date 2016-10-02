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
//TLE
public class SubstringwithConcatenationofAllWords {
	public List<Integer> findSubstring(String S, String[] L) {
		List<Integer> list = new LinkedList<>();
		if (S == null || L == null)
			return list;
		Map<String, Integer> covered = new HashMap<String, Integer>();
		ArrayList<Integer> res = new ArrayList<Integer>();
		int wordlength = L[0].length();
		int wordnum = L.length;
		for (int j = 0; j < wordnum; j++) {
			if (covered.containsKey(L[j])) {
				covered.put(L[j], covered.get(L[j]) + 1);
			} else {
				covered.put(L[j], 1);
			}
		}
		
		for (int i = 0; i + wordlength * wordnum <= S.length(); i++) {
			Map<String, Integer> temp = new HashMap<String, Integer>(covered);
			for (int j = 0; j < wordnum; j++) {
				String testStr = S.substring(i + j * wordlength, i + (j + 1) * wordlength);
				if (temp.containsKey(testStr)) {
					if (temp.get(testStr) - 1 == 0)
						temp.remove(testStr);
					else
						temp.put(testStr, temp.get(testStr) - 1);
				} else
					break;
			}
			if (temp.size() == 0)
				res.add(i);
		}
		return res;
	}
}
