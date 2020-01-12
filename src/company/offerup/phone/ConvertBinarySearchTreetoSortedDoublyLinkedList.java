package company.offerup.phone;

import leetcode.common.Node;

public class ConvertBinarySearchTreetoSortedDoublyLinkedList {
//    public Node treeToDoublyList(Node root) {
//        Node cur = root;
//        Node parent = null;
//        helper(parent, root);
//
//
//    }
//
//    private void helper(Node parent, Node cur) {
//        parent = cur;
//        if(cur.left == null && cur.right == null){
//            cur.right = parent;
//        }else if(cur.left !=null && cur.right ==null){
//            helper(cur.left, cur);
//        } else  if(cur.right !=null && cur.left ==null){
//            Node temp = cur.right;
//            while( temp.left !=null){
//                temp = temp.left;
//            }
//            Node right = cur.right;
//            cur.right = temp;
//            helper(right, cur);
//        } else {
//            helper(cur.left, cur);
//            helper(cur.right, cur);
//        }
//    }
}
