package leetcode.m;

import java.util.ArrayList;
import java.util.List;

public class MinimumDistanceBetweenBSTNodes {
    public int minDiffInBST(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        inorder(res, root);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < res.size(); i++) {
            min = Math.min(min, res.get(i) - res.get(i - 1));
        }
        return min;
    }

    private void inorder(List<Integer> res, TreeNode root) {
        if (root == null)
            return;
        inorder(res, root.left);
        res.add(root.val);
        inorder(res, root.right);
    }
}
