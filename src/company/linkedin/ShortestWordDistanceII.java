package company.linkedin;

import java.util.HashMap;
import java.util.LinkedList;

/* This is a follow up of Shortest Word Distance. The only difference is now you are given the list of words and your method will be called repeatedly many times with different parameters. How would you optimize it?
 * Design a class which receives a list of words in the constructor, and implements a method that takes two words word1 and word2 and return the shortest distance between these two words in the list.
 * For example,
 * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 * Given word1 = "coding”, word2 = "practice”, return 3.
 * Given word1 = "makes", word2 = "coding", return 1.
 * Note:
 * You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
 */
/* Your WordDistance object will be instantiated and called as such:
 * WordDistance wordDistance = new WordDistance(words);
 * wordDistance.shortest("word1", "word2");
 * wordDistance.shortest("anotherWord1", "anotherWord2");
 */

/* The key idea is to store the indexes of each word using a hash map. 
 * Then the function shortest() is just to find the minimum difference between two sorted lists 
 */
public class ShortestWordDistanceII {
	class WordDistance {
		HashMap<String, LinkedList<Integer>> map;

		public WordDistance(String[] words) {
			map = new HashMap<String, LinkedList<Integer>>();

			// Prepare a mapping from a word to all it's locations (indices).
			for (int i = 0; i < words.length; i++) {
				LinkedList<Integer> loc = map.getOrDefault(words[i], new LinkedList<>());
				loc.add(i);
				map.put(words[i], loc);
			}
		}

		public int shortest(String word1, String word2) {
			LinkedList<Integer> id1 = map.get(word1);
			LinkedList<Integer> id2 = map.get(word2);
			int l1 = 0, l2 = 0, minDiff = Integer.MAX_VALUE;

			while (l1 < id1.size() && l2 < id2.size()) {
				minDiff = Math.min(minDiff, Math.abs(id1.get(l1) - id2.get(l2)));
				if (id1.get(l1) < id2.get(l2)) {
					l1++;
				} else {
					l2++;
				}
			}

			return minDiff;
		}
	}
}
