package leetcode;

import java.util.LinkedList;
import java.util.Queue;

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
public class SerializeandDeserializeBinaryTree {
	public String serialize(TreeNode root) {
		if (root == null)
			return "N";

		StringBuilder data = new StringBuilder();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);

		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if (node == null) {
				data.append("N,");
			} else {
				data.append(node.val).append(',');
				queue.offer(node.left);
				queue.offer(node.right);
			}
		}
		data.deleteCharAt(data.length() - 1);
		return data.toString();
	}

	public TreeNode deserialize(String data) {
		String[] nodes = data.split("\\,");
		if (nodes.length == 1)
			return null;

		TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		int i = 1; // starting from the second node if root is not null

		while (i < nodes.length) {
			TreeNode node = queue.poll();

			String left = nodes[i++], right = nodes[i++];
			if (!left.equals("N")) {
				TreeNode lChild = new TreeNode(Integer.parseInt(left));
				node.left = lChild;
				queue.offer(lChild);
			}
			if (!right.equals("N")) {
				TreeNode rChild = new TreeNode(Integer.parseInt(right));
				node.right = rChild;
				queue.offer(rChild);
			}
		}
		return root;
	}
}
