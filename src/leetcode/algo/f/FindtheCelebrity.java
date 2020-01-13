package leetcode.algo.f;

public class FindtheCelebrity {
    public int findCelebrity(int n) {
        int p = 0;
        for (int i = 1; i < n && p < n; i++) {
            if (p != i && knows(p, i)) {
                p = i;

            }
        }

        for (int i = 0; i < n; i++) {
            if (i != p && knows(p, i) || !knows(i, p)) {
                return -1;
            }
        }

        return p;
    }

    private boolean knows(int p, int i) {
        return true;
    }
}