package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		private Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
		  
	    public WordDistance(String[] words) {
			for (int i = 0; i < words.length; i++) {
				String word = words[i];
				if (map.containsKey(word)) {
					List<Integer> pos = map.get(word);
					pos.add(i);
					map.put(word, pos);
				} else {
					List<Integer> pos = new ArrayList<Integer>();
					pos.add(i);
					map.put(word, pos);
				}
			}
	    }

		public int shortest(String word1, String word2) {
			int min = Integer.MAX_VALUE;
			List<Integer> posA = map.get(word1);
			List<Integer> posB = map.get(word2);
			for (int i : posA) {
				for (int j : posB) {
					min = Math.min(min, Math.abs(i - j));
				}
			}
			return min;
		}
	}
}
