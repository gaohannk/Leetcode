package leetcode;

import java.util.Stack;

/* Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it is able to trap after raining.
 * For example,
 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 */
// Brute Force
public class TrappingRainWater4 {
    public int trap(int[] A) {
        int ans = 0, current = 0;
        Stack<Integer> st = new Stack<>();
        while (current < A.length) {
            while (!st.empty() && A[current] > A[st.peek()]) {
                int top = st.pop();
                if (st.empty())
                    break;
                int distance = current - st.peek() - 1;
                int bounded_height = Math.min(A[current], A[st.peek()]) - A[top];
                ans += distance * bounded_height;
            }
            st.push(current++);
        }
        return ans;
    }
}
