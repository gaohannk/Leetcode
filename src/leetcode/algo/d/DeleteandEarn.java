package leetcode.algo.d;

// TODO understand
public class DeleteandEarn {
    public int deleteAndEarn(int[] nums) {
        int[] count = new int[10001];
        for (int i : nums) {
            count[i]++;
        }
        int avoid = 0, using = 0, prev = -1;

        for (int i = 0; i <= 10000; ++i) {
            if (count[i] > 0) {
                int m = Math.max(avoid, using);
                if (i - 1 != prev) {
                    using = i * count[i] + m;
                    avoid = m;
                } else {
                    using = i * count[i] + avoid;
                    avoid = m;
                }
                prev = i;
            }
        }
        return Math.max(avoid, using);
    }
}
