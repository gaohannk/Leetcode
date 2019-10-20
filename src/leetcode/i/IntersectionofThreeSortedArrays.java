package leetcode.i;

import java.util.ArrayList;
import java.util.List;

public class IntersectionofThreeSortedArrays {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> list = new ArrayList();
        int p1 = 0, p2 = 0, p3 = 0;
        while (p1 < arr1.length && p2 < arr2.length && p3 < arr3.length) {
            int min = Math.min(arr1[p1], Math.min(arr2[p2], arr3[p3]));
            if (arr1[p1] == arr2[p2] && arr1[p1] == arr3[p3])
                list.add(arr1[p1]);
            if (arr1[p1] == min)
                p1++;
            if (arr2[p2] == min)
                p2++;
            if (arr3[p3] == min)
                p3++;
        }
        return list;
    }
}
