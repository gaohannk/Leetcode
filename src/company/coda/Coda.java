package company.coda;

import java.io.*;
import java.util.*;

/**
 * You have a city where streets and avenues are perpendicular to each other. There are number of friends who are all located on various intersections.
 *
 * Given an aribitrary point X, Y find the total distance that every friend must travel to get to that point.
 *
 * Example points
 * Points = [[1, 1], [3, 3], [6, 1]]
 * Targets [5, 5] -> 17, [6, 6] -> 21
 *
 * Points = [[1, 2], [4, 5], [5, 5], [20, 10]]
 * Targets [5, 5] -> 28, [6, 6] -> 32
 *
 * Points = [[200, 40], [4, 5], [1, 2], [100, 20], [5, 8]]
 * Targets [5, 5] -> 351, [6, 6] -> 351
 *
 * Now find the point where the total distance traveled by everyone is minimized
 *
 * Points = [[1, 1], [3, 3], [6, 1]] -> [3, 1]
 * Points = [[1, 2], [4, 5], [5, 5], [20, 10]] → [4, 5]
 * Points = [[200, 40], [4, 5], [1, 2], [100, 20], [5, 8]] -> [5, 8]
 */

public class Coda {


    public static void main(String[] args) {
        // int[][] points = new int[][] {{1,1}, {3,3}, {6,1}};
        // int[] target = new int[] {6,6};
        // System.out.println(getTotalDistance(points, target));

        int[][] points = new int[][]{{1, 1}, {3, 3}, {4, 1}};
        int[] res = findMinPoint2(points);
        System.out.println(res[0] + "," + res[1]);

        points = new int[][]{{1, 2}, {4, 5}, {5, 5}, {20, 10}};
        res = findMinPoint2(points);
        System.out.println(res[0] + "," + res[1]);

    }

    public static int getTotalDistance(int[][] points, int[] target) {
        int total = 0;
        for (int[] point : points) {
            total += Math.abs(target[0] - point[0]) + Math.abs(target[1] - point[1]);
        }
        return total;
    }

    // Brute force
    // O(n * m * L) L is the total points
    public static int[] findMinPoint(int[][] points) {
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = 0;
        int maxY = 0;

        for (int[] point : points) {
            minX = Math.min(point[0], minX);
            minY = Math.min(point[1], minY);
            maxX = Math.max(point[0], maxX);
            maxY = Math.max(point[1], maxY);
        }

        int res = Integer.MAX_VALUE;
        int[] resPoint = new int[2];
        for (int i = minX; i <= maxX; i++) {
            for (int j = minY; j <= maxY; j++) {
                int temp = getTotalDistance(points, new int[]{i, j});
                if (res > temp) {
                    res = temp;
                    resPoint = new int[]{i, j};
                }
            }
        }
        return resPoint;
    }

    // O(n^2) + O(n^2) = O(n^2)
    public static int[] findMinPoint2(int[][] points) {
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int idx = 0;
        int idy = 0;
        // X
        for (int i = 0; i < points.length; i++) {
            int x = points[i][0];
            int sum = 0;
            // sum of distance
            for (int[] point : points) {
                sum += Math.abs(point[0] - x);
            }
            if (minX > sum) {
                minX = sum;
                idx = x;
            }
        }
        // Y
        for (int i = 0; i < points.length; i++) {
            int y = points[i][1];
            int sum = 0;
            for (int[] point : points) {
                sum += Math.abs(point[1] - y);
            }
            if (minY > sum) {
                minY = sum;
                idy = y;
            }
        }

        return new int[]{idx, idy};
    }
}
