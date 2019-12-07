package leetcode.algo.l;

import leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by gaohan on 8/4/18.
 */
public class LeafSimilarTrees2 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root1);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.right != null)
                stack.push(node.right);
            if (node.left != null)
                stack.push(node.left);
            if (node.left == null && node.right == null) {
                leaves1.add(node.val);
            }
        }

        return check(leaves1, root2);
    }

    private boolean check(List<Integer> leaves1, TreeNode root2) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root2);
        int cur = 0;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.right != null)
                stack.push(node.right);
            if (node.left != null)
                stack.push(node.left);
            if (node.left == null && node.right == null) {
                if (node.val != leaves1.get(cur))
                    return false;
                else
                    cur++;

            }
        }
        return true;
    }
}
