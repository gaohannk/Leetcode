package leetcode.algo;

public class DetectPatternofLengthMRepeatedKorMoreTimes2 {
    public boolean containsPattern(int[] arr, int m, int k) {
        int count = 0;
        for (int i = 0; i < arr.length - m; i++) {
            if (arr[i] == arr[i + m]) {
                count++;
            } else {
                count = 0;
            }
            if (count == m * (k - 1)) // when we find 'k', 'm' length similar subarrays
            {
                return true;
            }

        }
        return false;
    }
}
