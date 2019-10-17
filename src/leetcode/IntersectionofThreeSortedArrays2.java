package leetcode;

import java.util.ArrayList;
import java.util.List;

public class IntersectionofThreeSortedArrays2 {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        //array to hold count of each element, value of element is an index
        int[] c = new int[2001];
        for (int n : arr1) c[n]++;
        for (int n : arr2) c[n]++;
        for (int n : arr3) c[n]++;

        //fill result list, if count = 3 - this element is in every array
        List<Integer> res = new ArrayList();
        for (int i = 1; i <= 2000; i++) {
            if (c[i] == 3)
                res.add(i);
        }
        return res;
    }
}
