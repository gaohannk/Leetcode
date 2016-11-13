package leetcode;

/* Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * For example,
 * Given [3,2,1,5,6,4] and k = 2, return 5.
 * Note: You may assume k is always valid, 1 ≤ k ≤ array's length.
 */

/// Large item is in front
public class KthLargestElementinanArray3 {
    public static int findKthLargest(int[] nums, int k) {
        return findKthLargestHelper(nums, 0, nums.length - 1, k);
    }

    private static int findKthLargestHelper(int[] nums, int start, int end, int k) {
        int pivotIndex = partition(nums, start, end);
        if (pivotIndex < k - 1)
            return findKthLargestHelper(nums, pivotIndex + 1, end, k);
        else if (pivotIndex > k - 1)
            return findKthLargestHelper(nums, start, pivotIndex - 1, k);
        return nums[k - 1];
    }

    private static int partition(int[] nums, int start, int end) {
        int pivotIndex = (int) (start + Math.random() * (end - start + 1));
        int pivotValue = nums[pivotIndex];
        swap(nums, pivotIndex, end);
        int front = start;
        for (int i = start; i < end; i++) {
            if (nums[i] > pivotValue) {
                // Switch item larger to front
                swap(nums, i, front);
                front++;
            }
        }
        swap(nums, front, end);
        return front;
    }

    public static void swap(int[] num, int a, int b) {
        int temp = num[a];
        num[a] = num[b];
        num[b] = temp;
    }
    public static void main(String[] args){
       // int[] nums ={2,1,4,7,5,1,2};
        int[] nums ={2,1};
        int k=2;
        System.out.println(findKthLargest(nums,k));
    }
}
