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
public class WordLadder {
	public int ladderLength(String start, String end, Set<String> dict) {
		if (start.equals(end))
			return 0;
		Queue<String> words = new LinkedList<String>();
		Queue<Integer> steps = new LinkedList<Integer>();
		Set<String> unused = new HashSet<String>(dict);
		unused.remove(start);
		words.add(start);
		steps.add(Integer.valueOf(0));

		while (!words.isEmpty()) {
			String word = words.remove();
			int step = steps.remove().intValue();
			for (int i = 0; i < word.length(); i++) {
				for (char ch = 'a'; ch <= 'z'; ch++) {
					String newly = word.substring(0, i) + ch + word.substring(i + 1);
					if (newly.equals(end)) {
						return step + 2;
					}
					if (unused.contains(newly)) {
						words.add(newly);
						steps.add(Integer.valueOf(step + 1));
						unused.remove(newly); // NOTE: put this argument here
												// accelerates.
					}
				}
			}
		}
		return 0;
	}
}
