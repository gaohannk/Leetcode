package leetcode;

import java.util.LinkedList;
import java.util.Queue;

import leetcode.ImplementTriePrefixTree2.TrieNode;

/* Design a data structure that supports the following two operations:
 * void addWord(word)
 * bool search(word)
 * search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.
 * For example:
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 * Note:
 * You may assume that all words are consist of lowercase letters a-z.
 * You should be familiar with how a Trie works. If not, please work on this problem: Implement Trie (Prefix Tree) first.
 */
//Array Implement

public class AddandSearchWordDatastructuredesign {
	class TrieNode {
		TrieNode[] children;
		boolean flag;

		public TrieNode() {
			this.children = new TrieNode[26];
			this.flag = false;
		}
	}

	public TrieNode root = new TrieNode();

	// Adds a word into the data structure.
	public void addWord(String word) {
		if (word == null || word.length() == 0)
			return;
		TrieNode node = root;
		for (int i = 0; i < word.length(); i++) {
			if (node.children[word.charAt(i) - 'a'] == null) {
				node.children[word.charAt(i) - 'a'] = new TrieNode();
			}
			node = node.children[word.charAt(i) - 'a'];
		}
		node.flag = true;
	}

	// Returns if the word is in the data structure. A word could
	// contain the dot character '.' to represent any one letter.
	public boolean search(String word) {
		Queue<TrieNode> queue = new LinkedList<TrieNode>();
		TrieNode node = root;
		queue.add(node);
		int index = 0;
		while (!queue.isEmpty()) {
			if (index == word.length())
				return true;
			TrieNode curr = queue.poll();
			if (index == word.length() - 1)
				return curr.flag;
			if (word.charAt(index) == '.') {
				for (int i = 0; i < 26; i++) {
					if (curr.children[i] != null)
						queue.add(curr.children[i]);
				}
			} else {
				if (curr != null && curr.children[word.charAt(index) - 'a'] == null)
					break;
				else
					queue.add(curr.children[word.charAt(index) - 'a']);
			}
			index++;

		}
		return false;
	}
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
