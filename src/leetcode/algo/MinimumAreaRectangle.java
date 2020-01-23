package leetcode.algo;

import java.util.*;

public class MinimumAreaRectangle {
    public int minAreaRect(int[][] points) {
        Map<Integer, List<Integer>> rows = new TreeMap();
        for (int[] point : points) {
            int x = point[0], y = point[1];
            if (rows.get(x) == null) {
                rows.put(x, new LinkedList<>());
            }
            rows.get(x).add(y);
        }

        int ans = Integer.MAX_VALUE;
        Map<String, Integer> lastx = new HashMap();
        for (int x : rows.keySet()) {
            List<Integer> row = rows.get(x);
            Collections.sort(row);
            for (int i = 0; i < row.size(); ++i)
                for (int j = i + 1; j < row.size(); ++j) {
                    int y1 = row.get(i), y2 = row.get(j);
                    String key = y1 + "," + y2;
                    if (lastx.containsKey(key)) {
                        ans = Math.min(ans, (x - lastx.get(key)) * (y2 - y1));
                    }
                    lastx.put(key, x);
                }
        }

        return ans < Integer.MAX_VALUE ? ans : 0;
    }
}
