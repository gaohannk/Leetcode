package company.amazon.oa;

public class ConstructBST {
    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int value) {
            this.val = value;
        }
    }

    public static int bstDistance(int[] values, int n, int node1, int node2) {
        // Construct BST
        TreeNode root = null;
        for (int i = 0; i < n; i++) {
            root = insert(root, values[i]);
        }

        return findDistance(root, node1, node2);
    }

    private static int findDistance(TreeNode root, int node1, int node2) {
        if (node1 < root.val && node2 < root.val) {
            return findDistance(root.left, node1, node2);
        } else if (node1 > root.val && node2 > root.val) {
            return findDistance(root.right, node1, node2);
        } else {
            return getDistance(root, node1) + getDistance(root, node2);
        }
    }

    private static int getDistance(TreeNode root, int node) {
        int dis = 0;
        while (root.val != node) {
            if (root.val < node) {
                root = root.right;
            } else if (root.val > node) {
                root = root.left;
            }
            dis++;
        }
        return dis;
    }

    // Standard BST insert function
    public static TreeNode insert(TreeNode root, int key) {
        if(root == null){
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
        int[] values = {5, 6, 3, 1, 2, 4};
        System.out.println(bstDistance(values, values.length, 2, 4));
    }
}
