package leetcode;

/* Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. 
 * Please note that your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution.
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 */
/* 典型的双指针问题。
 * 初始化左指针left指向数组起始，初始化右指针right指向数组结尾。
 * 根据已排序这个特性，
 * 1）如果numbers[left]与numbers[right]的和tmp小于target，说明应该增加tmp,因此left右移指向一个较大的值。
 * 2）如果tmp大于target，说明应该减小tmp,因此right左移指向一个较小的值。
 * 3）tmp等于target，则找到，返回left+1和right+1。（注意以1为起始下标）
 * 时间复杂度O(n): 扫一遍
 * 空间复杂度O(1)
 */
public class TwoSumIIInputarrayissorted {
	public int[] twoSum(int[] numbers, int target) {
		int[] res = new int[] { -1, -1 };
		int start = 0;
		int end = numbers.length - 1;
		while (start < end) {
			int sum = numbers[start] + numbers[end];
			if (sum == target) {
				res[0] = start + 1;
				res[1] = end + 1;
				return res;
			} else if (sum > target) {
				end--;
			} else {
				start++;
			}
		}
		return res;
	}
}
