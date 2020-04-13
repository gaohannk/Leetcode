package company.microsoft.oa;

import java.util.HashMap;
import java.util.Map;

public class NumbersWithEqualDigitSum {

    public int solution(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxSum = -1;
        for (int n : A) {
            int sum = sumDigits(n);
            if (!map.containsKey(sum)) {
                map.put(sum, n);
            } else {
                maxSum = Math.max(maxSum, n + map.get(sum));
                map.put(sum, Math.max(n, map.get(sum)));
            }
        }
        return maxSum;
    }

    private int sumDigits(int num) {
        int sum = 0;

        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
