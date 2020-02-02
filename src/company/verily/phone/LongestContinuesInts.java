package company.verily.phone;

import java.util.LinkedList;
import java.util.List;

public class LongestContinuesInts {
    public static List<Integer> findLongestContinuesInts(int[] array) {
        List<Integer> res = new LinkedList<>();
        if (array == null || array.length == 0) {
            return res;
        }
        if (array.length == 1) {
            res.add(array[0]);
            return res;
        }
        int count = 1;
        int max = 0;
        List<Integer> cur  = new LinkedList<>();
        cur.add(array[0]);

        for (int i = 1; i < array.length; i++) {
            if (array[i] == array[i - 1] + 1) {
                count++;
                cur.add(array[i]);
            } else {
                if (max < count) {
                    max = count;
                    res.clear();
                    res = cur;
                }
                cur  = new LinkedList<>();
                cur.add(array[i]);
                count = 1;
            }
        }
        if (max < count) {
            res = cur;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,8,9,10};
        System.out.println(findLongestContinuesInts(array));
    }
}
