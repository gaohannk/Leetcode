package leetcode;

import java.util.Optional;

/* Implement a trie with insert, search, and startsWith methods.
 * Note:
 * You may assume that all inputs are consist of lowercase letters a-z.
 * 
	// Your Trie object will be instantiated and called as such:
	// Trie trie = new Trie();
	// trie.insert("somestring");
	// trie.search("key");
 */
// Recursive Solution
public class ImplementTriePrefixTree3 {
	class TrieNode {
		TrieNode[] children = new TrieNode['z' - 'a' + 1];
		boolean leaf = false;

		Optional<TrieNode> child(char c) {
			return Optional.ofNullable(children[c - 'a']);
		}

		TrieNode getOrCreateChild(char c) {
			if (!child(c).isPresent()) {
				children[c - 'a'] = new TrieNode();
			}
			return child(c).get();
		}
	}

	public class Trie {
		private TrieNode root = new TrieNode();

		public void insert(String word) {
			TrieNode node = root;
			for (char c : word.toCharArray()) {
				node = node.getOrCreateChild(c);
			}
			node.leaf = true;
		}

		public boolean search(String word) {
			return find(word).map(n -> n.leaf).orElse(false);
		}

		public boolean startsWith(String prefix) {
			return find(prefix).isPresent();
		}

		private Optional<TrieNode> find(String prefix) {
			Optional<TrieNode> node = Optional.of(root);
			for (int i = 0; i < prefix.length() && node.isPresent(); i++) {
				node = node.get().child(prefix.charAt(i));
			}
			return node;
		}
	}
}
