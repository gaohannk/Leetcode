package leetcode.p;

/* Follow up for problem "Populating Next Right Pointers in Each Node".
 * What if the given tree could be any binary tree? Would your previous solution still work?
 * Note:
 * You may only use constant extra space.
 * For example,
 * Given the following binary tree,
 *        1
 *      /  \
 *     2    3
 *    / \    \
 *   4   5    7
 * After calling your function, the tree should look like:
 *        1 -> NULL
 *      /  \
 *     2 -> 3 -> NULL
 *    / \    \
 *   4-> 5 -> 7 -> NULL
 */
// Non-recursion

import leetcode.n.Node;

public class PopulatingNextRightPointersinEachNodeII2 {
    public Node connect(Node root) {
        Node pre = root;
        while (pre != null) {
            Node cur = pre;
            while (cur != null) {
                if (cur.left != null && cur.right == null) {
                    cur.left.next = findMostLeft(cur.next);
                } else if (cur.left == null && cur.right != null) {
                    cur.right.next = findMostLeft(cur.next);
                } else if (cur.left != null && cur.right != null) {
                    cur.left.next = cur.right;
                    cur.right.next = findMostLeft(cur.next);
                }

                cur = cur.next;
            }

            pre = findMostLeft(pre);
        }

        return root;
    }

    private Node findMostLeft(Node node) {
        if (node == null) return null;

        while (node != null) {
            if (node.left != null) return node.left;
            if (node.right != null) return node.right;
            node = node.next;
        }

        return null;
    }

}
