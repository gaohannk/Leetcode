package leetcode.algo.s;

import java.util.*;

/**
 * Given two sentences words1, words2 (each represented as an array of strings), and a list of similar word pairs pairs, determine if two sentences are similar.
 *
 * For example, words1 = ["great", "acting", "skills"] and words2 = ["fine", "drama", "talent"] are similar, if the similar word pairs are pairs = [["great", "good"], ["fine", "good"], ["acting","drama"], ["skills","talent"]].
 *
 * Note that the similarity relation is transitive. For example, if "great" and "good" are similar, and "fine" and "good" are similar, then "great" and "fine" are similar.
 *
 * Similarity is also symmetric. For example, "great" and "fine" being similar is the same as "fine" and "great" being similar.
 *
 * Also, a word is always similar with itself. For example, the sentences words1 = ["great"], words2 = ["great"], pairs = [] are similar, even though there are no specified similar word pairs.
 *
 * Finally, sentences can only be similar if they have the same number of words. So a sentence like words1 = ["great"] can never be similar to words2 = ["doubleplus","good"].
 *
 * Note:
 *
 * The length of words1 and words2 will not exceed 1000.
 * The length of pairs will not exceed 2000.
 * The length of each pairs[i] will be 2.
 * The length of each words[i] and pairs[i][j] will be in the range [1, 20].
 */
public class SentenceSimilarityII {
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, List<List<String>> pairs) {
        if (words1.length != words2.length) {
            return false;
        }
        Map<String, Set<String>> graph = new HashMap();
        for (List<String> pair : pairs) {
            if (!graph.containsKey(pair.get(0))) {
                graph.put(pair.get(0), new HashSet<>());
            }
            if (!graph.containsKey(pair.get(1))) {
                graph.put(pair.get(1), new HashSet());
            }
            graph.get(pair.get(0)).add(pair.get(1));
            graph.get(pair.get(1)).add(pair.get(0));
        }

        for(int i = 0 ; i < words1.length; i++){
            if(!areTheySimilar(words1[i], words2[i], graph, new HashSet()))
                return false;
        }

        return true;
    }

    private boolean areTheySimilar(String w1, String w2, Map<String, Set<String>> graph, Set<String> visited){
        if(w1.equals(w2)) {
            return true;
        }

        if(graph.containsKey(w1) && !visited.contains(w1)){
            visited.add(w1);
            for(String word: graph.get(w1)){
                if(areTheySimilar(word, w2, graph, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
}
