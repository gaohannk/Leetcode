package leetcode;

/* Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
 * Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
 * The largest rectangle is shown in the shaded area, which has area = 10 unit.
 * For example,
 * Given height = [2,1,5,6,2,3],
 * return 10.
 */
public class LargestRectangleinHistogram2 {
	public int largestRectangleArea(int[] height) {
		int maxV = 0;
		for (int i = 0; i < height.length; i++) {
			if (i + 1 < height.length && height[i] <= height[i + 1])			
				continue;
			int minV = height[i];
			for (int j = i; j >= 0; j--) {
				minV = Math.min(minV, height[j]);
				int area = minV * (i - j + 1);
				if (area > maxV)
					maxV = area;
			}
		}
		return maxV;
	}
}
