package leetcode.algo.m;

import java.util.TreeMap;

/**
 * Implement a MyCalendarThree class to store your events. A new event can always be added.
 *
 * Your class will have one method, book(int start, int end). Formally, this represents a booking on the half open interval [start, end), the range of real numbers x such that start <= x < end.
 *
 * A K-booking happens when K events have some non-empty intersection (ie., there is some time that is common to all K events.)
 *
 * For each call to the method MyCalendar.book, return an integer K representing the largest integer such that there exists a K-booking in the calendar.
 *
 * Your class will be called like this: MyCalendarThree cal = new MyCalendarThree(); MyCalendarThree.book(start, end)
 * Example 1:
 *
 * MyCalendarThree();
 * MyCalendarThree.book(10, 20); // returns 1
 * MyCalendarThree.book(50, 60); // returns 1
 * MyCalendarThree.book(10, 40); // returns 2
 * MyCalendarThree.book(5, 15); // returns 3
 * MyCalendarThree.book(5, 10); // returns 3
 * MyCalendarThree.book(25, 55); // returns 3
 * Explanation:
 * The first two events can be booked and are disjoint, so the maximum K-booking is a 1-booking.
 * The third event [10, 40) intersects the first event, and the maximum K-booking is a 2-booking.
 * The remaining events cause the maximum K-booking to be only a 3-booking.
 * Note that the last event locally causes a 2-booking, but the answer is still 3 because
 * eg. [10, 20), [10, 40), and [5, 15) are still triple booked.
 *
 *
 * Note:
 *
 * The number of calls to MyCalendarThree.book per test case will be at most 400.
 * In calls to MyCalendarThree.book(start, end), start and end are integers in the range [0, 10^9].
 */
// TODO review
public class MyCalendarIII2 {
    class MyCalendarThree {

        SegmentTree segmentTree;

        public MyCalendarThree() {
            segmentTree = new SegmentTree(0, 1000000000);
        }

        public int book(int start, int end) {
            segmentTree.add(start, end, 1);
            return segmentTree.getMax();
        }
    }

    class SegmentTree {
        TreeNode root;

        public SegmentTree(int left, int right) {
            root = new TreeNode(left, right);
        }

        public void add(int start, int end, int val) {
            TreeNode event = new TreeNode(start, end);
            add(root, event, val);
        }

        private void add(TreeNode root, TreeNode event, int val) {
            if (root == null) {
                return;
            }
            /**
             * If current node's range lies completely in update query range.
             */
            if (root.inside(event)) {
                root.booked += val;
                root.savedres += val;
            }
            /**
             * If current node's range overlaps with update range, follow the same approach as above simple update.
             */
            if (root.intersect(event)) {
                // Recur for left and right children.
                int mid = (root.start + root.end) / 2;
                if (root.left == null) {
                    root.left = new TreeNode(root.start, mid);
                }
                add(root.left, event, val);
                if (root.right == null) {
                    root.right = new TreeNode(mid, root.end);
                }
                add(root.right, event, val);
                // Update current node using results of left and right calls.
                root.savedres = Math.max(root.left.savedres, root.right.savedres) + root.booked;
            }
        }

        public int getMax() {
            return root.savedres;
        }

        /**
         * find maximum for nums[i] (start <= i <= end) is not required.
         * so i did not implement it.
         */
        public int get(int start, int right) {
            return 0;
        }

        class TreeNode {
            int start, end;
            TreeNode left = null, right = null;
            /**
             * How much number is added to this interval(node)
             */
            int booked = 0;
            /**
             * The maximum number in this interval(node).
             */
            int savedres = 0;

            public TreeNode(int s, int t) {
                this.start = s;
                this.end = t;
            }

            public boolean inside(TreeNode b) {
                if (b.start <= start && end <= b.end) {
                    return true;
                }
                return false;
            }

            public boolean intersect(TreeNode b) {
                if (inside(b) || end <= b.start || b.end <= start) {
                    return false;
                }
                return true;
            }
        }
    }
}
