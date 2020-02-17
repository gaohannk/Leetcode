package leetcode.algo.f;

public class FindNUniqueIntegersSumuptoZero {
    public int[] sumZero(int n) {
        int[] res = new int[n];

        if (n % 2 == 0) {
            for (int i = 0; i < n; i = i + 2) {
                res[i] = (i + 2) / 2;
                res[i + 1] = -1 * (i + 2) / 2;
            }
        } else {

            for (int i = 0; i < n - 1; i = i + 2) {
                res[i] = (i + 2) / 2;
                res[i + 1] = -1 * (i + 2) / 2;
            }
        }

        return res;
    }
}
