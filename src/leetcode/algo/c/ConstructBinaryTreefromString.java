package leetcode.algo.c;

import leetcode.common.TreeNode;

import java.util.Stack;

/**
 * You need to construct a binary tree from a string consisting of parenthesis and integers.
 * <p>
 * The whole input represents a binary tree. It contains an integer followed by zero, one or two pairs of parenthesis. The integer represents the root's value and a pair of parenthesis contains a child binary tree with the same structure.
 * <p>
 * You always start to construct the left child node of the parent first if it exists.
 * <p>
 * Example:
 * Input: "4(2(3)(1))(6(5))"
 * Output: return the tree root node representing the following tree:
 * <p>
 * 4
 * /   \
 * 2     6
 * / \   /
 * 3   1 5
 * Note:
 * There will only be '(', ')', '-' and '0' ~ '9' in the input string.
 * An empty tree is represented by "" instead of "()".
 */
public class ConstructBinaryTreefromString {
    public TreeNode str2tree(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = null;
        for (int i = 0; i < s.length(); ) {

            char c = s.charAt(i);
            if (c == '-' || Character.isDigit(c)) {
                String val = "" + c;
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    val += s.charAt(i + 1);
                    i++;
                }
                TreeNode node = new TreeNode(Integer.parseInt(val));
                if (root != null) {
                    if (root.left == null) {
                        root.left = node;
                    } else {
                        root.right = node;
                    }
                }
                stack.push(node);
            } else if (c == '(') {
                // A number (node/child) must be followed this '(',  so we need
                // its parent.
                root = stack.peek();
            } else {
                // The node on the top of the stack is done.
                stack.pop();
            }
            i++;
        }
        return stack.pop();
    }
}
