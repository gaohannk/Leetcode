package leetcode;

import java.util.HashSet;
import java.util.Set;

/*Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

 For example, given
 s = "leetcode",
 dict = ["leet", "code"].

 Return true because "leetcode" can be segmented as "leet code".
 */
/* Time: O(string length * dict size)
 * Define an array t[] such that t[i]==true => 0-(i-1) can be segmented using dictionary
 * Initial state t[0] == true
 */
public class WordBreak2 {
	public static boolean wordBreak(String s, Set<String> dict) {
		boolean[] t = new boolean[s.length() + 1];
		t[0] = true; // set first to be true, why?
		// Because we need initial state

		for (int i = 0; i <= s.length(); i++) {
			// should continue from match position
			for (int j = i ; j >= 0; j--) {
				if (t[j] && dict.contains(s.substring(j, i))) {
					System.out.println("t["+i+"]"+t[i]);
					t[i] = true;

					break;
				}
			}
		}
		return t[s.length()];
	}

	public static void main(String[] args) {
		HashSet<String> dict = new HashSet<>();
		dict.add("cat");
		dict.add("cats");
		dict.add("and");
		dict.add("sand");
		dict.add("dog");
		String s = "catsanddog";
		System.out.println(wordBreak(s, dict));
	}
}
