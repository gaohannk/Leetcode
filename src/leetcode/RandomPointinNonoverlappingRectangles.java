package leetcode;

import java.util.HashMap;
import java.util.Random;

/**
 * Given a list of non-overlapping axis-aligned rectangles rects, write a function pick which randomly and uniformily picks a point in the space covered by the rectangles.
 * <p>
 * Note:
 * <p>
 * input corner coordinates and the returned point coordinates are integers.
 * return point coordinates as a size 2 array [p_x, p_y]
 * a point on the border of a rectangle is considered to be covered.
 * it is guaranteed that the borders of rectangles in rects will not overlap.
 * rects[i] = [x1,y1,x2,y2], where [x1, y1] are the coordinates of the bottom-left corner, and [x2, y2] are the coordinates of the top-right corner of the ith rectangle, and  x2 - x1 <= 2000 && y2 - y1 <= 2000
 * 1 <= len(rects) <= 100
 * pick is called at most 10000 times.
 * Example 1:
 * <p>
 * Input:
 * ["MinDeleteNoMoreThanThree","pick","pick","pick"]
 * [[[[1,1,5,5]]],[],[],[]]
 * Output: [null,[4,1],[1,1],[5,4]]
 * Example 2:
 * <p>
 * Input:
 * ["MinDeleteNoMoreThanThree","pick","pick","pick","pick","pick"]
 * [[[[-2,-7,3,-1],[3,-6,10,10]]],[],[],[],[],[]]
 * Output: [null,[9,-6],[-1,-3],[-1,-2],[-1,-4],[-2,-1]]
 */
public class RandomPointinNonoverlappingRectangles {

    HashMap<int[], int[]> set = new HashMap<>();
    Random rand = new Random();
    int totalArea;

    public RandomPointinNonoverlappingRectangles(int[][] rects) {
        int area = 0, oldArea;
        for (int[] rect : rects) {
            oldArea = area;
            area += (rect[2] - rect[0]) * (rect[3] - rect[0]);
            set.putIfAbsent(new int[]{oldArea, area}, rect);
        }
        this.totalArea = area;
    }

    public int[] pick() {
        int area = rand.nextInt(totalArea);
        int[] rect = null;
        for (int[] areaKey : set.keySet()) {
            if (area >= areaKey[0] && area < areaKey[1]) {
                rect = set.get(areaKey);
                break;
            }
        }
        int x = (int) (rect[0] + rand.nextDouble() * (rect[2] - rect[0]));
        int y = (int) (rect[1] + rand.nextDouble() * (rect[3] - rect[1]));

        return new int[]{x, y};
    }
    public static void main(String[] args){
        int[][] rects = {{1, 1, 5, 5}};
        int num =100;
        RandomPointinNonoverlappingRectangles r = new RandomPointinNonoverlappingRectangles(rects);
        while(num-- >0){
            int[] p  = r.pick();
            System.out.println(p[0]+","+p[1]);
        }
    }
}