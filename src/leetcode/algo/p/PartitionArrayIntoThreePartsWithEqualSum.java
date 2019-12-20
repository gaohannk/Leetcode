package leetcode.algo.p;

import java.util.Arrays;

public class PartitionArrayIntoThreePartsWithEqualSum {
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = Arrays.stream(A).sum();
        if (sum % 3 != 0)
            return false;
        int cur = 0, count = 0;
        for (int i = 0; i < A.length; i++) {
            cur += A[i];
            if (cur == sum / 3) {
                count++;
                cur = 0;
            }
        }
        return count >= 3;
    }
}
