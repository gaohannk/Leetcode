package leetcode.algo.n;


import leetcode.common.NestedInteger;

import java.util.List;

/**
 * Given a nested list of integers, return the sum of all integers in the list weighted by their depth.
 * <p>
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 * <p>
 * Different from the previous question where weight is increasing from root to leaf, now the weight is defined from bottom up. i.e., the leaf level integers have weight 1, and the root level integers have the largest weight.
 * <p>
 * Example 1:
 * <p>
 * Input: [[1,1],2,[1,1]]
 * Output: 8
 * Explanation: Four 1's at depth 1, one 2 at depth 2.
 * Example 2:
 * <p>
 * Input: [1,[4,[6]]]
 * Output: 17
 * Explanation: One 1 at depth 3, one 4 at depth 2, and one 6 at depth 1; 1*3 + 4*2 + 6*1 = 17.
 */
public class NestedListWeightSumII {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        int maxDepth = calculateMaxDepth(nestedList, 1);
        // System.out.print(maxDepth+"\n")
        return dfs(nestedList, maxDepth);
    }

    public int dfs(List<NestedInteger> nestedList, int depth) {
        int ans = 0;
        for (NestedInteger n : nestedList) {
            if (n.isInteger()) {
                ans += n.getInteger() * depth;
            } else {
                ans += dfs(n.getList(), depth - 1);
            }
        }
        return ans;
    }

    public int calculateMaxDepth(List<NestedInteger> nestList, int depth) {
        int ans = depth;
        for (NestedInteger n : nestList) {
            if (!n.isInteger()) {
                ans = Math.max(ans, calculateMaxDepth(n.getList(), depth + 1));
            }
        }
        return ans;
    }
}
