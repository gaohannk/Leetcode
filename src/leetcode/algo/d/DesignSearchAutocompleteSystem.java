package leetcode.algo.d;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

// HashMap
public class DesignSearchAutocompleteSystem {

    class Node {
        String sentence;
        int times;

        Node(String st, int t) {
            sentence = st;
            times = t;
        }
    }

    class Trie {
        Trie[] child = new Trie[27];
        Integer times;
    }

    class AutocompleteSystem {

        private Trie root = new Trie();
        private String cur_sent = "";

        public AutocompleteSystem(String[] sentences, int[] times) {
            for (int i = 0; i < sentences.length; i++) {
                buildTrie(root, sentences[i], times[i]);
            }
        }

        private void buildTrie(Trie root, String sentence, int time) {
            for (int i = 0; i < sentence.length(); i++) {
                if (sentence.charAt(i) == ' ') {
                    if (root.child[26] == null) {
                        root.child[26] = new Trie();
                    }
                    root = root.child[26];
                } else {
                    int id = sentence.charAt(i) - 'a';
                    if (root.child[id] == null) {
                        root.child[id] = new Trie();
                    }
                    root = root.child[id];
                }
            }
            if (root.times != null) {
                root.times += time;
            } else {
                root.times = time;
            }
        }

        public List<String> input(char c) {
            List<String> res = new LinkedList<>();
            if (c == '#') {
                buildTrie(root, cur_sent, 1);
                cur_sent = "";
            } else {
                List<Node> list = new LinkedList<>();
                cur_sent += c;
                traverseTrie(root, list, cur_sent);
                Collections.sort(list, (a, b) -> a.times == b.times ? a.sentence.compareTo(b.sentence) : b.times - a.times);
                int end = Math.min(3, list.size());
                for (int i = 0; i < end; i++) {
                    res.add(list.get(i).sentence);
                }
            }
            return res;
        }

        private void traverseTrie(Trie root, List<Node> list, String cur_sent) {
            // all the cur_sent need to match
            for (int i = 0; i < cur_sent.length(); i++) {
                if (cur_sent.charAt(i) == ' ') {
                    if (root.child[26] == null) {
                        return;
                    }
                    root = root.child[26];
                } else {
                    int id = cur_sent.charAt(i) - 'a';
                    if (root.child[id] == null) {
                        return;
                    }
                    root = root.child[id];
                }
            }
            // begin search
            helper(root, list, cur_sent);
        }

        private void helper(Trie root, List<Node> list, String s) {
            if (root.times != null) {
                list.add(new Node(s, root.times));
            }
            for (char i = 'a'; i <= 'z'; i++) {
                if (root.child[i - 'a'] != null) {
                    helper(root.child[i - 'a'], list, s + i);
                }
            }
            if (root.child[26] != null) {
                helper(root.child[26], list, s + ' ');
            }
        }
    }
}
