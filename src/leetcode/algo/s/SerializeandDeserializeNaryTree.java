package leetcode.algo.s;

import java.util.List;

public class SerializeandDeserializeNaryTree {
	class Node {
		public int val;
		public List<Node> children;

		public Node() {}

		public Node(int _val) {
			val = _val;
		}

		public Node(int _val, List<Node> _children) {
			val = _val;
			children = _children;
		}
	}

	class Codec {

		// Encodes a tree to a single string.
		public String serialize(Node root) {

		}

		// Decodes your encoded data to tree.
		public Node deserialize(String data) {

		}
	}
}
