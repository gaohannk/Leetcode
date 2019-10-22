package leetcode.algo.s;

import leetcode.common.TreeNode;

import java.util.Stack;

/**
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 * <p>
 * Design an algorithm to serialize and deserialize a binary search tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary search tree can be serialized to a string and this string can be deserialized to the original tree structure.
 * <p>
 * The encoded string should be as compact as possible.
 * <p>
 * Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
 */
public class SerializeandDeserializeBST2 {
    public class Codec {
        public String serialize(TreeNode root) {
            return preOrder(root);
        }

        private String preOrder(TreeNode root) {
            Stack<TreeNode> s = new Stack<>();
            StringBuilder sb = new StringBuilder();
            TreeNode curr = root;
            while (curr != null || !s.isEmpty()) {
                while (curr != null) {
                    sb.append(curr.val + " ");
                    s.push(curr);
                    curr = curr.left;
                }
                curr = s.pop();
                curr = curr.right;
            }
            return sb.toString();
        }

        public TreeNode deserialize(String data) {
            if (data.length() == 0)
                return null;
            String[] s = data.split(" ");
            return decode(s, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        int i = 0;

        private TreeNode decode(String[] s, Integer min, Integer max) {
            if (i == s.length) return null;
            int val = Integer.parseInt(s[i]);
            if (val < min || val > max) {
                return null;
            }
            TreeNode curr = new TreeNode(val);
            ++i;
            curr.left = decode(s, min, curr.val);
            curr.right = decode(s, curr.val, max);
            return curr;
        }
    }
}
