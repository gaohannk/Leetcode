package leetcode.algo.f;

public class FindtheSmallestDivisorGivenaThreshold {
    public int smallestDivisor(int[] nums, int threshold) {
        int max = 1000000;
        int min = 1;
        while (min < max) {
            int mid = min + (max - min) / 2;
            if (sumOfDivision(nums, mid) <= threshold) { // denominator is more, i.e mid is greater than solution hence reduce it so reduce max.
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        return min;
    }

    private int sumOfDivision(int[] nums, int mid) {
        int sum = 0;
        for (int n : nums) {
            sum += (int) Math.ceil((double) n / mid);
        }
        return sum;
    }
}
