package leetcode.algo.i;

import leetcode.common.TreeNode;

import java.util.Stack;

/* Given a binary search tree and a node in it, find the in-order successor of that node in the BST.
 * Note: If the given node has no in-order successor in the tree, return null.
 */
/* Time Complexity - O(n)， Space Complexity - O(n)
 *
 */
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
