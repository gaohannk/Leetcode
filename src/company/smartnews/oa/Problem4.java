package company.smartnews.oa;

/*
A zero-indexed array A consisting of N integers is given. The elements of array A together represent a chain, and each element represents the strength of each link in the chain. We want to divide this chain into three smaller chains.
All we can do is to break the chain in exactly two non-adjacent positions. More precisely, we should break links P, Q (0 < P < Q < N - 1, Q - P > 1), resulting in three chains [0, P - 1], [P + 1, Q - 1], [Q + 1, N - 1]. The total cost of this operation is equal to A[P] + A[Q].
For example, consider array A such that:
  A[0] = 5
  A[1] = 2
  A[2] = 4
  A[3] = 6
  A[4] = 3
  A[5] = 7
We can choose to break the following links:
(1, 3): total cost is 2 + 6 = 8
(1, 4): total cost is 2 + 3 = 5
(2, 4): total cost is 4 + 3 = 7
Write a function:
class Solution { public int solution(int[] A); }
that, given a zero-indexed array A of N integers, returns the minimal cost of dividing chain into three pieces.
For example, given:
  A[0] = 5
  A[1] = 2
  A[2] = 4
  A[3] = 6
  A[4] = 3
  A[5] = 7
the function should return 5, as explained above.
 */
public class Problem4 {
    public static int Solution(int[] a) {
        int i = 3;
        int minSum = Integer.MAX_VALUE;
        int prev = a[2], prevPrev = a[1];
        // maintain two mimimum value
        // the order is prevPrev, prev, a[i]
        // prev is min without space in the middle (adjacent)
        // prevPrev is min at one least space between
        while (i < a.length - 1) {
            minSum = Math.min(minSum, a[i] + prevPrev);
            if (prev < prevPrev) {
                prevPrev = prev;
            }
            if (a[i] < prev) {
                prev = a[i];

            }
            i++;
        }
        return minSum;
    }

    public static void main(String[] args) {
        System.out.println(Solution(new int[]{1, -1, 2, 5, 8, 3, 3, 0, 4}));
    }
}
