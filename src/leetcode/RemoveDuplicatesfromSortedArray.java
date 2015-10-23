package leetcode;

/* Given a sorted array, remove the duplicates in place such that each element appear only 
 * once and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * For example:
 * Given input array A = [1,1,2], Your function should return length = 2, and A is now [1,2].
 */
import java.util.*;

public class RemoveDuplicatesfromSortedArray {
	public int removeDuplicates(int[] A) {
		HashSet<Integer> set = new HashSet<Integer>();
		int count = 0;
		for (int i = 0; i < A.length; i++) {
			if (!set.contains(A[i])) {
				set.add(A[i]);
				A[count++] = A[i];
			}
		}
		return count;
	}
}
