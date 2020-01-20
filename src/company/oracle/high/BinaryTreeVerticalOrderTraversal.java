package company.oracle.high;

import leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeVerticalOrderTraversal {
    static int leftMostIndex = 0;
    static int rightMostIndex = 0;

    public static List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        Queue<Integer> columnIndex = new LinkedList<>();
        columnIndex.add(0);
        findLeftMostIndex(root, 0);
        for (int i = 0; i < rightMostIndex - leftMostIndex + 1; i++) {
            res.add(new LinkedList<>());
        }
        while (!queue.isEmpty()) {
            Queue<TreeNode> nextLayer = new LinkedList<>();
            Queue<Integer> nextColumnIndex = new LinkedList<>();

            while (!queue.isEmpty()) {
                TreeNode cur = queue.poll();
                int curIndex = columnIndex.poll();

                res.get(curIndex - leftMostIndex).add(cur.val);
                if (cur.left != null) {
                    nextLayer.add(cur.left);
                    nextColumnIndex.add(curIndex - 1);
                }
                if (cur.right != null) {
                    nextLayer.add(cur.right);
                    nextColumnIndex.add(curIndex + 1);
                }
            }
            queue = nextLayer;
            columnIndex = nextColumnIndex;
        }
        return res;
    }

    private static void findLeftMostIndex(TreeNode root, int col) {
        if (root == null) {
            return;
        }
        if (leftMostIndex > col) {
            leftMostIndex = col;
        }
        if (rightMostIndex < col) {
            rightMostIndex = col;
        }
        findLeftMostIndex(root.left, col - 1);
        findLeftMostIndex(root.right, col + 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        System.out.println(verticalOrder(root));
    }
}
