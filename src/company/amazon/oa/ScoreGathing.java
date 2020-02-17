package company.amazon.oa;

import java.util.*;

/**
 *
 */
public class ScoreGathing {
    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int value) {
            this.val = value;
        }
    }

    public static List<String> solution(int[] array) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            map.put(array[i], map.getOrDefault(array[i], 0) + 1);
        }

        // Construct BST
        TreeNode root = null;
        for (int i = 0; i < array.length; i++) {
            root = insert(root, array[i]);
        }

        //BFS traversal
        List<String> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {

        }
        return res;
    }

    // Standard BST insert function
    public static TreeNode insert(TreeNode root, int key) {
        if (root == null) {
            root = new TreeNode(key);
            return root;
        }
        if (root.val > key) {
            root.left = insert(root.left, key);
        } else if (root.val < key) {
            root.right = insert(root.right, key);
        }
        return root;
    }

    public static void main(String[] args) {
        int[] values = {4, 2, 5, 5, 6, 1, 4};
        System.out.println(solution(values));
    }
}
