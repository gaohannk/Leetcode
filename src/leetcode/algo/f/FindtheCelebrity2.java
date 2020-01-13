package leetcode.algo.f;

import java.util.HashMap;
import java.util.Map;
// O(n^2)
public class FindtheCelebrity2 {
    public int findCelebrity(int n) {
        Map<Integer, Integer> inDegree = new HashMap();
        Map<Integer, Integer> outDegree = new HashMap();
        outDegree.put(-1, -1);
        int res = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && knows(i, j)) {
                    inDegree.put(j, inDegree.getOrDefault(j, 0) + 1);
                    outDegree.put(i, outDegree.getOrDefault(i, 0) + 1);
                    if (inDegree.get(j) == n - 1)
                        res = j;
                }
            }
        }
        return outDegree.containsKey(res) ? -1 : res;
    }

    private boolean knows(int p, int i) {
        return true;
    }
}
