package leetcode.algo.d;

/**
 * Given a string S that only contains "I" (increase) or "D" (decrease), let N = S.length.
 * <p>
 * Return any permutation A of [0, 1, ..., N] such that for all i = 0, ..., N-1:
 * <p>
 * If S[i] == "I", then A[i] < A[i+1]
 * If S[i] == "D", then A[i] > A[i+1]
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: "IDID"
 * Output: [0,4,1,3,2]
 * Example 2:
 * <p>
 * Input: "III"
 * Output: [0,1,2,3]
 * Example 3:
 * <p>
 * Input: "DDI"
 * Output: [3,2,0,1]
 */
public class DIStringMatch {
    public int[] diStringMatch(String S) {
        int N = S.length();
        int low = 0, high = N;
        int[] ans = new int[N + 1];
        for (int i = 0; i < N; i++) {
            if (S.charAt(i) == 'I')
                ans[i] = low++;
            else
                ans[i] = high--;
        }

        ans[N] = low;
        return ans;
    }
}
