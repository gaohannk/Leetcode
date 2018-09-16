package leetcode;

/**
 * Design your implementation of the linked list. You can choose to use the singly linked list or the doubly linked list. A node in a singly linked list should have two attributes: val and next. val is the value of the current node, and next is a pointer/reference to the next node. If you want to use the doubly linked list, you will need one more attribute prev to indicate the previous node in the linked list. Assume all nodes in the linked list are 0-indexed.
 * <p>
 * Implement these functions in your linked list class:
 * <p>
 * get(index) : Get the value of the index-th node in the linked list. If the index is invalid, return -1.
 * addAtHead(val) : Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
 * addAtTail(val) : Append a node of value val to the last element of the linked list.
 * addAtIndex(index, val) : Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
 * deleteAtIndex(index) : Delete the index-th node in the linked list, if the index is valid.
 * Example:
 * <p>
 * MyLinkedList linkedList = new MyLinkedList();
 * linkedList.addAtHead(1);
 * linkedList.addAtTail(3);
 * linkedList.addAtIndex(1, 2);  // linked list becomes 1->2->3
 * linkedList.get(1);            // returns 2
 * linkedList.deleteAtIndex(1);  // now the linked list is 1->3
 * linkedList.get(1);            // returns 3
 */
public class DesignLinkedList {
    class MyLinkedList {
        //instance variables of MyLinkedList class
        private int length; //length of the linked list
        private Node head;  //head node of the linked list

        class Node {
            //instance variables of Node class
            int val;
            Node next;
            Node prev;

            //Constructor
            Node(int x) {
                this.val = x;
            }
        }

        //Constructor
        MyLinkedList() {
            this.length = 0;
            this.head = null;
        }

        /**
         * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
         */
        public int get(int index) {
            if (index >= this.length)
                return -1;
            Node cur = this.head;
            int i = 0;
            while (i != index) {
                i++;
                cur = cur.next;
            }
            return cur.val;
        }

        /**
         * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
         */
        public void addAtHead(int val) {
            Node newHead = new Node(val);
            newHead.next = this.head;
            newHead.prev = null;
            this.head = newHead;
            this.length++;
        }

        /**
         * Append a node of value val to the last element of the linked list.
         */
        public void addAtTail(int val) {
            if (this.length == 0) {
                addAtHead(val);
                return;
            }
            Node newTail = new Node(val);
            newTail.next = null;
            Node cur = this.head;
            while (cur.next != null) {
                cur = cur.next;
            }
            newTail.prev = cur;
            cur.next = newTail;
            this.length++;
        }

        /**
         * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
         */
        public void addAtIndex(int index, int val) {
            if (index < 0 || index > this.length)
                return;
            if (index == 0) {
                addAtHead(val);
                return;
            }
            if (index == this.length) {
                addAtTail(val);
                return;
            }
            Node node = new Node(val);
            Node cur = this.head;
            int counter = 0;
            while (counter < index - 1) {
                counter++;
                cur = cur.next;
            }
            Node pre = cur;
            Node next = cur.next;
            node.next = next;
            node.prev = pre;
            pre.next = node;
            if (next != null)
                next.prev = node;
            this.length++;
        }

        /**
         * Delete the index-th node in the linked list, if the index is valid.
         */
        public void deleteAtIndex(int index) {
            if (index < 0 || index >= this.length)
                return;
            Node cur = this.head;
            if (index == 0) {
                this.head = cur.next;
            } else {
                int counter = 0;
                while (counter < index - 1) {
                    counter++;
                    cur = cur.next;
                }
                Node pre = cur;
                Node next = cur.next.next;
                pre.next = next;
                if (next != null) next.prev = pre;
            }
            this.length--;
        }
    }
}
