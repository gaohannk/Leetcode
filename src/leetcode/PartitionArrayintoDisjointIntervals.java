package leetcode;

public class PartitionArrayintoDisjointIntervals {
    public int partitionDisjoint(int[] A) {
        int N = A.length;
        int[] maxleft = new int[N];
        int[] minright = new int[N];

        int curMax = A[0];
        for (int i = 0; i < N; i++) {
            curMax = Math.max(curMax, A[i]);
            maxleft[i] = curMax;
        }

        curMax = A[N - 1];
        for (int i = N - 1; i >= 0; i--) {
            curMax = Math.min(curMax, A[i]);
            minright[i] = curMax;
        }

        for (int i = 1; i < N; i++)
            if (maxleft[i - 1] <= minright[i])
                return i;

        throw null;
    }
}