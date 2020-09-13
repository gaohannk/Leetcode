package leetcode.algo;

import java.util.Arrays;

public class PutBoxesIntotheWarehouseI {
    public int maxBoxesInWarehouse(int[] boxes, int[] warehouse) {
        Arrays.sort(boxes);
        int minLeft = Integer.MAX_VALUE;
        int[] left = new int[warehouse.length];
        for (int i = 0; i < warehouse.length; i++) {
            if (warehouse[i] < minLeft) {
                left[i] = warehouse[i];
                minLeft = warehouse[i];
            } else {
                left[i] = minLeft;
            }
        }
        int count = 0;
        int p = warehouse.length - 1, i = 0;
        // until warehouse is full or use all box
        while (p >= 0 && i < boxes.length) {
            if (left[p] >= boxes[i]) {
                // put box
                count++;
                i++;
            }
            p--;
        }
        return count;
    }
}
