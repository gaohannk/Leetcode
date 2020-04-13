package company.microsoft.oa;

import java.util.HashMap;
import java.util.Map;

public class MaxNetworkRank {
    private static int countEdges(int[] A, int[] B, int N) {
        int[] edgeCount = new int[N];

        for (int i = 0; i < A.length; i++) {
            edgeCount[A[i] - 1]++;
            edgeCount[B[i] - 1]++;
        }

        int maxRank = 0;
        for (int i = 0; i < A.length; i++) {
            int rank = edgeCount[A[i] - 1] + edgeCount[B[i] - 1] - 1;
            if (rank > maxRank)
                maxRank = rank;
        }
        return maxRank;
    }

    private static int countEdges2(int[] A, int[] B, int N) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < A.length; i++) {
            map.put(A[i], map.getOrDefault(A[i], 0));
            map.put(A[i], map.getOrDefault(B[i], 0));
        }
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            //extra -1 as the road is counted twice
            max = Math.max(map.get(A[i]) + map.get(B[i]) - 1, max);
        }
        return max;
    }
}
