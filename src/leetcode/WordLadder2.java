package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/* Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the dictionary
 * For example,
 * Given:
 * start = "hit"
 * end = "cog"
 * dict = ["hot","dot","dog","lot","log"]
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5. 
 * Note:
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 */
public class WordLadder2 {
	public int ladderLength(String start, String end, Set<String> dict) {
		if (start.equals(end))
			return 0;
		Queue<String> queue = new LinkedList<String>();
		queue.add(start);
		int level = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				String cur = queue.remove();
				if (cur.equals(end)) {
					return level + 1;
				}
				for (int j = 0; j < cur.length(); j++) {
					char[] word = cur.toCharArray();
					for (char ch = 'a'; ch < 'z'; ch++) {
						word[j] = ch;
						String check = new String(word);
						if (!check.equals(cur) && dict.contains(check)) {
							queue.add(check);
							dict.remove(check);
						}
					}
				}
			}
			level++;
		}
		return 0;
	}
}
