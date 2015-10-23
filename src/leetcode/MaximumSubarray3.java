package leetcode;
/* Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 * For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
 * the contiguous subarray [4,−1,2,1] has the largest sum = 6. 
 * More practice:
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach,
 * which is more subtle.
 */
/* 假设数组A[left, right]存在最大值区间[i, j](i>=left & j<=right)，以mid = (left + right)/2 分界，无非以下三种情况：
 * subarray A[i,..j] is
 * (1) Entirely in A[low,mid-1]
 * (2) Entirely in A[mid+1,high]
 * (3) Across mid
 * 对于(1) and (2)，直接递归求解即可，对于(3)，则需要以min为中心，向左及向右扫描求最大值，意味着在A[left, Mid]区间中找出A[i..mid],
 * 而在A[mid+1, right]中找出A[mid+1..j]，两者加和即为(3)的解。
 */
public class MaximumSubarray3 {
	public int maxSubArray(int[] A) {
		return divide(A, 0, A.length - 1);
	}
	public int divide(int A[], int low, int high) {
		if (low == high)
			return A[low];
		if (low == high - 1)
			return Math.max(A[low] + A[high], Math.max(A[low], A[high]));
		int mid = (low + high) / 2;
		int lmax = divide(A, low, mid - 1);
		int rmax = divide(A, mid + 1, high);
		int mmax = A[mid];
		int tmp = mmax;
		for (int i = mid - 1; i >= low; i--) {
			tmp += A[i];
			if (tmp > mmax)
				mmax = tmp;
		}
		tmp = mmax;
		for (int i = mid + 1; i <= high; i++) {
			tmp += A[i];
			if (tmp > mmax)
				mmax = tmp;
		}
		return Math.max(mmax, Math.max(lmax, rmax));
	}
}
