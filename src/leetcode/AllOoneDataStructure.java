package leetcode;

/**
 * Implement a data structure supporting the following operations:
 * <p>
 * Inc(Key) - Inserts a new key with value 1. Or increments an existing key by 1. Key is guaranteed to be a non-empty string.
 * Dec(Key) - Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. Key is guaranteed to be a non-empty string. If the key does not exist, this function does nothing.
 * GetMaxKey() - Returns one of the keys with maximal value. If no element exists, return an empty string "".
 * GetMinKey() - Returns one of the keys with minimal value. If no element exists, return an empty string "".
 * Challenge: Perform all these in O(1) time complexity.
 */

/**
 * The main idea is to maintain an ordered two-dimensional doubly-linked list (let's call it matrix for convenience), of which each row is corresponding to a value and all of the keys in the same row have the same value.

 Suppose we get the following key-value pairs after some increment operations. ("A": 4 means "A" is increased four times so its value is 4, and so on.)

 "A": 4, "B": 4, "C": 2, "D": 1
 Then one possible matrix may look like this:

 row0: val = 4, strs = {"A", "B"}
 row1: val = 2, strs = {"C"}
 row2: val = 1, strs = {"D"}
 If we can guarantee the rows are in descending order in terms of value, then GetMaxKey()/GetMinKey() will be easy to implement in O(1) time complexity. Because the first key in the first row will always has the maximal value, and the first key in the last row will always has the minimal value.

 Once a key is increased, we move the key from current row to last row if last_row.val = current_row.val + 1. Otherwise, we insert a new row before current row with vallue current_row.val + 1, and move the key to to the new row. The logic of decrement operation is similar. Obviously, by doing this, the rows will keep its descending order.

 For example, after Inc("D"), the matrix will become

 row0: val = 4, strs = {"A", "B"}
 row1: val = 2, strs = {"C", "D"}
 Inc("D") again

 row0: val = 4, strs = {"A", "B"}
 row1: val = 3, strs = {"D"}
 row2: val = 2, strs = {"C"}
 Now the key problem is how to maintain the matrix in O(1) runtime when increase/decrease a key by 1.

 The answer is hash map. By using a hash map to track the position of a key in the matrix, we can access a key in the matrix in O(1). And since we use linked list to store the matrix, thus insert/move operations will all be O(1).

 The psudocode of Inc() is as follows(Dec() is similar).

 if the key isn't in the matrix:
 if the matrix is empty or the value of the last row isn't 1:
 insert a new row with value 1 to the end of the matrix, and put the key in the new row;
 else:
 put the key in the last row of the matrix;
 else:
 if the key is at the first row or last_row.value != current_row.value + 1:
 insert a new row before current row, with value current_row.value + 1, and move the key to the new row;
 else:
 move the key from current row to last row;
 */
public class AllOoneDataStructure {
    public class AllOne {

        /**
         * Initialize your data structure here.
         */
        public AllOne() {

        }

        /**
         * Inserts a new key <Key> with value 1. Or increments an existing key by 1.
         */
        public void inc(String key) {

        }

        /**
         * Decrements an existing key by 1. If Key's value is 1, remove it from the data structure.
         */
        public void dec(String key) {

        }

        /**
         * Returns one of the keys with maximal value.
         */
        public String getMaxKey() {
            return "";
        }

        /**
         * Returns one of the keys with Minimal value.
         */
        public String getMinKey() {
            return "";
        }
    }

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
}

//
//    Map<String, Node> map = new HashMap<>();
//    DList list = new DList();
//
//    /** Initialize your data structure here. */
//    public AllOne() {
//
//    }
//
//    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
//    public void inc(String key) {
//        Node node = map.get(key);
//        if (node == null) {
//            node = list.add(key);
//        } else {
//            node = list.increment(node, key);
//        }
//        map.put(key, node);
//    }
//
//    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
//    public void dec(String key) {
//        Node node = map.get(key);
//        if (node != null) {
//            if (node.val == 1) {
//                map.remove(key);
//                list.delete(node, key);
//            } else {
//                node = list.decrement(node, key);
//                map.put(key, node);
//            }
//        }
//    }
//
//    /** Returns one of the keys with maximal value. */
//    public String getMaxKey() {
//        return list.head == null ? "" : list.head.getKey();
//    }
//
//    /** Returns one of the keys with Minimal value. */
//    public String getMinKey() {
//        return list.tail == null ? "" : list.tail.getKey();
//    }
//
//class DList {
//    Node head, tail;
//
//    public DList() {
//        head = tail = null;
//    }
//
//    public Node add(String key) {
//        if (tail == null) {
//            head = tail = new Node(1);
//            head.addKey(key);
//        } else {
//            if (tail.val == 1) {
//                tail.addKey(key);
//            } else {
//                Node node = new Node(1);
//                node.addKey(key);
//                tail.next = node;
//                node.prev = tail;
//                tail = node;
//            }
//        }
//        return tail;
//    }
//
//    public void delete(Node node, String key) {
//        node.removeKey(key);
//        if (node.empty()) {
//            Node prev = node.prev;
//            Node next = node.next;
//            if (prev != null) {
//                prev.next = next;
//            }
//            if (next != null) {
//                next.prev = prev;
//            }
//            if (node == head) {
//                head = next;
//            }
//            if (node == tail) {
//                tail = prev;
//            }
//            node.prev = node.next = null;
//        }
//    }
//
//    public Node increment(Node node, String key) {
//        Node prev = node.prev;
//        Node retNode = null;
//        int val = node.val + 1;
//        if (prev != null) {
//            if (prev.val == val) {
//                prev.addKey(key);
//                retNode = prev;
//            } else {
//                Node newNode = new Node(val);
//                newNode.addKey(key);
//                newNode.prev = prev;
//                newNode.next = node;
//                prev.next = newNode;
//                node.prev = newNode;
//                retNode = newNode;
//            }
//        } else {
//            Node newNode = new Node(val);
//            newNode.addKey(key);
//            newNode.next = node;
//            node.prev = newNode;
//            head = newNode;
//            retNode = newNode;
//        }
//        delete(node, key);
//        return retNode;
//    }
//
//    public Node decrement(Node node, String key) {
//        Node next = node.next;
//        Node retNode;
//        int val = node.val - 1;
//        if (next != null) {
//            if (next.val == val) {
//                next.addKey(key);
//                retNode = next;
//            } else {
//                Node newNode = new Node(val);
//                newNode.addKey(key);
//                newNode.prev = node;
//                newNode.next = next;
//                node.next = newNode;
//                next.prev = newNode;
//                retNode = newNode;
//            }
//        } else {
//            Node newNode = new Node(val);
//            newNode.addKey(key);
//            newNode.prev = node;
//            tail = newNode;
//            retNode = newNode;
//        }
//        delete(node, key);
//        return retNode;
//    }
//}
//
//class Node {
//    Node prev, next;
//    int val;
//    Set<String> keys;
//
//    public Node(int v) {
//        keys = new HashSet<String>();
//        val = v;
//        prev = next = null;
//    }
//
//    public void addKey(String key) {
//        keys.add(key);
//    }
//
//    public void removeKey(String key) {
//        keys.remove(key);
//    }
//
//    public boolean empty() {
//        return keys.isEmpty();
//    }
//
//    public String getKey() {
//        for (String key : keys) {
//            return key;
//        }
//        return "";
//    }
//}
//}
