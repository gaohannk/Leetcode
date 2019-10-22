package leetcode.algo.s;

import leetcode.common.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class SecondMinimumNodeInaBinaryTree {

    public int findSecondMinimumValue(TreeNode root) {
        Set<Integer> uniques = new HashSet<>();
        dfs(root, uniques);

        int min1 = root.val;
        int ans = Integer.MAX_VALUE;
        for (int v : uniques) {
            if (min1 < v && v < ans)
                ans = v;
        }
        return ans < Integer.MAX_VALUE ? ans : -1;
    }
    public void dfs(TreeNode root, Set<Integer> uniques) {
        if (root != null) {
            uniques.add(root.val);
            dfs(root.left, uniques);
            dfs(root.right, uniques);
        }
    }
}
