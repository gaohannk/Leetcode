package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/* Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters.
 * You may assume that each word will contain only lower case letters. 
 * If no such two words exist, return 0.
 * Example 1:
 * Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]
 * Return 16
 * The two words can be "abcw", "xtfn".
 * Example 2:
 * Given ["a", "ab", "abc", "d", "cd", "bcd", "abcd"]
 * Return 4
 * The two words can be "ab", "cd".
 * Example 3:
 * Given ["a", "aa", "aaa", "aaaa"]
 * Return 0
 * No such pair of words.
 */
// TLE
public class MaximumProductofWordLengths2 {
	public int maxProduct(String[] words) {
		int max = 0;
		Arrays.sort(words, new Comparator<String>() {
			public int compare(String a, String b) {
				return b.length() - a.length();
			}
		});

		for (int i = 0; i < words.length; i++) {
			if (words[i].length() * words[i].length() <= max)
				break; // prunning
			int[] masks = new int[26];
			for (char c : words[i].toCharArray())
				masks[(c - 'a')] = 1;
			for (int j = i + 1; j < words.length; j++) {
				int[] masks2 = new int[26];
				for (char c : words[j].toCharArray())
					masks2[(c - 'a')] = 1;
				if (!isHaveCommon(masks, masks2)) {
					max = Math.max(max, words[i].length() * words[j].length());
					break; // prunning
				}
			}
		}
		return max;
	}

	public boolean isHaveCommon(int[] arr1, int[] arr2) {
		for (int k = 0; k < 26; k++) {
			if (arr1[k] == arr2[k])
				return true;
		}
		return false;
	}
}
