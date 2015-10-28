package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
 * Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
 * For example,
 * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 * Given word1 = "coding", word2 = "practice", return 3. Given word1 = "makes", word2 = "coding", return 1.
 * Note:
 * You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
 */
public class ShortestWordDistance {
	public int shortestDistance(String[] words, String word1, String word2) {
		List<Integer> l1 = new LinkedList<Integer>();
		List<Integer> l2 = new LinkedList<Integer>();
		for (int i = 0; i < words.length; i++) {
			String s = words[i];
			if (s.equals(word1))
				l1.add(i);
			if (s.equals(word2))
				l2.add(i);
		}

		int min = Integer.MAX_VALUE;
		for (int a : l1) {
			for (int b : l2) {
				min = Math.min(Math.abs(b - a), min);
			}
		}
		return min;
	}
}
