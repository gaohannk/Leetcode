package leetcode;

/* Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
 * Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
 * The largest rectangle is shown in the shaded area, which has area = 10 unit.
 * For example,
 * Given height = [2,1,5,6,2,3],
 * return 10.
 */
public class LargestRectangleinHistogram {
	public int largestRectangleArea(int[] height) {
		int maxV = 0;
		for (int i = 0; i < height.length; i++) {
			int minheight = height[i];
			for (int j = i+1; j >= 0; j--) {
				minheight = Math.min(minheight, height[j]);
				int area = minheight * (i - j + 1);
				if (area > maxV)
					maxV = area;
			}
		}
		return maxV;
	}
}
