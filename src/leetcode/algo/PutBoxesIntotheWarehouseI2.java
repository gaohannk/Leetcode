package leetcode.algo;

import java.util.Arrays;
import java.util.PriorityQueue;

public class PutBoxesIntotheWarehouseI2 {

    public int maxBoxesInWarehouse(int[] boxes, int[] warehouse) {
        int[] preMin = new int[warehouse.length];
        preMin[0] = warehouse[0];
        for (int i = 1; i < warehouse.length; i++) {
            preMin[i] = Math.min(preMin[i - 1], warehouse[i]);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int box : boxes) {
            pq.offer(box);
        }
        int count = 0;
        for (int i = warehouse.length - 1; i >= 0; i--) {
            if (pq.isEmpty()) {
                continue;
            }
            if (preMin[i] >= pq.peek()) {
                pq.poll();
                count++;
            }
        }

        return count;
    }
}
