package company.oracle.high;

import java.util.LinkedList;
import java.util.List;

// TLE
public class WordSquare {
    public static List<List<String>> wordSquares(String[] words) {
        List<List<String>> res = new LinkedList<>();

        for (String word : words) {
            int i = 0;
            List<String> list = new LinkedList<>();
            list.add(word);
            helper(words, list, res, i + 1, word.length());
        }
        return res;
    }

    private static void helper(String[] words, List<String> list, List<List<String>> res, int i, int len) {
        if (i == len) {
            res.add(new LinkedList<>(list));
            return;
        }
        String prefix = getPrefix(list, i);
        for (String word : words) {
            if (word.startsWith(prefix)) {
                list.add(word);
                helper(words, list, res, i + 1, len);
                list.remove(list.size() - 1);
            }
        }
    }

    private static String getPrefix(List<String> list, int i) {
        String prefix = "";
        for (int k = 0; k < list.size(); k++) {
            prefix += list.get(k).charAt(i);
        }
        return prefix;
    }

    public static void main(String[] args) {
        String[] words = {"area", "lead", "wall", "lady", "ball"};
        System.out.println(wordSquares(words));
    }

}
