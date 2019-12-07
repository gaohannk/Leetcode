package leetcode.algo.r;

/* Follow up for "Remove Duplicates":
 * What if duplicates are allowed at most twice?
 * For example:
 * Given sorted array A = [1,1,1,2,2,3],
 * Your function should return length = 5, and A is now [1,1,2,2,3].
 */
public class RemoveDuplicatesfromSortedArrayII3 {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;
        int stopIndex = 1, countSame = 0, prev = nums[0], curr = 0;
        for (int i = 1; i < nums.length; i++) {
            curr = nums[i];
            if (prev == curr) {
                countSame++;
            }
            else {
                countSame = 0;
            }
            if (countSame < 2) {
                nums[stopIndex++] = nums[i];
            }
            prev = curr;
        }
        return stopIndex;
    }
}
