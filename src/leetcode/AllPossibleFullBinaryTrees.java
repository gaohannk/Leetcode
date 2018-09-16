package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * 894. All Possible Full Binary Trees
 */
public class AllPossibleFullBinaryTrees {

    public List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> ans = new LinkedList();
        if (N == 1) {
            ans.add(new TreeNode(0));
        } else if (N % 2 == 1) {
            for (int x = 0; x < N; ++x) {
                int y = N - 1 - x;
                for (TreeNode left : allPossibleFBT(x))
                    for (TreeNode right : allPossibleFBT(y)) {
                        TreeNode bns = new TreeNode(0);
                        bns.left = left;
                        bns.right = right;
                        ans.add(bns);
                    }
            }
        }

        return ans;
    }
}
