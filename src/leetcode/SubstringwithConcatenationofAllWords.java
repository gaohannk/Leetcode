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

public class SubstringwithConcatenationofAllWords {
	public List<Integer> findSubstring(String S, String[] L) {
		HashSet<String> set = new HashSet<String>();
		ArrayList<Integer> list= new ArrayList<Integer>();
		for (String s : L) {
			if (!set.contains(s))
				set.add(s);
		}
		boolean flag=false;
		int j=0;
		for (int i = 0; i < S.length(); i++) {
			int length=0;
			for (j = i + 1; j < S.length(); j++) {
				if (set.contains(S.substring(i, j))) {
					set.remove(S.substring(i, j));
					length+=S.substring(i,j).length();
					flag=true;
					break;
				}
			}
			if(set.isEmpty())
				list.add(j-length);
			if(flag)
			  i=j;
		}
		return list;
	}
}
