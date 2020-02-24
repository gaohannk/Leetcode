package company.qualtric;

import leetcode.common.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/* Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
 * For example, you may serialize the following tree
 *   1
 *  / \
 * 2   3
 *    / \
 *   4   5
 * as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
 * Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
 */
// DFS
public class SerializeandDeserializeBinaryTree2 {
	public class Codec {

		public String serialize(TreeNode root) {
			return serializeHelper(root, "");
		}

		private String serializeHelper(TreeNode root, String str) {
			if (root == null) {
				str += "null,";
			} else {
				str += root.val + ",";
				str = serializeHelper(root.left, str);
				str = serializeHelper(root.right, str);
			}
			return str;
		}

		// Decodes your encoded data to tree.
		public TreeNode deserialize(String data) {
			String[] splits = data.split(",");
			List<String> list = new LinkedList<>(Arrays.asList(splits));
			return deserializeHelper(list);
		}

		public TreeNode deserializeHelper(List<String> list) {
			if (list.get(0).equals("null")) {
				list.remove(0);
				return null;
			}

			TreeNode root = new TreeNode(Integer.valueOf(list.get(0)));
			list.remove(0);
			root.left = deserializeHelper(list);
			root.right = deserializeHelper(list);

			return root;
		}
	}
}
