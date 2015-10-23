package leetcode;

import java.util.Stack;

/* Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.
 */
public class MaximalRectangle {

	public int maximalRectangle(char[][] matrix) {
		if (matrix.length == 0)
			return 0;
		int maxArea = 0;
		int[] height = new int[matrix[0].length + 1];
		for (int i = 0; i < matrix.length; i++) {
			Stack<Integer> s = new Stack<Integer>();
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == '0')
					height[j] = 0;
				else
					height[j]++;
			}
			int j = 0;
			while (j < height.length) {
				if (s.empty() || height[j] > height[s.peek()])
					s.push(j++);
				else {
					int tmp = s.pop();
					maxArea = Math.max(maxArea, height[tmp] * (s.empty() ? j : j - s.peek() - 1));
				}
			}
		}
		return maxArea;
	}
}
