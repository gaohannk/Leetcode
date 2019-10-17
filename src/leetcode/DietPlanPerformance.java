package leetcode;

import java.util.List;

public class DietPlanPerformance {
    int dietPlanPerformance(List<Integer> calories, int k, int lower, int upper) {
        int total = 0, sum = 0, n = calories.size();
        for (int i = 0; i < n; i++) {
            if (i != 0 && i % k == 0) {
                if (sum < lower)
                    total--;
                else if (sum > upper)
                    total++;
                sum = calories.get(i);
            } else {
                sum += calories.get(i);
            }
        }

        if (sum < lower)
            total--;
        else if (sum > upper)
            total++;
        return total;
    }
}
