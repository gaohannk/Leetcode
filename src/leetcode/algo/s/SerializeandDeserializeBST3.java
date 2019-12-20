package leetcode.algo.s;

import leetcode.common.TreeNode;

/**
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 * <p>
 * Design an algorithm to serialize and deserialize a binary search tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary search tree can be serialized to a string and this string can be deserialized to the original tree structure.
 * <p>
 * The encoded string should be as compact as possible.
 * <p>
 * Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
 */
public class SerializeandDeserializeBST3 {
	public class Codec {
		// Encodes a tree to a single string.
		public String serialize(TreeNode root) {
			// preorder traversal
			if (root == null)
				return "n";
			return "" + root.val + "," + serialize(root.left) + "," + serialize(root.right);
		}

		// Decodes your encoded data to tree.
		public TreeNode deserialize(String data) {
			return helper(data.split(","), new int[]{0});
		}

		public TreeNode helper(String[] splits, int[] id) {
			if (id[0] > splits.length)
				return null;
			String cur = splits[id[0]];
			if (cur.equals("n"))
				return null;
			TreeNode root = new TreeNode(Integer.parseInt(cur));
			id[0]++;
			root.left = helper(splits, id);
			id[0]++;
			root.right = helper(splits, id);
			return root;
		}
	}
}
