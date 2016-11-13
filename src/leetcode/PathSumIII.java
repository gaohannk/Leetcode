package leetcode;

/**
 * You are given a binary tree in which each node contains an integer value.
 * <p>
 * Find the number of paths that sum to a given value.
 * <p>
 * The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).
 * <p>
 * The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
 * <p>
 * Example:
 * <p>
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 * <p>
 * 10
 * /  \
 * 5   -3
 * / \    \
 * 3   2   11
 * / \   \
 * 3  -2   1
 * <p>
 * Return 3. The paths that sum to 8 are:
 * <p>
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3. -3 -> 11
 */
public class PathSumIII {
    public int pathSum(TreeNode root, int sum) {
        if (root == null)
            return 0;
        int res = findPathWithRoot(root, sum);
        res += pathSum(root.left, sum) + pathSum(root.right, sum); //add case when root is excluded.
        return res;
    }

    private int findPathWithRoot(TreeNode root, int sum) { //Must contain root.val when calculating sum.
        int count = 0;
        if (root == null)
            return count;
        if (root.val == sum)
            count++;
        count += findPathWithRoot(root.left, sum - root.val);
        count += findPathWithRoot(root.right, sum - root.val);
        return count;
    }
}
