package leetcode;

import java.util.HashMap;

public class TrieNode {
    char c;
    HashMap<Character, TrieNode> children = new HashMap();
    int end;

    public TrieNode(char c) {
        this.c = c;
    }
}
