package leetcode.algo.s;

import leetcode.common.TreeNode;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 * <p>
 * Design an algorithm to serialize and deserialize a binary search tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary search tree can be serialized to a string and this string can be deserialized to the original tree structure.
 * <p>
 * The encoded string should be as compact as possible.
 * <p>
 * Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
 */
public class SerializeandDeserializeBST {
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
            return build(Arrays.stream(data.split(",")).iterator());
        }

        TreeNode build(Iterator<String> it) {
            if (!it.hasNext())
                return null;
            String cur = it.next();
            if (cur.equals("n"))
                return null;
            TreeNode root = new TreeNode(Integer.parseInt(cur));
            root.left = build(it);
            root.right = build(it);
            return root;
        }
    }
}
