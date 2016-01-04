package leetcode;


/* Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 * Example:
 * Given nums = [-2, 0, 3, -5, 2, -1]
 * sumRange(0, 2) ->  1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * Note:You may assume that the array does not change.
 * There are many calls to sumRange function.
 * 
 */
public class RangeSumQueryImmutable2 {
	class SegmentTreeNode {
		public int start, end;
		public int sum;
		public SegmentTreeNode left, right;

		public SegmentTreeNode(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
	public class NumArray {
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
				else
					return sumRange(root.left, start, root.left.end) + sumRange(root.right, root.right.start, end);
			}
		}
	}
}

// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);
