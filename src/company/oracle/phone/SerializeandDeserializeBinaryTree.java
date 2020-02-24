

package company.oracle.phone;

import leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
// BFS
public class SerializeandDeserializeBinaryTree {
    public static class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) {
                return "null";
            }
            Queue<TreeNode> queue = new LinkedList<>();
            StringBuilder res = new StringBuilder();
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode cur = queue.poll();
                if (cur == null) {
                    res.append("null,");
                } else {
                    res.append(cur.val + ",");
                    queue.add(cur.left);
                    queue.add(cur.right);
                }
            }
            return res.deleteCharAt(res.length() - 1).toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] splits = data.split("\\,");
            if (splits.length == 1)
                return null;
            TreeNode root = new TreeNode(Integer.parseInt(splits[0]));
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            int i = 1;
            while (i < splits.length) {
                TreeNode cur = queue.poll();
                if (!splits[i].equals("null")) {
                    cur.left = new TreeNode(Integer.parseInt(splits[i]));
                    queue.add(cur.left);
                }
                i++;
                if (!splits[i].equals("null")) {
                    cur.right = new TreeNode(Integer.parseInt(splits[i]));
                    queue.add(cur.right);
                }
                i++;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        String ser = codec.serialize(root);
        System.out.println(ser);
        TreeNode deserRoot = codec.deserialize(ser);
        ser = codec.serialize(deserRoot);
        System.out.println(ser);
    }
}
