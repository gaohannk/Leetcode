package leetcode.algo.p;

import java.util.Arrays;

public class PartitionArrayIntoThreePartsWithEqualSum2 {
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = Arrays.stream(A).sum();
        if (sum % 3 != 0)
            return false;
        int target = sum / 3;
        int currentSum = 0, count = 0;
        for (int a : A) {
            currentSum += a;
            if (currentSum == target) {
                if (count != 2) {
                    currentSum = 0;
                    count++;
                }else
                    return true;
            }
        }
        return false;
    }
}
