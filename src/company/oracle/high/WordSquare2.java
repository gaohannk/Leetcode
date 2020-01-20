package company.oracle.high;

import leetcode.common.TrieNode;

import java.util.LinkedList;
import java.util.List;


public class WordSquare2 {
    static class TrieNode {
        public TrieNode[] trieNodes = new TrieNode[26];
        public boolean isWord;
        public char c;
    }

    public static List<List<String>> wordSquares(String[] words) {
        List<List<String>> res = new LinkedList<>();
        TrieNode root = new TrieNode();
        TrieNode cur = root;
        for (String word : words) {
            for (char c : word.toCharArray()) {
                if(cur.trieNodes[c-'a'] == null) {
                    cur.trieNodes[c - 'a'] = new TrieNode();
                }
                cur = cur.trieNodes[c - 'a'];
            }
            cur.isWord = true;
        }

        helper(words, root, new LinkedList<>(), res, 0, words[0].length());
        return res;
    }

    private static void helper(String[] words, TrieNode node, List<String> list, List<List<String>> res, int i, int len) {
        if (i == len) {
            res.add(new LinkedList<>(list));
            return;
        }
        String prefix = getPrefix(list, i);
        for (String word : words) {
            if (searchWithPrefix(prefix, node)) {
                list.add(word);
                helper(words, node, list, res, i + 1, len);
                list.remove(list.size() - 1);
            }
        }
    }

    private static boolean searchWithPrefix(String prefix, TrieNode node) {
        return false;
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
