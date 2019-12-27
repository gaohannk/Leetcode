package leetcode.algo.i;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class IndexPairsofaString2 {
    public int[][] indexPairs(String text, String[] words) {
        Trie root = new Trie('#');
        for (String word : words) {
            Trie cur = root;
            for (char c : word.toCharArray()) {
                if (cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new Trie(c);
                }
                cur = cur.children[c - 'a'];
            }
            cur.isWord = true;
        }
        List<int[]> list = new LinkedList<>();
        for (int i = 0; i < text.length(); i++) {
            Trie cur = root;
            for (int j = i; j < text.length(); j++) {
                if (cur.children[text.charAt(j) - 'a'] == null) {
                    break;
                }
                if (cur.children[text.charAt(j) - 'a'].isWord) {
                    list.add(new int[]{i, j + 1});
                }
                cur = cur.children[text.charAt(j) - 'a'];
            }
        }
        return list.toArray(new int[list.size()][]);
    }

    class Trie {
        public char c;
        public Trie children[] = new Trie[26];
        public boolean isWord = false;

        Trie(char c) {
            this.c = c;
        }
    }
}
