package company.google.phone;

public class ValidSubArray {
    /**
     * Please use this Google doc during your interview (your interviewer will see what you write here). To free your hands for typing, we recommend using a headset or speakerphone.
     *
     * Given an array A of length N: A[0]..A[N-1]. Each element A[i] can only be a 0 or 1.
     * If a sub-array only contains 0, we call it valid.
     * How many valid sub-arrays are there in A?
     *
     * For example, A = [0, 0, 1, 0, 0, 0], there are 9 valid sub-arrays.
     * Length 1: A[0] A[1] A[3] A[4] A[5]
     * Length 2: A[0-1] A[3-4] A[4-5]
     * Length 3: A[3-5]
     */

    public int solution(int[] A) {
        int n = A.length;
        int res = 0;
        if (A == null || A.length == 0) {
            return res;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < n - i; j++) {
                int start = j;
                boolean flag = true;
                while (start < j + i) {
                    if (A[start] == 0) {
                        start++;
                        continue;
                    } else {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    res++;
                }
            }
        }
        return res;
    }
}
