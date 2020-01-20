package company.oracle.high;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class WordSquare {
    int N = 0;
    String[] words = null;
    Map<String, List<String>> prefixHashTable = null;

    public List<List<String>> wordSquares(String[] words) {
        this.words = words;
        this.N = words[0].length();

        List<List<String>> results = new LinkedList<>();
        buildPrefixHashTable(words);

        for (String word : words) {
            LinkedList<String> wordSquares = new LinkedList<>();
            wordSquares.addLast(word);
            helper(1, wordSquares, results);
        }
        return results;
    }

    protected void helper(int step, LinkedList<String> wordSquares,
                          List<List<String>> results) {
        if (step == N) {
            results.add((List<String>) wordSquares.clone());
            return;
        }

        StringBuilder prefix = new StringBuilder();
        for (String word : wordSquares) {
            prefix.append(word.charAt(step));
        }

        for (String candidate : getWordsWithPrefix(prefix.toString())) {
            wordSquares.addLast(candidate);
            helper(step + 1, wordSquares, results);
            wordSquares.removeLast();
        }
    }

    protected void buildPrefixHashTable(String[] words) {
        prefixHashTable = new HashMap<>();

        for (String word : words) {
            for (int i = 1; i < this.N; ++i) {
                String prefix = word.substring(0, i);
                List<String> wordList = this.prefixHashTable.get(prefix);
                if (wordList == null) {
                    wordList = new LinkedList<>();
                    wordList.add(word);
                    this.prefixHashTable.put(prefix, wordList);
                } else {
                    wordList.add(word);
                }
            }
        }
    }

    protected List<String> getWordsWithPrefix(String prefix) {
        List<String> wordList = this.prefixHashTable.get(prefix);
        return wordList != null ? wordList : new LinkedList<>();
    }
}
