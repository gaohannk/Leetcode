package leetcode.algo;

public class DetectPatternofLengthMRepeatedKorMoreTimes {
    public boolean containsPattern(int[] arr, int m, int k) {
        outerloop:
        for (int i = 0; i <= arr.length - (m * k); i++) {
            int counter = 1;
            innerloop:
            for (int j = i + m; j <= arr.length - m; j = j + m) {
                int offset = 0;
                while (offset < m) {
                    if (arr[i + offset] != arr[j + offset]) {
                        break innerloop;
                    }
                    offset++;
                }
                counter++;
                if (counter == k) {
                    return true;
                }
            }
        }
        return false;
    }
}
