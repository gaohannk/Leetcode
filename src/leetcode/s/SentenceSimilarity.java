package leetcode.s;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given two sentences words1, words2 (each represented as an array of strings), and a list of similar word pairs pairs, determine if two sentences are similar.
 * <p>
 * For example, "great acting skills" and "fine drama talent" are similar, if the similar word pairs are pairs = [["great", "fine"], ["acting","drama"], ["skills","talent"]].
 * <p>
 * Note that the similarity relation is not transitive. For example, if "great" and "fine" are similar, and "fine" and "good" are similar, "great" and "good" are not necessarily similar.
 * <p>
 * However, similarity is symmetric. For example, "great" and "fine" being similar is the same as "fine" and "great" being similar.
 * <p>
 * Also, a word is always similar with itself. For example, the sentences words1 = ["great"], words2 = ["great"], pairs = [] are similar, even though there are no specified similar word pairs.
 * <p>
 * Finally, sentences can only be similar if they have the same number of words. So a sentence like words1 = ["great"] can never be similar to words2 = ["doubleplus","good"].
 * <p>
 * Note:
 * <p>
 * The length of words1 and words2 will not exceed 1000.
 * The length of pairs will not exceed 2000.
 * The length of each pairs[i] will be 2.
 * The length of each words[i] and pairs[i][j] will be in the range [1, 20].
 */
public class SentenceSimilarity {
    public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
        if (words1.length != words2.length)
            return false;

        Map<String, Set<String>> similarMap = new HashMap<>();

        for (String[] pair : pairs) {
            if (!similarMap.containsKey(pair[0]))
                similarMap.put(pair[0], new HashSet<>());
            if (!similarMap.containsKey(pair[1]))
                similarMap.put(pair[1], new HashSet<>());
            similarMap.get(pair[0]).add(pair[1]);
            similarMap.get(pair[1]).add(pair[0]);
        }

        for (int i = 0; i < words1.length; ++i) {
            if (words1[i].equals(words2[i]))
                continue;
            if (!similarMap.containsKey(words1[i]))
                return false;
            if (!similarMap.get(words1[i]).contains(words2[i]))
                return false;
        }

        return true;
    }
}
