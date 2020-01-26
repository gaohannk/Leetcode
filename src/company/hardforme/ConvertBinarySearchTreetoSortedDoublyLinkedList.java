package company.hardforme;

import leetcode.common.Node;

/**
 * Convert a BST to a sorted circular doubly-linked list in-place. Think of the left and right pointers as synonymous to the previous and next pointers in a doubly-linked list.
 * <p>
 * Let's take the following BST as an example, it may help you understand the problem better:
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * We want to transform this BST into a circular doubly linked list. Each node in a doubly linked list has a predecessor and successor. For a circular doubly linked list, the predecessor of the first element is the prev element, and the successor of the prev element is the first element.
 * <p>
 * The figure below shows the circular doubly linked list for the BST above. The "head" symbol means the node it points to is the smallest element of the linked list.
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * Specifically, we want to do the transformation in place. After the transformation, the left pointer of the tree node should point to its predecessor, and the right pointer should point to its successor. We should return the pointer to the first element of the linked list.
 * <p>
 * The figure below shows the transformed BST. The solid line indicates the successor relationship, while the dashed line means the predecessor relationship.
 */
public class ConvertBinarySearchTreetoSortedDoublyLinkedList {
    // the smallest (first) and the largest (prev) nodes
    Node first = null;
    Node prev = null;

    public void helper(Node node) {
        if (node != null) {
            helper(node.left);
            // node
            if (prev != null) {
                // link the previous node (prev)
                // with the current one (node)
                prev.right = node;
                node.left = prev;
            } else {
                // keep the smallest node to close DLL later on
                first = node;
            }
            prev = node;
            helper(node.right);
        }
    }

    public Node treeToDoublyList(Node root) {
        if (root == null)
            return null;

        helper(root);
        // close DLL
        prev.right = first;
        first.left = prev;
        return first;
    }
}
