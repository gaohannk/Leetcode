package leetcode;

/* Given an array with n objects colored red, white or blue, sort them so that objects of the same color 
 * are adjacent, with the colors in the order red, white and blue.
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * Note:
 * You are not suppose to use the library's sort function for this problem.
 * Follow up:
 * A rather straight forward solution is a two-pass algorithm using counting sort.
 * First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, 
 * then 1's and followed by 2's.
 * Could you come up with an one-pass algorithm using only constant space?
 */
/* Two-pass counting solution
 */
public class SortColors {
	public void sortColors(int[] A) {
		int red = 0, white = 0, blue = 0;
		final int RED = 0, WHITE = 1, BLUE = 2;
		int i;
		for (i = 0; i < A.length; i++) {
			if (A[i] == RED)
				red++;
			if (A[i] == WHITE)
				white++;
			if (A[i] == BLUE)
				blue++;
		}
		i = 0;
		while (i < A.length) {
			if (red-- != 0)
				A[i++] = 0;
			else
				break;
		}
		while (i < A.length) {
			if (white-- != 0)
				A[i++] = 1;
			else
				break;
		}
		while (i < A.length) {
			if (blue-- != 0)
				A[i++] = 2;
			else
				break;
		}
	}
}
