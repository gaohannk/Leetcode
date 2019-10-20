package leetcode.t;

import java.util.HashSet;
import java.util.Set;

public class TwoSumBSTs {
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        Set<Integer> set = new HashSet<Integer>();
        helper(set, root1);
        return check(root2, set, target);
    }

    public void helper(Set<Integer> set, TreeNode root) {
        if (root == null)
            return;
        set.add(root.val);
        helper(set, root.left);
        helper(set, root.right);
    }

    public boolean check(TreeNode root, Set<Integer> set, int target) {
        if (root == null)
            return false;
        if (set.contains(target - root.val))
            return true;
        return check(root.left, set, target) || check(root.right, set, target);
    }
}
