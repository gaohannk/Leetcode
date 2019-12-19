package leetcode.algo.f;

import java.util.LinkedList;
import java.util.List;

public class FindPositiveIntegerSolutionforaGivenEquation {

    class CustomFunction {
        // Returns f(x, y) for any given positive integers x and y.
        // Note that f(x, y) is increasing with respect to both x and y.
        // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
        public int f(int x, int y) {
            return 0;
        }
    }

    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        int low = 1;
        int high = z;

        List<List<Integer>> result = new LinkedList<>();
        while (low <= z && high > 0) {
            int curr = customfunction.f(low, high);
            if (curr == z) {
                List<Integer> pair = new LinkedList<>();
                pair.add(low);
                pair.add(high);
                result.add(pair);
                low++;
                high--;
            } else if (curr < z) {
                low++;
            } else if (curr > z) {
                high--;
            }
        }
        return result;
    }
}
