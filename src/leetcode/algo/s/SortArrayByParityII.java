package leetcode.algo.s;

public class SortArrayByParityII {
    public int[] sortArrayByParityII(int[] A) {
        int[] ans = new int[A.length];

        int t = 0;
        for (int x : A) {
            if (x % 2 == 0) {
                ans[t] = x;
                t += 2;
            }
        }

        t = 1;
        for (int x : A) {
            if (x % 2 == 1) {
                ans[t] = x;
                t += 2;
            }
        }

        return ans;
    }
}
