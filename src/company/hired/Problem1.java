package company.hired;

import java.util.HashMap;
import java.util.Map;

public class Problem1 {
    public static long[] solution(long[] numbers) {
        // Type your solution here
        Map<Long, Integer> map = new HashMap<>();
        for (long n : numbers) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        int min = Integer.MAX_VALUE;
        int count = 0;
        for (Long l : map.keySet()) {
            if (min > map.get(l)) {
                min = map.get(l);
                count = 1;
            } else if (min == map.get(l)) {
                count++;
            }
        }
        long[] res = new long[count];
        int id = 0;
        for (Long l : map.keySet()) {
            if (map.get(l) == min) {
                res[id++] = l;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        long[] numbers = new long[]{10, 941, 13, 13, 13, 941, 10};
        long[] res = solution(numbers);
        for (long i : res) {
            System.out.print(i + " ");
        }
    }
}
