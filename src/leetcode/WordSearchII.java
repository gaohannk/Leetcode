package leetcode;

import java.util.*;

/* Given a 2D board and a list of words from the dictionary, find all words in the board.

Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

For example,
Given words = ["oath","pea","eat","rain"] and board =

[
		['o','a','a','n'],
		['e','t','a','e'],
		['i','h','k','r'],
		['i','f','l','v']
]
		Return ["eat","oath"].
You would need to optimize your backtracking to pass the larger test. Could you stop backtracking earlier?

If the current candidate does not exist in all words' prefix, you could stop backtracking immediately. What kind of data structure could answer such query efficiently? Does a hash table work? Why or why not? How about a Trie? If you would like to learn how to implement a basic trie, please work on this problem: Implement Trie (Prefix Tree) first.
 */
public class WordSearchII {
    class TrieNode {
        // Initialize your data structure here.
        private int count;
        private boolean isWord;
        private TrieNode[] childen;

        public TrieNode() {
            this.childen = new TrieNode[26];
            this.isWord = false;
        }
    }

    class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        // Inserts a word into the trie.
        public void insert(String word) {
            if (word == null || word.length() == 0)
                return;
            TrieNode parent = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                TrieNode child = parent.childen[c - 'a'];
                if (child == null) {
                    child = new TrieNode();
                    parent.childen[c - 'a'] = child;
                }
                parent = child;
            }
            parent.isWord = true;
        }

        // Returns if the word is in the trie.
        public boolean search(String word) {
            if (word == null || word.length() == 0)
                return false;
            TrieNode parent = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                TrieNode child = parent.childen[c - 'a'];
                if (child == null) {
                    return false;
                }
                parent = child;
            }
            return parent.isWord;
        }

        // Returns if there is any word in the trie
        // that starts with the given prefix.
        public boolean startsWith(String prefix) {
            if (prefix == null || prefix.length() == 0)
                return false;
            TrieNode parent = root;
            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                TrieNode child = parent.childen[c - 'a'];
                if (child == null) {
                    return false;
                }
                parent = child;
            }
            return true;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        List<String> res = new LinkedList<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                String word = "";
                findWordsHelper(res, board, i, j, word, trie);
            }
        }
        return res;
    }

    private void findWordsHelper( List<String> res, char[][] board, int i, int j, String word, Trie trie) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return;
        }
        if(board[i][j]=='*')
            return;
        word += board[i][j];
        if (!trie.startsWith(word))
            return;
        if (trie.search(word)&& !res.contains(word)) {
            res.add(word);
        }
        char storeChar = board[i][j];
        board[i][j] = '*'; //temporally remove the (i, j) char from the board.
        findWordsHelper(res, board, i - 1, j, word, trie);
        findWordsHelper(res, board, i + 1, j, word, trie);
        findWordsHelper(res, board, i, j - 1, word, trie);
        findWordsHelper(res, board, i, j + 1, word, trie);
        board[i][j] = storeChar; //restore the char.
    }
}
