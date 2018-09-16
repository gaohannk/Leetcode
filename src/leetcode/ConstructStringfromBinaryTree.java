package leetcode;

/**
 * You need to construct a string consists of parenthesis and integers from a binary tree with the preorder traversing way.
 * <p>
 * The null node needs to be represented by empty parenthesis pair "()". And you need to omit all the empty parenthesis pairs that don't affect the one-to-one mapping relationship between the string and the original binary tree.
 * <p>
 * Example 1:
 * Input: Binary tree: [1,2,3,4]
 * 1
 * /   \
 * 2     3
 * /
 * 4
 * <p>
 * Output: "1(2(4))(3)"
 * <p>
 * Explanation: Originallay it needs to be "1(2(4)())(3()())",
 * but you need to omit all the unnecessary empty parenthesis pairs.
 * And it will be "1(2(4))(3)".
 * Example 2:
 * Input: Binary tree: [1,2,3,null,4]
 * 1
 * /   \
 * 2     3
 * \
 * 4
 * <p>
 * Output: "1(2()(4))(3)"
 * <p>
 * Explanation: Almost the same as the first example,
 * except we can't omit the first parenthesis pair to break the one-to-one mapping relationship between the input and the output.
 */
public class ConstructStringfromBinaryTree {
    public String tree2str(TreeNode t) {
        StringBuilder sb = new StringBuilder();
        if (t == null)
            return sb.toString();
        sb.append(t.val);
        if (t.left != null && t.right != null) {
            sb.append("(" + tree2str(t.left) + ")");
            sb.append("(" + tree2str(t.right) + ")");
            return sb.toString();
        } else if (t.left == null && t.right != null) {
            sb.append("()" + "(" + tree2str(t.right) + ")");
        } else if (t.left != null && t.right == null) {
            sb.append("(" + tree2str(t.left) + ")");
        } else {
            return sb.toString();
        }
        return sb.toString();
    }
}
