package company.amazon.high;

import leetcode.algo.r.RandomListNode;

public class CopyListwithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null)
            return null;

        // step 1: copy the next pointers
        RandomListNode p = head;
        while (p != null) {
            RandomListNode q = p.next;
            RandomListNode copy = new RandomListNode(p.label);
            p.next = copy;
            copy.next = q;
            p = q;
        }

        p = head;
        // step 2: copy the random pointers
        while (p != null) {
            RandomListNode copy = p.next;// q is the new node
            copy.random = p.random == null ? null : p.random.next;
            p = p.next.next;
        }

        // step 3: separate the new list and the old list
        RandomListNode copy = head.next;
        p = head;
        while (p != null) {
            RandomListNode q = p.next;
            p.next = q.next;
            if (q.next != null) {
                q.next = q.next.next;
            }
            p = p.next;
        }
        return copy;
    }
}
