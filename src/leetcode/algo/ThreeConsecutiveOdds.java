package leetcode.algo;

public class ThreeConsecutiveOdds {
    public boolean threeConsecutiveOdds(int[] arr) {
        boolean res = false;
        int arrLen = arr.length;
        for (int i = 0; i < arrLen - 2; i++) {
            if (arr[i] % 2 == 1 && arr[i + 1] % 2 == 1 && arr[i + 2] % 2 == 1) {
                return true;
            }
        }
        return res;
    }

    public boolean threeConsecutiveOdds2(int[] arr) {
        for (int i = 0, cnt = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                cnt = 0;
            } else {
                cnt++;
                if (cnt == 3) {
                    return true;
                }
            }
        }
        return false;
    }
}
