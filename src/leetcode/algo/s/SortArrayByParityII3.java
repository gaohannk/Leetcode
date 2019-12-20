package leetcode.algo.s;

public class SortArrayByParityII3 {
    public int[] sortArrayByParityII(int[] A) {
        int j = 1;
        for (int i = 0; i < A.length; i += 2) {
            if (A[i] % 2 == 1) {
                while (A[j] % 2 != 0) {
                    j += 2;
                }
                swap(A, j, i);
            }
        }
        return A;
    }

    public void swap(int[] A, int j, int i) {
        int temp = A[j];
        A[j] = A[i];
        A[i] = temp;
    }
}
