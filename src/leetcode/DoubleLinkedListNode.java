package leetcode;

/**
 * Created by gaohan on 5/27/18.
 */
public class DoubleLinkedListNode {
    public int val;
    public int key;
    public DoubleLinkedListNode pre;
    public DoubleLinkedListNode next;

    public DoubleLinkedListNode(int key, int value) {
        val = value;
        this.key = key;
        this.next = null;
        this.pre = null;
    }
}
