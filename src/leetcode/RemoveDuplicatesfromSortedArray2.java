package leetcode;
/* Given a sorted array, remove the duplicates in place such that each element appear only 
 * once and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * For example:
 * Given input array A = [1,1,2], Your function should return length = 2, and A is now [1,2].
*/
public class RemoveDuplicatesfromSortedArray2 {
	   
    public static int removeDuplicates(int[] A) {
        int count = 0;
        int len = A.length;
        for (int i = 0; i < len; i++) {
            if (count == 0 || A[i] != A[count - 1]) {
                A[count++] = A[i];
            }
        }
        return count;
    }
}
