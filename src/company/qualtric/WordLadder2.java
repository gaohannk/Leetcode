package company.qualtric;

import java.util.*;

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
// BFS with Map
public class WordLadder2 {
    public int ladderLength(String startWord, String endWord, List<String> wordList) {
        if (startWord.equals(endWord))
            return 0;
        // *ug -> dug, hug
        // h*g -> hug, heg
        Map<String, List<String>> allComboDict = new HashMap<>();
        for (String word : wordList) {
            for (int i = 0; i < word.length(); i++) {
                // Key is the generic word
                // Value is a list of words which have the same intermediate generic word.
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1);
                allComboDict.putIfAbsent(newWord, new ArrayList<>());
                List<String> transformations = allComboDict.get(newWord);
                transformations.add(word);
            }
        }

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<String>();
        queue.add(startWord);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.remove();
                visited.add(cur);
                if (cur.equals(endWord)) {
                    return level + 1;
                }
                for (int j = 0; j < cur.length(); j++) {
                    String pattern = cur.substring(0, j) + '*' + cur.substring(j + 1);
                    for (String nextWord : allComboDict.getOrDefault(pattern, new ArrayList<>())) {
                        if (!nextWord.equals(cur) && !visited.contains(nextWord)) {
                            queue.add(nextWord);
                        }
                    }
                }
            }
            level++;
        }
        return 0;
    }
}
