package company.weride.phone;


public class DiameterofTree2 {
    static int max;

    static class TreeNode {
        TreeNode child[];
        int val;
    }
    public static int findDiameter(TreeNode root) {
        max = 1;
        helper(root);
        return max - 1;
    }

    public static int helper(TreeNode node) {
        if (node == null)
            return 0;
        int left = 0;
        int right = 0;
        if (node.child == null) {
            return 1;
        }
        for (int i = 0; i < node.child.length; i++) {
            for (int j = 0; j < node.child.length; j++) {
                if (j != i) {
                    left = helper(node.child[i]);
                    right = helper(node.child[j]);
                    max = Math.max(max, left + right);
                }
            }
        }
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root.child = new TreeNode[4];
        for (int i = 0; i < root.child.length; i++) {
            root.child[i] = new TreeNode();
        }
        root.child[0].child = new TreeNode[2];
        root.child[3].child = new TreeNode[2];
        root.child[0].child[0] = new TreeNode();
        root.child[0].child[0].child = new TreeNode[2];
        root.child[0].child[0].child[0] = new TreeNode();
        root.child[0].child[0].child[1] = new TreeNode();
        System.out.println(findDiameter(root));
    }
}
