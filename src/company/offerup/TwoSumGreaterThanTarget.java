package company.offerup;

import java.util.*;

public class TwoSumGreaterThanTarget {
    public static List<List<Integer>> twoSum(int[] array, int target) {
        Arrays.sort(array);
        List<List<Integer>> res = new LinkedList<>();
        int j = array.length - 1;
        for (int i = 0; i < array.length; i++) {
            for (int k = j + 1; k < array.length; k++) {
                if (i > k - 1) {
                    continue;
                }
                List<Integer> pair = new LinkedList<>();
                pair.add(array[i]);
                pair.add(array[k]);
                res.add(pair);
            }
            while (i < j) {
                if (array[i] + array[j] > target) {
                    List<Integer> pair = new LinkedList<>();
                    pair.add(array[i]);
                    pair.add(array[j]);
                    res.add(pair);
                    j--;
                } else {
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 5, 7, 8, 10, 13, 14, 16};
        int target = 14;
        List<List<Integer>> res = twoSum(array, target);
        for (List<Integer> item : res) {
            System.out.println(item.get(0) + "," + item.get(1));
        }
    }
}
