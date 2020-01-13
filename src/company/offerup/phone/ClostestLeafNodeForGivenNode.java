package company.offerup.phone;

import leetcode.common.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class ClostestLeafNodeForGivenNode {
    static Map<TreeNode, TreeNode> parentMap = new HashMap<>();

    public static TreeNode findCloset(TreeNode root, TreeNode node) {
        inOrderTraversal(root, null);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        int level = 0;
        while (!queue.isEmpty()) {
            Queue<TreeNode> nextLayer = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeNode cur = queue.poll();
                if (cur.left == null && cur.right == null) {
                    // leaf node
                    return cur;
                }
                if (cur.left != null) {
                    nextLayer.add(cur.left);
                }
                if (cur.right != null) {
                    nextLayer.add(cur.right);
                }
                if (parentMap.get(cur) != null) {
                    nextLayer.add(parentMap.get(cur));
                }
            }
            queue = nextLayer;
            level++;
        }
        return null;
    }

    private static void inOrderTraversal(TreeNode root, TreeNode parent) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left, root);
        parentMap.put(root, parent);
        inOrderTraversal(root.right, root);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.right.right = new TreeNode(7);
        root.right.right.right.right = new TreeNode(8);
        root.right.right.right.right.right = new TreeNode(9);
        System.out.println(findCloset(root, root.right).val);

    }
}
