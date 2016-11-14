package leetcode;

/**
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 * <p>
 * Design an algorithm to serialize and deserialize a binary search tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary search tree can be serialized to a string and this string can be deserialized to the original tree structure.
 * <p>
 * The encoded string should be as compact as possible.
 * Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
 */
public class SerializeandDeserializeBST {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) { // preorder
        StringBuilder sb = new StringBuilder();
        serializedfs(root, sb);
        return sb.toString();
    }

    private void serializedfs(TreeNode root, StringBuilder sb) {
        if (root == null)
            return; // no "null "
        sb.append(root.val).append(" ");
        serializedfs(root.left, sb);
        serializedfs(root.right, sb);
    }

    public TreeNode deserialize(String data) {

    return null;
    }
}
