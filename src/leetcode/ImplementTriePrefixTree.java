package leetcode;

/* Implement a trie with insert, search, and startsWith methods.
 * Note:
 * You may assume that all inputs are consist of lowercase letters a-z.
 * 
	// Your Trie object will be instantiated and called as such:
	// Trie trie = new Trie();
	// trie.insert("somestring");
	// trie.search("key");
 */
public class ImplementTriePrefixTree {
	class TrieNode {
		// Initialize your data structure here.
		private int count;
		private boolean isWord;
		private TrieNode[] childen;

		public TrieNode() {
			this.childen = new TrieNode[26];
			this.isWord=false;
		}
	}

	public class Trie {
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
}
