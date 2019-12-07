package leetcode.algo.p;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 886. Possible Bipartition
 * Given a set of N people (numbered 1, 2, ..., N), we would like to split everyone into two groups of any size.
 * <p>
 * Each person may dislike some other people, and they should not go into the same group.
 * <p>
 * Formally, if dislikes[i] = [a, b], it means it is not allowed to put the people numbered a and b into the same group.
 * <p>
 * Return true if and only if it is possible to split everyone into two groups in this way.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: N = 4, dislikes = [[1,2],[1,3],[2,4]]
 * Output: true
 * Explanation: group1 [1,4], group2 [2,3]
 * Example 2:
 * <p>
 * Input: N = 3, dislikes = [[1,2],[1,3],[2,3]]
 * Output: false
 * Example 3:
 * <p>
 * Input: N = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
 * Output: false
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= N <= 2000
 * 0 <= dislikes.length <= 10000
 * 1 <= dislikes[i][j] <= N
 * dislikes[i][0] < dislikes[i][1]
 * There does not exist i != j for which dislikes[i] == dislikes[j].
 */
public class PossibleBipartition {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        ArrayList<Integer>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; ++i)
            graph[i] = new ArrayList();

        // Find all dislike person for each person
        // 1 dislike a,b,c
        // 2 dislike d,e,f
        for (int[] edge : dislikes) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        Map<Integer, Integer> assignMap = new HashMap();
        for (int node = 1; node <= N; node++)
            if (!assignMap.containsKey(node) && !dfs(node, 0, assignMap, graph))
                return false;
        return true;
    }

    public boolean dfs(int node, int c, Map<Integer, Integer> color, ArrayList<Integer>[] graph) {
        if (color.containsKey(node))
            return color.get(node) == c;
        color.put(node, c);

        for (int nei : graph[node])
            if (!dfs(nei, c ^ 1, color, graph))
                return false;
        return true;
    }
}
