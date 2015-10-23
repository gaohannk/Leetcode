package leetcode;
/* There are two sorted arrays A and B of size m and n respectively. 
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 */
public class MedianofTwoSortedArrays2 {
	public double findMedianSortedArrays(int A[], int B[]) {
        int k = A.length + B.length;
        return k % 2 == 0 ?  (findK(A, 0, A.length - 1, B, 0, B.length - 1, k/2 + 1) + 
        findK(A, 0, A.length - 1, B, 0, B.length - 1, k/2)) / 2
        : findK(A, 0, A.length - 1, B, 0, B.length - 1, k/2 + 1);
    }
 
    public double findK(int a[], int s1, int e1, int b[], int s2, int e2, int k) {
        int m = e1 - s1 + 1;
        int n = e2 - s2 + 1;
        if (m > n) return findK(b, s2, e2, a, s1, e1, k); 
        if (s1 > e1) return b[s2 + k - 1]; 
        if (s2 > e2) return a[s1 + k - 1];
        if (k == 1) return Math.min(a[s1], b[s2]);
        int midA = Math.min(k/2, m), midB = k - midA; 
  
        if (a[s1 + midA - 1] < b[s2 + midB - 1]) 
            return findK(a, s1 + midA, e1, b, s2, e2, k - midA);
        else if (a[s1 + midA - 1] > b[s2 + midB - 1]) 
            return findK(a, s1, e1, b, s2 + midB, e2, k - midB);
        else
            return a[s1 + midA - 1];
    }
}
