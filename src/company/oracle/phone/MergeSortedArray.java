package company.oracle.phone;

/* Given two sorted integer arrays A and B, merge B into A as one sorted array.
 * Note:
 * You may assume that A has enough space (size that is greater or equal to m + n) to hold additional elements from B.
 * The number of elements initialized in A and B are m and n respectively.
 */
public class MergeSortedArray {
    public void merge(int A[], int m, int B[], int n) {
        int i = m + n - 1;
        int p1 = m - 1;
        int p2 = n - 1;
        while (p1 >= 0 && p2 >= 0) {
            A[i--] = A[p1] > B[p2] ? A[p1--] : B[p2--];
        }
        while (p2 >= 0) {
            A[i--] = B[p2--];
        }
    }
}
