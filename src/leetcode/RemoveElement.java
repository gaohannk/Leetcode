package leetcode;

/* Given an array and a value, remove all instances of that value in place and return the new length.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length
 */
public class RemoveElement {
	public int removeElement(int[] A, int elem) {
		int begin = 0;
		int end = A.length - 1;
		while (begin <= end) {
			if (A[begin] != elem)
				begin++;
			else if (A[end] == elem)
				end--;
			else
				A[begin++] = A[end--];
		}
		return begin;
	}
}
