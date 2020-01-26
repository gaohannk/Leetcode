package leetcode.algo.m;

import java.util.*;

public class MinimumAreaRectangle2 {
    public int minAreaRect(int[][] points) {
        Set<String> pointSet = new HashSet();
        for (int[] point : points)
            pointSet.add(point[0] + "," + point[1]);

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; ++i)
            for (int j = i + 1; j < points.length; ++j) {
                if (points[i][0] != points[j][0] && points[i][1] != points[j][1]) {
                    if (pointSet.contains(points[i][0] + "," + points[j][1]) &&
                            pointSet.contains(points[j][0] + "," + points[i][1])) {
                        ans = Math.min(ans, Math.abs(points[j][0] - points[i][0]) *
                                Math.abs(points[j][1] - points[i][1]));
                    }
                }
            }

        return ans < Integer.MAX_VALUE ? ans : 0;
    }
}
