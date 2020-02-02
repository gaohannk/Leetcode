package company.oracle.high;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    class DoubleLinkedNode {
        int val;
        int key;
        DoubleLinkedNode prev;
        DoubleLinkedNode next;

        public DoubleLinkedNode(int value) {
            this.val = value;
        }
    }

    Map<Integer, DoubleLinkedNode> nodeMap;
    DoubleLinkedNode head;
    DoubleLinkedNode tail;
    int maxVolumn;
    final int capacity = 10;

    public LRUCache(int capacity) {
        this.nodeMap = new HashMap<>();
        head = new DoubleLinkedNode(-1);
        tail = new DoubleLinkedNode(-1);
        head.next = tail;
        tail.prev = head;
    }

    // add node to the head
    public void addNode(DoubleLinkedNode node) {
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    public void removeNode(DoubleLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void moveToHead(DoubleLinkedNode node) {
        removeNode(node);
        addNode(node);
    }

    private DoubleLinkedNode removeTail() {
        DoubleLinkedNode node = tail.prev;
        removeNode(tail.prev);
        return node;
    }

    public int get(int key) {
        if (nodeMap.get(key) != null) {
            moveToHead(nodeMap.get(key));
            return nodeMap.get(key).val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (nodeMap.get(key) != null) {
            // update value
            nodeMap.get(key).val = value;
            moveToHead(nodeMap.get(key));

        } else {
            DoubleLinkedNode node = new DoubleLinkedNode(value);
            node.key = key;
            nodeMap.put(key, node);
            addNode(node);
            this.maxVolumn++;
        }

        if (maxVolumn > capacity) {
            DoubleLinkedNode tail = removeTail();
            nodeMap.remove(tail.key);
            maxVolumn--;
        }
    }
}
