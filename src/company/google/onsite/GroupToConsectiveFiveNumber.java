package company.google.onsite;

import java.util.TreeMap;

public class GroupToConsectiveFiveNumber {
    public static boolean solution(int[] array) {
        if (array.length % 5 != 0) {
            return false;
        }
        TreeMap<Integer, Integer> freq = new TreeMap<>();
        for (int item : array) {
            freq.put(item, freq.getOrDefault(item, 0) + 1);
        }
        while (!freq.keySet().isEmpty()) {
            int k = 5;
            int start = freq.firstKey();
            while (k > 0) {
                if (freq.get(start) == null || freq.get(start) == 0) {
                    return false;
                }
                freq.put(start, freq.get(start) - 1);
                if (freq.get(start) == 0) {
                    freq.remove(start);
                }
                start++;
                k--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 2, 3, 3, 4, 4, 5, 5, 6};
        System.out.println(solution(array));
    }
}
