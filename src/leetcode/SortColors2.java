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
/* One-pass solution
 */
public class SortColors2 {
	public void sortColors(int[] A) {
		int redpt = 0, bluept = A.length - 1;
		int i = 0;
		final int RED = 0, BLUE = 2;
		// stop looping when current >= bluept
		while (i <= bluept) {
			// if color is RED, move to the front
			if (A[i] == RED) {
				swap(A, redpt, i);
				redpt++;
				i++;
				continue;
			} else if (A[i] == BLUE) { // if color is BLUE, move to the end
				swap(A, bluept, i);
				bluept--;
				continue;
			} else {
				i++; // if color is WHITE, don't move
			}
		}
	}

	public void swap(int[] A, int from, int to) {
		int tmp = A[from];
		A[from] = A[to];
		A[to] = tmp;
	}
}
