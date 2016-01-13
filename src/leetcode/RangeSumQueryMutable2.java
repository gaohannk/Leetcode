package leetcode;

/* Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 * The update(i, val) function modifies nums by updating the element at index i to val.
 * Example:
 * Given nums = [1, 3, 5]
 * sumRange(0, 2) -> 9
 * update(1, 2)
 * sumRange(0, 2) -> 8
 * Note:
 * The array is only modifiable by the update function.
 * You may assume the number of calls to update and sumRange function is distributed evenly.
 */

public class RangeSumQueryMutable2 {
	static class SegmentTreeNode {
		public int start, end;
		public int sum;
		public SegmentTreeNode left, right;

		public SegmentTreeNode(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	public static class NumArray {
		public SegmentTreeNode root;

		public NumArray(int[] nums) {
			if (nums == null || nums.length == 0) {
				return;
			}
			root = buildTree(nums, 0, nums.length - 1);
		}

		public SegmentTreeNode buildTree(int[] nums, int left, int right) {
			SegmentTreeNode root = new SegmentTreeNode(left, right);
			if (left == right) {
				root.sum = nums[left];
			} else {
				int mid = left + (right - left) / 2;
				root.left = buildTree(nums, left, mid);
				root.right = buildTree(nums, mid + 1, right);
				root.sum = root.left.sum + root.right.sum;
			}
			return root;
		}

		void update(int i, int val) {
			update(root, i, val);
		}

		void update(SegmentTreeNode root, int i, int val) {
			if (root.start == root.end)
				root.sum = val;
			else {
				int mid = root.start + (root.end - root.start) / 2;
				if (i <= mid)
					update(root.left, i, val);
				else {
					update(root.right, i, val);
				}
				root.sum = root.left.sum + root.right.sum;
			}
		}

		public int sumRange(int i, int j) {
			return sumRange(this.root, i, j);
		}

		private int sumRange(SegmentTreeNode root, int start, int end) {
			if (root.start == start && root.end == end)
				return root.sum;
			else {
				int mid = root.start + (root.end - root.start) / 2;
				if (end <= mid)
					// search left but note that the range is still start to end
					return sumRange(root.left, start, end);
				else if (start > mid)
					return sumRange(root.right, start, end);
				else {
					return sumRange(root.left, start, root.left.end) + sumRange(root.right, root.right.start, end);
				}
			}
		}
	}

	public static void main(String[] args) {
		int nums[] = { 1, 3, 5 };
		NumArray numArray = new NumArray(nums);
		System.out.println(numArray.sumRange(0, 2));
		numArray.update(1, 10);
		System.out.println(numArray.sumRange(1, 2));
	}
}
