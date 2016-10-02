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

public class SubstringwithConcatenationofAllWords3 {
	public List<Integer> findSubstring(String S, String[] L) {
		List<Integer> res = new ArrayList<>();
		if (L.length == 0)
			return res;
		int len = L[0].length();
		int num = L.length;
		if (len * num > S.length())
			return res;

		// histogram of words in L
		HashMap<String, Integer> dic = new HashMap<>();
		for (String s : L) {
			if (dic.containsKey(s)) {
				dic.put(s, dic.get(s) + 1);
			} else {
				dic.put(s, 1);
			}
		}

		// the word that starts from i in S
		String[] sDic = new String[S.length() - len + 1];
		for (int i = 0; i < sDic.length; i++) {
			String sub = S.substring(i, i + len);
			if (dic.containsKey(sub)) {
				sDic[i] = sub;
			} else {
				sDic[i] = "";
			}
		}

		// traverse in order of
		// 0,0+len,...,1,1+len,...len-1,len-1+len...therefore it is O(n) despite
		// of two loops
		for (int i = 0; i < len; i++) {
			// start of concatenation
			int start = i;
			// number of words found
			int found = 0;
			// dynamic word histogram of words in substring(start,j);
			HashMap<String, Integer> tempDic = new HashMap<>();
			for (int j = i; j <= S.length() - len; j = j + len) {
				String word = sDic[j];
				if (word.equals("")) {
					tempDic = new HashMap<>();
					start = j + len;
					found = 0;
					continue;
				} else {
					if (!tempDic.containsKey(word)) {
						tempDic.put(word, 1);
					} else {
						tempDic.put(word, tempDic.get(word) + 1);
					}
					found++;
				}
				// if we over-count a word, delete the word from front until we meet this over-count word. Also
				// delete the over-count word
				if (tempDic.get(word) > dic.get(word)) {
					while (!sDic[start].equals(word)) {
						tempDic.put(sDic[start], tempDic.get(sDic[start]) - 1);
						start += len;
						found--;
					}
					tempDic.put(word, tempDic.get(word) - 1);
					start += len;
					found--;
				}
				if (found == num) {
					res.add(start);
				}
			}
		}
		return res;
	}
}
