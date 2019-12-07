package leetcode.algo.d;

public class DietPlanPerformance {
    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        int total = 0;
        int points = 0;
        for (int i = 0; i < calories.length; i++) {
            total += calories[i];
            if (i >= k - 1) {
                if (i >= k)
                    total -= calories[i - k];
                if (total > upper)
                    points++;
                if (total < lower)
                    points--;
            }
        }
        return points;
    }
}
