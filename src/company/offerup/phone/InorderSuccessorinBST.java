package company.offerup.phone;

import leetcode.common.TreeNode;

import java.util.Stack;

// stack
public class InorderSuccessorinBST {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null) {
            return null;
        }
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        boolean found = false;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (found)
                return cur;
            if (cur.val == p.val)
                found = true;
            cur = cur.right;
        }
        return null;
    }
}
